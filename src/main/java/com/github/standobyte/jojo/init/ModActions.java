package com.github.standobyte.jojo.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.JojoMod;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.non_stand.HamonAction;
import com.github.standobyte.jojo.action.non_stand.HamonBubbleBarrier;
import com.github.standobyte.jojo.action.non_stand.HamonBubbleCutter;
import com.github.standobyte.jojo.action.non_stand.HamonBubbleLauncher;
import com.github.standobyte.jojo.action.non_stand.HamonCutter;
import com.github.standobyte.jojo.action.non_stand.HamonDetector;
import com.github.standobyte.jojo.action.non_stand.HamonHealing;
import com.github.standobyte.jojo.action.non_stand.HamonLifeMagnetism;
import com.github.standobyte.jojo.action.non_stand.HamonOrganismInfusion;
import com.github.standobyte.jojo.action.non_stand.HamonOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonOverdriveBarrage;
import com.github.standobyte.jojo.action.non_stand.HamonPlantInfusion;
import com.github.standobyte.jojo.action.non_stand.HamonProjectileShield;
import com.github.standobyte.jojo.action.non_stand.HamonRepellingOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonScarletOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonSendoOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonSpeedBoost;
import com.github.standobyte.jojo.action.non_stand.HamonSunlightYellowOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonTornadoOverdrive;
import com.github.standobyte.jojo.action.non_stand.HamonWallClimbing;
import com.github.standobyte.jojo.action.non_stand.HamonZoomPunch;
import com.github.standobyte.jojo.action.non_stand.NonStandAction;
import com.github.standobyte.jojo.action.non_stand.VampirismAction;
import com.github.standobyte.jojo.action.non_stand.VampirismBloodDrain;
import com.github.standobyte.jojo.action.non_stand.VampirismBloodGift;
import com.github.standobyte.jojo.action.non_stand.VampirismDarkAura;
import com.github.standobyte.jojo.action.non_stand.VampirismFreeze;
import com.github.standobyte.jojo.action.non_stand.VampirismHamonSuicide;
import com.github.standobyte.jojo.action.non_stand.VampirismSpaceRipperStingyEyes;
import com.github.standobyte.jojo.action.non_stand.VampirismZombieSummon;
import com.github.standobyte.jojo.action.stand.CrazyDiamondBlockBullet;
import com.github.standobyte.jojo.action.stand.CrazyDiamondBlockCheckpointMake;
import com.github.standobyte.jojo.action.stand.CrazyDiamondBlockCheckpointMove;
import com.github.standobyte.jojo.action.stand.CrazyDiamondBloodCutter;
import com.github.standobyte.jojo.action.stand.CrazyDiamondHeal;
import com.github.standobyte.jojo.action.stand.CrazyDiamondHeavyPunch;
import com.github.standobyte.jojo.action.stand.CrazyDiamondLeaveObject;
import com.github.standobyte.jojo.action.stand.CrazyDiamondMisshapeBodyPart;
import com.github.standobyte.jojo.action.stand.CrazyDiamondMisshapingPunch;
import com.github.standobyte.jojo.action.stand.CrazyDiamondPreviousState;
import com.github.standobyte.jojo.action.stand.CrazyDiamondRepairItem;
import com.github.standobyte.jojo.action.stand.CrazyDiamondRestoreTerrain;
import com.github.standobyte.jojo.action.stand.HierophantGreenBarrier;
import com.github.standobyte.jojo.action.stand.HierophantGreenEmeraldSplash;
import com.github.standobyte.jojo.action.stand.HierophantGreenGrapple;
import com.github.standobyte.jojo.action.stand.HierophantGreenStringAttack;
import com.github.standobyte.jojo.action.stand.MagiciansRedCrossfireHurricane;
import com.github.standobyte.jojo.action.stand.MagiciansRedDetector;
import com.github.standobyte.jojo.action.stand.MagiciansRedFireball;
import com.github.standobyte.jojo.action.stand.MagiciansRedFlameBurst;
import com.github.standobyte.jojo.action.stand.MagiciansRedKick;
import com.github.standobyte.jojo.action.stand.MagiciansRedRedBind;
import com.github.standobyte.jojo.action.stand.SilverChariotDashAttack;
import com.github.standobyte.jojo.action.stand.SilverChariotLightAttack;
import com.github.standobyte.jojo.action.stand.SilverChariotMeleeBarrage;
import com.github.standobyte.jojo.action.stand.SilverChariotRapierLaunch;
import com.github.standobyte.jojo.action.stand.SilverChariotSweepingAttack;
import com.github.standobyte.jojo.action.stand.SilverChariotTakeOffArmor;
import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction.AutoSummonMode;
import com.github.standobyte.jojo.action.stand.StandEntityAction.Phase;
import com.github.standobyte.jojo.action.stand.StandEntityActionModifier;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.action.stand.StandEntityUnsummon;
import com.github.standobyte.jojo.action.stand.StarPlatinumInhale;
import com.github.standobyte.jojo.action.stand.StarPlatinumStarFinger;
import com.github.standobyte.jojo.action.stand.StarPlatinumUppercut;
import com.github.standobyte.jojo.action.stand.StarPlatinumZoom;
import com.github.standobyte.jojo.action.stand.TheWorldBarrage;
import com.github.standobyte.jojo.action.stand.TheWorldHeavyPunch;
import com.github.standobyte.jojo.action.stand.TheWorldKick;
import com.github.standobyte.jojo.action.stand.TheWorldTSHeavyAttack;
import com.github.standobyte.jojo.action.stand.TheWorldTimeStop;
import com.github.standobyte.jojo.action.stand.TheWorldTimeStopInstant;
import com.github.standobyte.jojo.action.stand.TimeResume;
import com.github.standobyte.jojo.action.stand.TimeStop;
import com.github.standobyte.jojo.action.stand.TimeStopInstant;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.power.nonstand.type.HamonSkill.Technique;
import com.github.standobyte.jojo.power.stand.IStandPower;
import com.github.standobyte.jojo.power.stand.StandInstance.StandPart;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = JojoMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModActions {
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), JojoMod.MOD_ID);
    
    public static final RegistryObject<HamonAction> HAMON_OVERDRIVE = ACTIONS.register("hamon_overdrive", 
            () -> new HamonOverdrive(new HamonAction.Builder().energyCost(750F)));
     
    public static final RegistryObject<HamonAction> HAMON_SUNLIGHT_YELLOW_OVERDRIVE = ACTIONS.register("hamon_sunlight_yellow_overdrive", 
            () -> new HamonSunlightYellowOverdrive(new HamonAction.Builder().energyCost(1500F)
                    .shout(Technique.JONATHAN, ModSounds.JONATHAN_SUNLIGHT_YELLOW_OVERDRIVE)
                    .shout(Technique.ZEPPELI, ModSounds.ZEPPELI_SUNLIGHT_YELLOW_OVERDRIVE)
                    .shout(Technique.JOSEPH, ModSounds.JOSEPH_SUNLIGHT_YELLOW_OVERDRIVE)
                    .shout(Technique.CAESAR, ModSounds.CAESAR_SUNLIGHT_YELLOW_OVERDRIVE)
                    .shiftVariationOf(HAMON_OVERDRIVE)));
    
    public static final RegistryObject<HamonAction> HAMON_SENDO_OVERDRIVE = ACTIONS.register("hamon_sendo_overdrive", 
            () -> new HamonSendoOverdrive(new HamonAction.Builder().energyCost(1000F)
                    .emptyMainHand().swingHand().shout(Technique.JONATHAN, ModSounds.JONATHAN_SENDO_OVERDRIVE)));
    
    public static final RegistryObject<HamonAction> HAMON_ZOOM_PUNCH = ACTIONS.register("hamon_zoom_punch", 
            () -> new HamonZoomPunch(new HamonAction.Builder().energyCost(800F).cooldown(14, 0)
                    .shout(Technique.JONATHAN, ModSounds.JONATHAN_ZOOM_PUNCH)
                    .shout(Technique.ZEPPELI, ModSounds.ZEPPELI_ZOOM_PUNCH)
                    .shout(Technique.JOSEPH, ModSounds.JOSEPH_ZOOM_PUNCH)));

    public static final RegistryObject<HamonAction> HAMON_SPEED_BOOST = ACTIONS.register("hamon_speed_boost", 
            () -> new HamonSpeedBoost(new HamonAction.Builder().energyCost(600F)));
    
    public static final RegistryObject<HamonAction> HAMON_PLANT_INFUSION = ACTIONS.register("hamon_plant_infusion", 
            () -> new HamonPlantInfusion(new HamonAction.Builder().energyCost(200F)
                    .emptyMainHand().swingHand()));
    
    public static final RegistryObject<HamonAction> HAMON_ORGANISM_INFUSION = ACTIONS.register("hamon_organism_infusion", 
            () -> new HamonOrganismInfusion(new HamonAction.Builder().energyCost(200F)
                    .emptyMainHand().swingHand()));
    
    public static final RegistryObject<HamonAction> HAMON_HEALING = ACTIONS.register("hamon_healing", 
            () -> new HamonHealing(new HamonAction.Builder().energyCost(670F)
                    .emptyMainHand().swingHand()));
    
    public static final RegistryObject<HamonAction> HAMON_WALL_CLIMBING = ACTIONS.register("hamon_wall_climbing", 
            () -> new HamonWallClimbing(new HamonAction.Builder().holdEnergyCost(15F)));
    
    public static final RegistryObject<HamonAction> HAMON_DETECTOR = ACTIONS.register("hamon_detector", 
            () -> new HamonDetector(new HamonAction.Builder().holdEnergyCost(7.5F).heldSlowDownFactor(0.5F)));
    
    public static final RegistryObject<HamonAction> HAMON_LIFE_MAGNETISM = ACTIONS.register("hamon_life_magnetism", 
            () -> new HamonLifeMagnetism(new HamonAction.Builder().energyCost(200F).shout(Technique.ZEPPELI, ModSounds.ZEPPELI_LIFE_MAGNETISM_OVERDRIVE)));
    
    public static final RegistryObject<HamonAction> HAMON_PROJECTILE_SHIELD = ACTIONS.register("hamon_projectile_shield", 
            () -> new HamonProjectileShield(new HamonAction.Builder().holdEnergyCost(30F).heldSlowDownFactor(0.5F).shout(Technique.JOSEPH, ModSounds.JOSEPH_BARRIER)));
    
    public static final RegistryObject<HamonAction> HAMON_REPELLING_OVERDRIVE = ACTIONS.register("hamon_repelling_overdrive", 
            () -> new HamonRepellingOverdrive(new HamonAction.Builder().energyCost(1000F)));

    public static final RegistryObject<HamonAction> JONATHAN_OVERDRIVE_BARRAGE = ACTIONS.register("jonathan_overdrive_barrage", 
            () -> new HamonOverdriveBarrage(new HamonAction.Builder().holdEnergyCost(70F).heldSlowDownFactor(0.5F).shout(ModSounds.JONATHAN_OVERDRIVE_BARRAGE)));

    public static final RegistryObject<HamonAction> JONATHAN_SCARLET_OVERDRIVE = ACTIONS.register("jonathan_scarlet_overdrive", 
            () -> new HamonScarletOverdrive(new HamonAction.Builder().energyCost(150F)
                    .emptyMainHand().swingHand().shout(ModSounds.JONATHAN_SCARLET_OVERDRIVE)));
    
    public static final RegistryObject<HamonAction> ZEPPELI_HAMON_CUTTER = ACTIONS.register("zeppeli_hamon_cutter", 
            () -> new HamonCutter(new HamonAction.Builder().energyCost(400F).shout(ModSounds.ZEPPELI_HAMON_CUTTER)));
    
    public static final RegistryObject<HamonAction> ZEPPELI_TORNADO_OVERDRIVE = ACTIONS.register("zeppeli_tornado_overdrive", 
            () -> new HamonTornadoOverdrive(new HamonAction.Builder().holdEnergyCost(75F).shout(ModSounds.ZEPPELI_TORNADO_OVERDRIVE)));
    
    public static final RegistryObject<HamonAction> CAESAR_BUBBLE_LAUNCHER = ACTIONS.register("caesar_bubble_launcher", 
            () -> new HamonBubbleLauncher(new HamonAction.Builder().holdEnergyCost(50F).heldSlowDownFactor(0.3F).shout(ModSounds.CAESAR_BUBBLE_LAUNCHER)));
    
    public static final RegistryObject<HamonAction> CAESAR_BUBBLE_BARRIER = ACTIONS.register("caesar_bubble_barrier", 
            () -> new HamonBubbleBarrier(new HamonAction.Builder().holdToFire(20, false).holdEnergyCost(50F).heldSlowDownFactor(0.3F)
                    .shout(ModSounds.CAESAR_BUBBLE_BARRIER).shiftVariationOf(CAESAR_BUBBLE_LAUNCHER)));
    
    public static final RegistryObject<HamonAction> CAESAR_BUBBLE_CUTTER = ACTIONS.register("caesar_bubble_cutter", 
            () -> new HamonBubbleCutter(new HamonAction.Builder().energyCost(500F).swingHand().shout(ModSounds.CAESAR_BUBBLE_CUTTER)));
    
    public static final RegistryObject<HamonAction> CAESAR_BUBBLE_CUTTER_GLIDING = ACTIONS.register("caesar_bubble_cutter_gliding", 
            () -> new HamonBubbleCutter(new HamonAction.Builder().energyCost(600F).cooldown(40).swingHand()
                    .shout(ModSounds.CAESAR_BUBBLE_CUTTER_GLIDING).shiftVariationOf(CAESAR_BUBBLE_CUTTER)));
    

    public static final RegistryObject<VampirismAction> VAMPIRISM_BLOOD_DRAIN = ACTIONS.register("vampirism_blood_drain", 
            () -> new VampirismBloodDrain(new NonStandAction.Builder().emptyMainHand()));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_FREEZE = ACTIONS.register("vampirism_freeze", 
            () -> new VampirismFreeze(new NonStandAction.Builder().holdEnergyCost(0.5F).heldSlowDownFactor(0.75F).emptyMainHand()));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_SPACE_RIPPER_STINGY_EYES = ACTIONS.register("vampirism_space_ripper_stingy_eyes", 
            () -> new VampirismSpaceRipperStingyEyes(new NonStandAction.Builder().holdType(20)
                    .holdEnergyCost(20F).cooldown(50).heldSlowDownFactor(0.3F).ignoresPerformerStun()));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_BLOOD_GIFT = ACTIONS.register("vampirism_blood_gift", 
            () -> new VampirismBloodGift(new NonStandAction.Builder().holdToFire(60, false)
                    .holdEnergyCost(5F).heldSlowDownFactor(0.3F).emptyMainHand()));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_ZOMBIE_SUMMON = ACTIONS.register("vampirism_zombie_summon", 
            () -> new VampirismZombieSummon(new NonStandAction.Builder().energyCost(100F).cooldown(100)));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_DARK_AURA = ACTIONS.register("vampirism_dark_aura", 
            () -> new VampirismDarkAura(new NonStandAction.Builder().energyCost(25F).cooldown(300).ignoresPerformerStun()));
    
    public static final RegistryObject<VampirismAction> VAMPIRISM_HAMON_SUICIDE = ACTIONS.register("vampirism_hamon_suicide", 
            () -> new VampirismHamonSuicide(new NonStandAction.Builder().holdToFire(100, false).ignoresPerformerStun()));

    
    public static final RegistryObject<StandEntityAction> STAND_ENTITY_UNSUMMON = ACTIONS.register("stand_entity_unsummon", 
            () -> new StandEntityUnsummon());

    public static final RegistryObject<StandEntityAction> STAND_ENTITY_BLOCK = ACTIONS.register("stand_entity_block", 
            () -> new StandEntityBlock() {
                @Override
                public StandRelativeOffset getOffsetFromUser(IStandPower standPower, StandEntity standEntity, StandEntityTask task) {
                    return null;
                }
            });
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_PUNCH = ACTIONS.register("star_platinum_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(ModSounds.STAR_PLATINUM_PUNCH_LIGHT)
                    .standSound(Phase.WINDUP, ModSounds.STAR_PLATINUM_ORA)));
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_BARRAGE = ACTIONS.register("star_platinum_barrage", 
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(ModSounds.STAR_PLATINUM_PUNCH_BARRAGE)
                    .standSound(ModSounds.STAR_PLATINUM_ORA_ORA_ORA)));
    
    public static final RegistryObject<StandEntityHeavyAttack> STAR_PLATINUM_UPPERCUT = ACTIONS.register("star_platinum_uppercut", 
            () -> new StarPlatinumUppercut(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.STAR_PLATINUM_PUNCH_HEAVY)
                    .standSound(Phase.WINDUP, ModSounds.STAR_PLATINUM_ORA_LONG)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_HEAVY_PUNCH = ACTIONS.register("star_platinum_heavy_punch", 
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.STAR_PLATINUM_PUNCH_HEAVY)
                    .standSound(Phase.WINDUP, ModSounds.STAR_PLATINUM_ORA_LONG)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(STAR_PLATINUM_UPPERCUT)
                    .shiftVariationOf(STAR_PLATINUM_PUNCH).shiftVariationOf(STAR_PLATINUM_BARRAGE)));
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_STAR_FINGER = ACTIONS.register("star_platinum_star_finger", 
            () -> new StarPlatinumStarFinger(new StandEntityAction.Builder().staminaCost(375).standPerformDuration(20).cooldown(20, 60)
                    .ignoresPerformerStun().resolveLevelToUnlock(3)
                    .standOffsetFront().standPose(StandPose.RANGED_ATTACK)
                    .shout(ModSounds.JOTARO_STAR_FINGER).standSound(Phase.PERFORM, ModSounds.STAR_PLATINUM_STAR_FINGER)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_BLOCK = ACTIONS.register("star_platinum_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_ZOOM = ACTIONS.register("star_platinum_zoom", 
            () -> new StarPlatinumZoom(new StandEntityAction.Builder()
                    .ignoresPerformerStun()
                    .standOffsetFromUser(-0.25, -0.25, -0.3)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<StandEntityAction> STAR_PLATINUM_INHALE = ACTIONS.register("star_platinum_inhale", 
            () -> new StarPlatinumInhale(new StandEntityAction.Builder().holdType(80).staminaCostTick(2F).cooldown(200)
                    .ignoresPerformerStun().resolveLevelToUnlock(2)
                    .standOffsetFromUser(0, -0.25).standSound(ModSounds.STAR_PLATINUM_INHALE)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<TimeStop> STAR_PLATINUM_TIME_STOP = ACTIONS.register("star_platinum_time_stop", 
            () -> new TimeStop(new StandAction.Builder().holdToFire(40, false).staminaCost(250).staminaCostTick(7.5F)
                    .isTrained().resolveLevelToUnlock(4)
                    .ignoresPerformerStun().autoSummonStand()
                    .shout(ModSounds.JOTARO_STAR_PLATINUM_THE_WORLD)
                    .partsRequired(StandPart.MAIN_BODY))
            .timeStopSound(ModSounds.STAR_PLATINUM_TIME_STOP)
            .addTimeResumeVoiceLine(ModSounds.JOTARO_TIME_RESUMES).timeResumeSound(ModSounds.STAR_PLATINUM_TIME_RESUME));
    
    public static final RegistryObject<TimeResume> TIME_RESUME = ACTIONS.register("time_resume", 
            () -> new TimeResume(new StandAction.Builder()));
    
    public static final RegistryObject<StandAction> STAR_PLATINUM_TIME_STOP_BLINK = ACTIONS.register("star_platinum_ts_blink", 
            () -> new TimeStopInstant(new StandAction.Builder()
                    .resolveLevelToUnlock(4).isTrained()
                    .ignoresPerformerStun()
                    .partsRequired(StandPart.MAIN_BODY)
                    .shiftVariationOf(STAR_PLATINUM_TIME_STOP), 
                    STAR_PLATINUM_TIME_STOP, ModSounds.STAR_PLATINUM_TIME_STOP_BLINK));
    

    public static final RegistryObject<StandEntityAction> THE_WORLD_PUNCH = ACTIONS.register("the_world_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(ModSounds.THE_WORLD_PUNCH_LIGHT)
                    .standSound(Phase.WINDUP, ModSounds.DIO_MUDA)));
    
    public static final RegistryObject<StandEntityAction> THE_WORLD_BARRAGE = ACTIONS.register("the_world_barrage", 
            () -> new TheWorldBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(ModSounds.THE_WORLD_PUNCH_BARRAGE)
                    .standSound(ModSounds.THE_WORLD_MUDA_MUDA_MUDA).shout(ModSounds.DIO_MUDA_MUDA), ModSounds.DIO_WRY));

    public static final RegistryObject<StandEntityHeavyAttack> THE_WORLD_KICK = ACTIONS.register("the_world_kick", 
            () -> new TheWorldKick(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.THE_WORLD_KICK_HEAVY)
                    .shout(ModSounds.DIO_DIE)
                    .partsRequired(StandPart.LEGS)));

    public static final RegistryObject<StandEntityHeavyAttack> THE_WORLD_HEAVY_PUNCH = ACTIONS.register("the_world_heavy_punch", 
            () -> new TheWorldHeavyPunch(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.THE_WORLD_PUNCH_HEAVY)
                    .shout(ModSounds.DIO_DIE)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(THE_WORLD_KICK)
                    .shiftVariationOf(THE_WORLD_PUNCH).shiftVariationOf(THE_WORLD_BARRAGE)));

    public static final RegistryObject<StandEntityAction> THE_WORLD_BLOCK = ACTIONS.register("the_world_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<TimeStop> THE_WORLD_TIME_STOP = ACTIONS.register("the_world_time_stop", 
            () -> new TheWorldTimeStop(new StandAction.Builder().holdToFire(30, false).staminaCost(250).staminaCostTick(7.5F)
                    .resolveLevelToUnlock(2).isTrained()
                    .ignoresPerformerStun()
                    .shout(ModSounds.DIO_THE_WORLD)
                    .partsRequired(StandPart.MAIN_BODY))
            .voiceLineWithStandSummoned(ModSounds.DIO_TIME_STOP).timeStopSound(ModSounds.THE_WORLD_TIME_STOP)
            .addTimeResumeVoiceLine(ModSounds.DIO_TIME_RESUMES, true).addTimeResumeVoiceLine(ModSounds.DIO_TIMES_UP, false)
            .timeResumeSound(ModSounds.THE_WORLD_TIME_RESUME));
    
    public static final RegistryObject<TimeStopInstant> THE_WORLD_TIME_STOP_BLINK = ACTIONS.register("the_world_ts_blink", 
            () -> new TheWorldTimeStopInstant(new StandAction.Builder()
                    .resolveLevelToUnlock(2).isTrained()
                    .ignoresPerformerStun()
                    .partsRequired(StandPart.MAIN_BODY)
                    .shiftVariationOf(THE_WORLD_TIME_STOP), 
                    THE_WORLD_TIME_STOP, ModSounds.THE_WORLD_TIME_STOP_BLINK));
    
    public static final RegistryObject<StandEntityAction> THE_WORLD_TS_PUNCH = ACTIONS.register("the_world_ts_punch", 
            () -> new TheWorldTSHeavyAttack(new StandEntityAction.Builder().resolveLevelToUnlock(3).standUserSlowDownFactor(1.0F)
                    .standPose(TheWorldTSHeavyAttack.TS_PUNCH_POSE).standWindupDuration(5).cooldown(50)
                    .partsRequired(StandPart.MAIN_BODY, StandPart.ARMS), THE_WORLD_HEAVY_PUNCH, THE_WORLD_TIME_STOP_BLINK));
    

    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_STRING_ATTACK = ACTIONS.register("hierophant_green_attack", 
            () -> new HierophantGreenStringAttack(new StandEntityAction.Builder().staminaCost(75).standPerformDuration(10)
                    .standSound(ModSounds.HIEROPHANT_GREEN_TENTACLES)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_STRING_BIND = ACTIONS.register("hierophant_green_attack_binding", 
            () -> new HierophantGreenStringAttack(new StandEntityAction.Builder().staminaCost(75).standPerformDuration(25).cooldown(25, 100, 0.5F)
                    .standSound(ModSounds.HIEROPHANT_GREEN_TENTACLES)
                    .partsRequired(StandPart.MAIN_BODY)
                    .shiftVariationOf(HIEROPHANT_GREEN_STRING_ATTACK)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_EMERALD_SPLASH = ACTIONS.register("hierophant_green_emerald_splash", 
            () -> new HierophantGreenEmeraldSplash(new StandEntityAction.Builder().standPerformDuration(30).standRecoveryTicks(20).staminaCostTick(3)
                    .resolveLevelToUnlock(1).isTrained()
                    .standOffsetFront().standPose(StandPose.RANGED_ATTACK).shout(ModSounds.KAKYOIN_EMERALD_SPLASH).standSound(ModSounds.HIEROPHANT_GREEN_EMERALD_SPLASH)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_EMERALD_SPLASH_CONCENTRATED = ACTIONS.register("hierophant_green_es_concentrated", 
            () -> new HierophantGreenEmeraldSplash(new StandEntityAction.Builder().staminaCostTick(6).standPerformDuration(5).standRecoveryTicks(20).cooldown(5, 60)
                    .resolveLevelToUnlock(-1)
                    .standOffsetFront().standPose(StandPose.RANGED_ATTACK).shout(ModSounds.KAKYOIN_EMERALD_SPLASH).standSound(ModSounds.HIEROPHANT_GREEN_EMERALD_SPLASH)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(HIEROPHANT_GREEN_EMERALD_SPLASH)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_BLOCK = ACTIONS.register("hierophant_green_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_GRAPPLE = ACTIONS.register("hierophant_green_grapple", 
            () -> new HierophantGreenGrapple(new StandEntityAction.Builder().staminaCostTick(1).holdType().standUserSlowDownFactor(1.0F)
                    .resolveLevelToUnlock(2)
                    .standPose(HierophantGreenGrapple.GRAPPLE_POSE).standOffsetFromUser(-0.5, 0.25)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_GRAPPLE_ENTITY = ACTIONS.register("hierophant_green_grapple_entity", 
            () -> new HierophantGreenGrapple(new StandEntityAction.Builder().staminaCostTick(1).holdType().standUserSlowDownFactor(1.0F)
                    .resolveLevelToUnlock(2)
                    .standPose(HierophantGreenGrapple.GRAPPLE_POSE)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(HIEROPHANT_GREEN_GRAPPLE)));
    
    public static final RegistryObject<StandEntityAction> HIEROPHANT_GREEN_BARRIER = ACTIONS.register("hierophant_green_barrier", 
            () -> new HierophantGreenBarrier(new StandEntityAction.Builder()
                    .resolveLevelToUnlock(3)
                    .partsRequired(StandPart.MAIN_BODY)));

    
    public static final RegistryObject<StandEntityLightAttack> SILVER_CHARIOT_NO_RAPIER_ATTACK = ACTIONS.register("silver_chariot_no_rapier_attack", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()));
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_ATTACK = ACTIONS.register("silver_chariot_attack", 
            () -> new SilverChariotLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(() -> null).standSound(ModSounds.SILVER_CHARIOT_SWEEP_LIGHT), 
                    SILVER_CHARIOT_NO_RAPIER_ATTACK));
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_RAPIER_BARRAGE = ACTIONS.register("silver_chariot_barrage", 
            () -> new SilverChariotMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .shout(ModSounds.POLNAREFF_HORA_HORA_HORA).barrageHitSound(ModSounds.SILVER_CHARIOT_BARRAGE)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityHeavyAttack> SILVER_CHARIOT_SWEEPING_ATTACK = ACTIONS.register("silver_chariot_sweeping_attack", 
            () -> new SilverChariotSweepingAttack(new StandEntityHeavyAttack.Builder().standPerformDuration(3)
                    .punchSound(() -> null)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_DASH_ATTACK = ACTIONS.register("silver_chariot_dash_attack", 
            () -> new SilverChariotDashAttack(new StandEntityHeavyAttack.Builder()
                    .punchSound(() -> null).standSound(ModSounds.SILVER_CHARIOT_DASH)
                    .partsRequired(StandPart.MAIN_BODY, StandPart.ARMS)
                    .setFinisherVariation(SILVER_CHARIOT_SWEEPING_ATTACK)
                    .shiftVariationOf(SILVER_CHARIOT_ATTACK).shiftVariationOf(SILVER_CHARIOT_RAPIER_BARRAGE)));
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_RAPIER_LAUNCH = ACTIONS.register("silver_chariot_rapier_launch", 
            () -> new SilverChariotRapierLaunch(new StandEntityAction.Builder().cooldown(100)
                    .ignoresPerformerStun()
                    .resolveLevelToUnlock(2)
                    .standOffsetFromUser(0, 0.25).standPose(StandPose.RANGED_ATTACK).standSound(ModSounds.SILVER_CHARIOT_RAPIER_SHOT)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_BLOCK = ACTIONS.register("silver_chariot_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<StandEntityAction> SILVER_CHARIOT_TAKE_OFF_ARMOR = ACTIONS.register("silver_chariot_take_off_armor", 
            () -> new SilverChariotTakeOffArmor(new StandEntityAction.Builder()
                    .resolveLevelToUnlock(3)
                    .standSound(ModSounds.SILVER_CHARIOT_ARMOR_OFF)
                    .partsRequired(StandPart.MAIN_BODY)));
    

    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_PUNCH = ACTIONS.register("magicians_red_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(ModSounds.MAGICIANS_RED_PUNCH_LIGHT)));

    public static final RegistryObject<StandEntityHeavyAttack> MAGICIANS_RED_KICK = ACTIONS.register("magicians_red_kick", 
            () -> new MagiciansRedKick(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.MAGICIANS_RED_KICK_HEAVY)
                    .partsRequired(StandPart.LEGS)));

    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_HEAVY_PUNCH = ACTIONS.register("magicians_red_heavy_punch", 
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.MAGICIANS_RED_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(MAGICIANS_RED_KICK)
                    .shiftVariationOf(MAGICIANS_RED_PUNCH)));
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_FLAME_BURST = ACTIONS.register("magicians_red_flame_burst", 
            () -> new MagiciansRedFlameBurst(new StandEntityAction.Builder().holdType()
                    .staminaCostTick(3)
                    .standOffsetFront().standPose(MagiciansRedFlameBurst.FLAME_BURST_POSE)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_FIREBALL = ACTIONS.register("magicians_red_fireball", 
            () -> new MagiciansRedFireball(new StandEntityAction.Builder().staminaCost(75).standPerformDuration(3)
                    .resolveLevelToUnlock(2)
                    .standPose(StandPose.RANGED_ATTACK).standSound(ModSounds.MAGICIANS_RED_FIREBALL)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_CROSSFIRE_HURRICANE = ACTIONS.register("magicians_red_crossfire_hurricane", 
            () -> new MagiciansRedCrossfireHurricane(new StandEntityAction.Builder().holdToFire(30, false).staminaCost(500)
                    .resolveLevelToUnlock(4).isTrained()
                    .standPose(StandPose.RANGED_ATTACK).shout(ModSounds.AVDOL_CROSSFIRE_HURRICANE).standSound(ModSounds.MAGICIANS_RED_FIRE_BLAST)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_CROSSFIRE_HURRICANE_SPECIAL = ACTIONS.register("magicians_red_ch_special", 
            () -> new MagiciansRedCrossfireHurricane(new StandEntityAction.Builder().holdToFire(40, false).staminaCost(600)
                    .noResolveUnlock()
                    .standPose(StandPose.RANGED_ATTACK).shout(ModSounds.AVDOL_CROSSFIRE_HURRICANE_SPECIAL).standSound(ModSounds.MAGICIANS_RED_FIRE_BLAST)
                    .partsRequired(StandPart.MAIN_BODY)
                    .shiftVariationOf(MAGICIANS_RED_CROSSFIRE_HURRICANE)));
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_BLOCK = ACTIONS.register("magicians_red_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<StandEntityAction> MAGICIANS_RED_RED_BIND = ACTIONS.register("magicians_red_red_bind", 
            () -> new MagiciansRedRedBind(new StandEntityAction.Builder().staminaCostTick(1).holdType().heldSlowDownFactor(0.3F)
                    .resolveLevelToUnlock(1)
                    .standOffsetFront().standPose(MagiciansRedRedBind.RED_BIND_POSE)
                    .shout(ModSounds.AVDOL_RED_BIND).standSound(ModSounds.MAGICIANS_RED_FIRE_BLAST)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandAction> MAGICIANS_RED_DETECTOR = ACTIONS.register("magicians_red_detector", 
            () -> new MagiciansRedDetector(new StandAction.Builder().autoSummonStand()
                    .resolveLevelToUnlock(3)
                    .partsRequired(StandPart.MAIN_BODY)));
    
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_PUNCH = ACTIONS.register("crazy_diamond_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(ModSounds.CRAZY_DIAMOND_PUNCH_LIGHT)
                    .standSound(Phase.WINDUP, ModSounds.CRAZY_DIAMOND_DORA)
                    ));
    
    public static final RegistryObject<StandEntityMeleeBarrage> CRAZY_DIAMOND_BARRAGE = ACTIONS.register("crazy_diamond_barrage", 
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(ModSounds.CRAZY_DIAMOND_PUNCH_BARRAGE)
                    .standSound(ModSounds.CRAZY_DIAMOND_DORARARA)));
    
    public static final RegistryObject<StandEntityHeavyAttack> CRAZY_DIAMOND_COMBO_PUNCH = ACTIONS.register("crazy_diamond_misshaping_punch", 
            () -> new CrazyDiamondMisshapingPunch(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.CRAZY_DIAMOND_PUNCH_HEAVY)
                    .standSound(Phase.WINDUP, ModSounds.CRAZY_DIAMOND_DORA_LONG)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityActionModifier> CRAZY_DIAMOND_MISSHAPE_FACE = ACTIONS.register("crazy_diamond_misshape_face", 
            () -> new CrazyDiamondMisshapeBodyPart(new StandAction.Builder().staminaCost(50)));
    
    public static final RegistryObject<StandEntityActionModifier> CRAZY_DIAMOND_MISSHAPE_ARMS = ACTIONS.register("crazy_diamond_misshape_arms", 
            () -> new CrazyDiamondMisshapeBodyPart(new StandAction.Builder().staminaCost(50)));
    
    public static final RegistryObject<StandEntityActionModifier> CRAZY_DIAMOND_MISSHAPE_LEGS = ACTIONS.register("crazy_diamond_misshape_legs", 
            () -> new CrazyDiamondMisshapeBodyPart(new StandAction.Builder().staminaCost(50)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_HEAVY_PUNCH = ACTIONS.register("crazy_diamond_heavy_punch", 
            () -> new CrazyDiamondHeavyPunch(new StandEntityHeavyAttack.Builder()
                    .punchSound(ModSounds.CRAZY_DIAMOND_PUNCH_HEAVY)
                    .standSound(Phase.WINDUP, ModSounds.CRAZY_DIAMOND_DORA_LONG)
                    .partsRequired(StandPart.ARMS)
                    .setFinisherVariation(CRAZY_DIAMOND_COMBO_PUNCH)
                    .shiftVariationOf(CRAZY_DIAMOND_PUNCH).shiftVariationOf(CRAZY_DIAMOND_BARRAGE)));
    
    public static final RegistryObject<StandEntityActionModifier> CRAZY_DIAMOND_LEAVE_OBJECT = ACTIONS.register("crazy_diamond_leave_object", 
            () -> new CrazyDiamondLeaveObject(new StandAction.Builder().staminaCost(50)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_BLOCK_BULLET = ACTIONS.register("crazy_diamond_block_bullet", 
            () -> new CrazyDiamondBlockBullet(new StandEntityAction.Builder().standWindupDuration(15).staminaCost(40).staminaCostTick(2F)
                    .resolveLevelToUnlock(4)
                    .standPose(CrazyDiamondBlockBullet.BLOCK_BULLET_SHOT_POSE)
                    .standSound(Phase.WINDUP, ModSounds.CRAZY_DIAMOND_FIX_STARTED).standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_BULLET_SHOT)
                    .standOffsetFromUser(0.25, -0.5, 0)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_BLOOD_CUTTER = ACTIONS.register("crazy_diamond_blood_cutter", 
            () -> new CrazyDiamondBloodCutter(new StandEntityAction.Builder().standWindupDuration(5).standRecoveryTicks(5).staminaCost(25).cooldown(300)
                    .resolveLevelToUnlock(4)
                    .standPose(CrazyDiamondBloodCutter.BLOOD_CUTTER_SHOT_POSE)
                    .standSound(Phase.WINDUP, ModSounds.CRAZY_DIAMOND_FIX_STARTED, ModSounds.CRAZY_DIAMOND_DORA).standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_BLOOD_CUTTER_SHOT)
                    .standOffsetFromUser(-0.1, -0.5)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_BLOCK = ACTIONS.register("crazy_diamond_block", 
            () -> new StandEntityBlock());
    
    public static final RegistryObject<CrazyDiamondRepairItem> CRAZY_DIAMOND_REPAIR = ACTIONS.register("crazy_diamond_repair", 
            () -> new CrazyDiamondRepairItem(new StandEntityAction.Builder().holdType().staminaCostTick(0.2F)
                    .resolveLevelToUnlock(0).isTrained()
                    .standOffsetFromUser(0.667, 0.2, 0).standPose(CrazyDiamondRepairItem.ITEM_FIX_POSE)
                    .standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED)
                    .standAutoSummonMode(AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_PREVIOUS_STATE = ACTIONS.register("crazy_diamond_previous_state", 
            () -> new CrazyDiamondPreviousState(new StandEntityAction.Builder().holdType().staminaCostTick(0.2F)
                    .resolveLevelToUnlock(-1)
                    .standOffsetFromUser(0.667, 0.2, 0).standPose(CrazyDiamondRepairItem.ITEM_FIX_POSE)
                    .standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED).barrageVisuals(CRAZY_DIAMOND_BARRAGE)
                    .standAutoSummonMode(AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(CRAZY_DIAMOND_REPAIR)));
    
    public static final RegistryObject<CrazyDiamondHeal> CRAZY_DIAMOND_HEAL = ACTIONS.register("crazy_diamond_heal", 
            () -> new CrazyDiamondHeal(new StandEntityAction.Builder().holdType().staminaCostTick(1)
                    .resolveLevelToUnlock(1)
                    .standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED).barrageVisuals(CRAZY_DIAMOND_BARRAGE)
                    .standAutoSummonMode(AutoSummonMode.MAIN_ARM)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_RESTORE_TERRAIN = ACTIONS.register("crazy_diamond_restore_terrain", 
            () -> new CrazyDiamondRestoreTerrain(new StandEntityAction.Builder().holdType().staminaCostTick(2) // cost per block rather than per tick
                    .resolveLevelToUnlock(2)
                    .shout(ModSounds.JOSUKE_FIX).standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_BLOCK_ANCHOR_MOVE = ACTIONS.register("crazy_diamond_anchor_move", 
            () -> new CrazyDiamondBlockCheckpointMove(new StandEntityAction.Builder().holdType().staminaCostTick(1)
                    .resolveLevelToUnlock(3)
                    .standSound(Phase.PERFORM, ModSounds.CRAZY_DIAMOND_FIX_STARTED)
                    .standAutoSummonMode(AutoSummonMode.OFF_ARM)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> CRAZY_DIAMOND_BLOCK_ANCHOR_MAKE = ACTIONS.register("crazy_diamond_anchor_make", 
            () -> new CrazyDiamondBlockCheckpointMake(new StandEntityAction.Builder().standWindupDuration(10).standRecoveryTicks(5).staminaCost(25)
                    .resolveLevelToUnlock(3)
                    .standPose(StandPose.HEAVY_ATTACK_COMBO)
                    .partsRequired(StandPart.ARMS)
                    .shiftVariationOf(CRAZY_DIAMOND_BLOCK_ANCHOR_MOVE)));
    


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void beforeActionsInit(RegistryEvent.Register<Action<?>> event) {
        Action.prepareShiftVariationsMap();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void afterActionsInit(RegistryEvent.Register<Action<?>> event) {
        Action.initShiftVariations();
    }
    
    
    
    public static class Registry {
        private static Supplier<IForgeRegistry<Action<?>>> REGISTRY_SUPPLIER = null;
        
        public static void initRegistry() {
            if (REGISTRY_SUPPLIER == null) {
                REGISTRY_SUPPLIER = ModActions.ACTIONS.makeRegistry("action", () -> new RegistryBuilder<>());
            }
        }
        
        public static IForgeRegistry<Action<?>> getRegistry() {
            return REGISTRY_SUPPLIER.get();
        }
    }

}
