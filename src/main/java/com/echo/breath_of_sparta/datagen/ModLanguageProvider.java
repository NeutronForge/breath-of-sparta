package com.echo.breath_of_sparta.datagen;

import com.echo.breath_of_sparta.entity.ModEntityType;
import com.echo.breath_of_sparta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {


        translationBuilder.add(ModItems.WOODEN_SPEAR, "Wooden Spear");
        translationBuilder.add(ModItems.STONE_SPEAR, "Stone Spear");
        translationBuilder.add(ModItems.IRON_SPEAR, "Iron Spear");
        translationBuilder.add(ModItems.GOLDEN_SPEAR, "Golden Spear");
        translationBuilder.add(ModItems.DIAMOND_SPEAR, "Diamond Spear");
        translationBuilder.add(ModItems.NETHERITE_SPEAR, "Netherite Spear");

        translationBuilder.add(ModEntityType.WOODEN_SPEAR, "Wooden Spear");
        translationBuilder.add(ModEntityType.STONE_SPEAR, "Stone Spear");
        translationBuilder.add(ModEntityType.IRON_SPEAR, "Iron Spear");
        translationBuilder.add(ModEntityType.GOLDEN_SPEAR, "Golden Spear");
        translationBuilder.add(ModEntityType.DIAMOND_SPEAR, "Diamond Spear");
        translationBuilder.add(ModEntityType.NETHERITE_SPEAR, "Netherite Spear");


    }
}
