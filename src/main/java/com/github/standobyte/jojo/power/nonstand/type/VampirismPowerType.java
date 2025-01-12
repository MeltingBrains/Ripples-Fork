package com.github.standobyte.jojo.power.nonstand.type;

import java.util.Map;
import java.util.function.IntBinaryOperator;

import com.github.standobyte.jojo.JojoModConfig;
import com.github.standobyte.jojo.action.non_stand.VampirismAction;
import com.github.standobyte.jojo.init.ModEffects;
import com.github.standobyte.jojo.init.ModNonStandPowers;
import com.github.standobyte.jojo.power.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.stand.IStandPower;
import com.github.standobyte.jojo.util.utils.JojoModUtil;
import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionRemoveEvent;

public class VampirismPowerType extends NonStandPowerType<VampirismFlags> {
    private static Map<Effect, IntBinaryOperator> EFFECTS_AMPLIFIERS;
    
    public static void initVampiricEffectsMap() {
        EFFECTS_AMPLIFIERS = ImmutableMap.<Effect, IntBinaryOperator>builder()
                .put(ModEffects.UNDEAD_REGENERATION.get(), (bl, diff) -> bl - 2)
                .put(Effects.HEALTH_BOOST, (bl, diff) -> diff * 5 - 1)
                .put(Effects.DAMAGE_BOOST, (bl, diff) -> bl - 4)
                .put(Effects.MOVEMENT_SPEED, (bl, diff) -> bl - 4)
                .put(Effects.DIG_SPEED, (bl, diff) -> bl - 4)
                .put(Effects.JUMP, (bl, diff) -> bl - 4)
                .put(Effects.DAMAGE_RESISTANCE, (bl, diff) -> bl - 5)
                .put(Effects.NIGHT_VISION, (bl, diff) -> 0)
                .build();
    }

    public VampirismPowerType(int color, VampirismAction[] startingAttacks, VampirismAction[] startingAbilities) {
        super(color, startingAttacks, startingAbilities, VampirismFlags::new);
    }
    
    @Override
    public boolean keepOnDeath(INonStandPower power) {
        return JojoModConfig.getCommonConfigInstance(false).keepVampirismOnDeath.get() && power.getTypeSpecificData(this).get().isVampireAtFullPower();
    }
    
    @Override
    public void afterClear(INonStandPower power) {
        LivingEntity user = power.getUser();
        for (Map.Entry<Effect, IntBinaryOperator> entry : EFFECTS_AMPLIFIERS.entrySet()) {
            EffectInstance effectInstance = user.getEffect(entry.getKey());
            if (effectInstance != null && !effectInstance.isVisible() && !effectInstance.showIcon()) {
                user.removeEffect(effectInstance.getEffect());
            }
        }
    }
    
    @Override
    public float getMaxEnergyFactor(INonStandPower power) {
        World world = power.getUser().level;
        return JojoModUtil.getOrLast(
                JojoModConfig.getCommonConfigInstance(world.isClientSide()).maxBloodMultiplier.get(), world.getDifficulty().getId())
                .floatValue();
    }

    @Override
    public float getEnergyTickInc(INonStandPower power) {
        World world = power.getUser().level;
        return -JojoModUtil.getOrLast(
                JojoModConfig.getCommonConfigInstance(world.isClientSide()).bloodTickDown.get(), world.getDifficulty().getId())
                .floatValue();
    }
    
    @Override
    public float getMaxStaminaFactor(INonStandPower power, IStandPower standPower) {
        return Math.max((bloodLevel(power) - 3) * 2, 1);
    }

    @Override
    public float getStaminaRegenFactor(INonStandPower power, IStandPower standPower) {
        return Math.max((bloodLevel(power) - 3) * 4, 1);
    }

    private static int bloodLevel(INonStandPower power) {
        return bloodLevel(power, power.getUser().level.getDifficulty().getId());
    }
    
    // full blood bar on normal => 6
    public static int bloodLevel(INonStandPower power, int difficulty) {
        if (difficulty == 0) {
            return -1;
        }
        int bloodLevel = Math.min((int) (power.getEnergy() / power.getMaxEnergy() * 5F), 4);
        bloodLevel += difficulty;
        if (!power.getTypeSpecificData(ModNonStandPowers.VAMPIRISM.get()).get().isVampireAtFullPower()) {
            bloodLevel = Math.max(bloodLevel - 2, 1);
        }
        return bloodLevel;
    }

