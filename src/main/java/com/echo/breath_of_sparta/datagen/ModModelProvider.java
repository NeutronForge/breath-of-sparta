package com.echo.breath_of_sparta.datagen;

import com.echo.breath_of_sparta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Items;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.WOODEN_SPEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SPEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_SPEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_SPEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SPEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_SPEAR, Models.GENERATED);

    }
}
