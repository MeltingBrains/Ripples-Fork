package com.github.standobyte.jojo.action.non_stand;

import java.util.List;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.init.ModNonStandPowers;
import com.github.standobyte.jojo.power.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.nonstand.type.HamonData;
import com.github.standobyte.jojo.power.nonstand.type.HamonPowerType;
import com.github.standobyte.jojo.power.nonstand.type.HamonSkill.HamonStat;
import com.github.standobyte.jojo.util.damage.DamageUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeMod;

public class HamonTornadoOverdrive extends HamonAction {

    public HamonTornadoOverdrive(HamonAction.Builder builder) {
        super(builder.holdType());
    }
     
    @Override
    protected void holdTick(World world, LivingEntity user, INonStandPower power, int ticksHeld, ActionTarget target, boolean requirementsFulfilled) {
        if (requirementsFulfilled) {
            user.fallDistance = 0;
            Vector3d movement = user.getDeltaMovement();
            HamonData hamon = power.getTypeSpecificData(ModNonStandPowers.HAMON.get()).get();
            if (!world.isClientSide()) {
                AxisAlignedBB aabb = user.getBoundingBox().expandTowards(movement).inflate(1.0D);
                float damage = 0.1F;
                double gravity = user.getAttributeValue(ForgeMod.ENTITY_GRAVITY.get());
                if (movement.y < -gravity) {
                    damage *= (-movement.y / gravity) * 0.75F;
                }
                List<Entity> targets = user.level.getEntities(user, aabb);
                boolean points = false;
                for (Entity entity : targets) {
                    if (DamageUtil.dealHamonDamage(entity, damage, user, null)) {
                        points = true;
                    }
                }
                if (points) {
                    hamon.hamonPointsFromAction(HamonStat.STRENGTH, getHeldTickEnergyCost());
                }
            }
            if (user.isShiftKeyDown()) {
                user.setDeltaMovement(0, movement.y < 0 ? movement.y * 1.05 : 0, 0);
            }
            HamonPowerType.createHamonSparkParticles(world, user instanceof PlayerEntity ? (PlayerEntity) user : null, user.position(), 
                    hamon.getHamonDamageMultiplier() / HamonData.MAX_HAMON_DAMAGE * 0.25F);
        }
    }
    
    @Override
    public boolean isHeldSentToTracking() {
        return true;
    }
}