    @Override
    public void tickUser(LivingEntity entity, INonStandPower power) {
        if (!entity.level.isClientSide()) {
            if (entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).getFoodData().setFoodLevel(17);
            }
            entity.setAirSupply(entity.getMaxAirSupply());
            int difficulty = entity.level.getDifficulty().getId();
            int bloodLevel = bloodLevel(power, difficulty);
            if (power.getTypeSpecificData(this).get().refreshBloodLevel(bloodLevel)) {
                for (Map.Entry<Effect, IntBinaryOperator> entry : EFFECTS_AMPLIFIERS.entrySet()) {
                    Effect effect = entry.getKey();
                    int amplifier = entry.getValue().applyAsInt(bloodLevel, difficulty);
                    float missingHp = effect == Effects.HEALTH_BOOST ? entity.getMaxHealth() - entity.getHealth() : -1;
                    if (amplifier >= 0) {
                        entity.removeEffectNoUpdate(effect);
                        entity.addEffect(new EffectInstance(entry.getKey(), Integer.MAX_VALUE, amplifier, false, false));
                    }
                    else {
                        entity.removeEffect(effect);
                    }
                    if (missingHp > -1) {
                        entity.setHealth(entity.getMaxHealth() - missingHp);
                    }
                }
            }
        }
    }

    @Override
    public boolean isReplaceableWith(NonStandPowerType<?> newType) {
        return false;
    }

    @Override
    public float getTargetResolveMultiplier(INonStandPower power, IStandPower attackingStand) {
        LivingEntity entity = power.getUser();
        if (entity != null) {
            return (float) Math.pow(2, Math.max(entity.level.getDifficulty().getId() - 1, 0));
        }
        return 1;
    }
    
    @Override
    public boolean isLeapUnlocked(INonStandPower power) {
        return true;
    }
    
    @Override
    public float getLeapStrength(INonStandPower power) {
        VampirismFlags vampirism = power.getTypeSpecificData(this).get();
        float leapStrength = Math.max(bloodLevel(power), 0);
        if (!vampirism.isVampireAtFullPower()) {
            leapStrength *= 0.25F;
        }
        return leapStrength * 0.4F;
    }
    
    @Override
    public int getLeapCooldownPeriod() {
        return 100;
    }
    
    @Override
    public float getLeapEnergyCost() {
        return 0;
    }

    
    
    public static void cancelVampiricEffectRemoval(PotionRemoveEvent event) {
        EffectInstance effectInstance = event.getPotionEffect();
        if (effectInstance != null) {
            LivingEntity entity = event.getEntityLiving();
            INonStandPower.getNonStandPowerOptional(entity).ifPresent(power -> {
                if (power.getTypeSpecificData(ModNonStandPowers.VAMPIRISM.get()).isPresent()) {
                    int difficulty = entity.level.getDifficulty().getId();
                    int bloodLevel = bloodLevel(power, difficulty);
                    Effect effect = event.getPotion();
                    if (EFFECTS_AMPLIFIERS.containsKey(effect) && EFFECTS_AMPLIFIERS.get(effect).applyAsInt(bloodLevel, difficulty) == effectInstance.getAmplifier() && 
                            !effectInstance.isVisible() && !effectInstance.showIcon()) {
                        event.setCanceled(true);
                    }
                }
            });
        }
    }
    
    public static void consumeEnergyOnHeal(LivingHealEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.isAlive()) {
            INonStandPower.getNonStandPowerOptional(entity).ifPresent(power -> {
                if (power.getType() == ModNonStandPowers.VAMPIRISM.get()) {
                    float healCost = healCost(entity.level);
                    if (healCost > 0) {
                        float actualHeal = Math.min(event.getAmount(), power.getEnergy() / healCost);
                        actualHeal = Math.min(actualHeal, entity.getMaxHealth() - entity.getHealth());
                        if (actualHeal > 0) {
                            power.consumeEnergy(Math.min(actualHeal, entity.getMaxHealth() - entity.getHealth()) * healCost);
                            event.setAmount(actualHeal);
                        }
                        else {
                            event.setCanceled(true);
                        }
                    }
                }
            });
        }
    }
    
    public boolean isHighOnBlood(LivingEntity entity) {
    	return INonStandPower.getNonStandPowerOptional(entity).map(power -> {
        	return power.getType() == this && power.getEnergy() / power.getMaxEnergy() >= 0.8F;
        }).orElse(false);
    }
    
    public static float healCost(World world) {
    	return JojoModUtil.getOrLast(
                JojoModConfig.getCommonConfigInstance(world.isClientSide()).bloodHealCost.get(), 
                world.getDifficulty().getId()).floatValue();
    }
    
    // TODO smite enchantment damage
}
