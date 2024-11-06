package com.echo.breath_of_sparta.entity;

import com.echo.breath_of_sparta.BreathOfSparta;
import com.echo.breath_of_sparta.entity.projectile.CustomWindChargeEntity;
import com.echo.breath_of_sparta.entity.projectile.SpearEntity;
import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.Optional;
public class ModEntityType extends EntityType {
    public ModEntityType(EntityFactory factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet canSpawnInside, EntityDimensions dimensions, float spawnBoxScale, int maxTrackDistance, int trackTickInterval, String translationKey, Optional lootTable, FeatureSet requiredFeatures) {
        super(factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnInside, dimensions, spawnBoxScale, maxTrackDistance, trackTickInterval, translationKey, lootTable, requiredFeatures);
    }



    public static final EntityType<SpearEntity> SPEAR = register(
            "spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );


    public static final EntityType<SpearEntity> WOODEN_SPEAR = register(
            "wooden_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<SpearEntity> STONE_SPEAR = register(
            "stone_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<SpearEntity> IRON_SPEAR = register(
            "iron_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<SpearEntity> GOLDEN_SPEAR = register(
            "golden_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<SpearEntity> DIAMOND_SPEAR = register(
            "diamond_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
    );
    public static final EntityType<SpearEntity> NETHERITE_SPEAR = register(
            "netherite_spear",
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20)
                    .makeFireImmune()
    );





    public static final EntityType<CustomWindChargeEntity> CUSTOM_WIND_CHARGE = register(
            "custom_wind_charge",
            EntityType.Builder.<CustomWindChargeEntity>create(CustomWindChargeEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.3125F, 0.3125F)
                    .eyeHeight(0.0F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
    );




    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(BreathOfSparta.MOD_ID, id));
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }

    public static Optional<EntityType<?>> get(String id) {
        return Registries.ENTITY_TYPE.getOptionalValue(Identifier.tryParse(id));
    }


    public static void registerModEntityTypes() {
        BreathOfSparta.LOGGER.info("Registering mod entity types for " + BreathOfSparta.MOD_ID);

    }

}
