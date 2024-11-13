package com.echo.breath_of_sparta.datagen.tag;

import com.echo.breath_of_sparta.item.ModItems;
import com.echo.breath_of_sparta.registry.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {


        this.getOrCreateTagBuilder(ModTags.Items.SPEARS)
                .add(ModItems.WOODEN_SPEAR)
                .add(ModItems.STONE_SPEAR)
                .add(ModItems.IRON_SPEAR)
                .add(ModItems.GOLDEN_SPEAR)
                .add(ModItems.DIAMOND_SPEAR)
                .add(ModItems.NETHERITE_SPEAR);

        this.getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(ModTags.Items.SPEARS);

        this.getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE).addTag(ModTags.Items.SPEARS);

        this.getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE).addTag(ModTags.Items.SPEARS);

        this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(ModTags.Items.SPEARS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED).add(ModItems.GOLDEN_SPEAR);




        this.getOrCreateTagBuilder(ItemTags.TRIDENT_ENCHANTABLE).addTag(ModTags.Items.SPEARS);


    }
}

