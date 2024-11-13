package com.echo.breath_of_sparta.datagen.tag;

import com.echo.breath_of_sparta.entity.ModEntityType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        this.getOrCreateTagBuilder(EntityTypeTags.REDIRECTABLE_PROJECTILE).add(ModEntityType.CUSTOM_WIND_CHARGE);

        this.getOrCreateTagBuilder(EntityTypeTags.IMPACT_PROJECTILES)
                .add(ModEntityType.WOODEN_SPEAR)
                .add(ModEntityType.STONE_SPEAR)
                .add(ModEntityType.IRON_SPEAR)
                .add(ModEntityType.GOLDEN_SPEAR)
                .add(ModEntityType.DIAMOND_SPEAR)
                .add(ModEntityType.NETHERITE_SPEAR);

        this.getOrCreateTagBuilder(EntityTypeTags.SENSITIVE_TO_IMPALING);

    }
}
