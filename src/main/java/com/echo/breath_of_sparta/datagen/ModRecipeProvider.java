package com.echo.breath_of_sparta.datagen;

import com.echo.breath_of_sparta.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static RegistryEntryLookup<Item> itemLookup;
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(ItemConvertible item) {
        return RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(itemLookup, item));
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);


        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            public static String hasItem(ItemConvertible item) {
                return "has_" + getItemPath(item);
            }

            public static String getItemPath(ItemConvertible item) {
                return Registries.ITEM.getId(item.asItem()).getPath();
            }

            public static String convertBetween(ItemConvertible to, ItemConvertible from) {
                return getItemPath(to) + "_from_" + getItemPath(from);
            }


            @Override
            public void generate() {

                this.offerSpearRecipe(ItemTags.WOODEN_TOOL_MATERIALS, ModItems.WOODEN_SPEAR, "stick");
                this.offerSpearRecipe(ItemTags.STONE_TOOL_MATERIALS, ModItems.STONE_SPEAR, "cobblestone");
                this.offerSpearRecipe(ItemTags.IRON_TOOL_MATERIALS, ModItems.IRON_SPEAR, "iron_ingot");
                this.offerSpearRecipe(ItemTags.GOLD_TOOL_MATERIALS, ModItems.GOLDEN_SPEAR, "gold_ingot");
                this.offerSpearRecipe(ItemTags.DIAMOND_TOOL_MATERIALS, ModItems.DIAMOND_SPEAR, "diamond");

                this.offerNetheriteUpgradeRecipe(ModItems.DIAMOND_SPEAR, RecipeCategory.COMBAT, ModItems.NETHERITE_SPEAR);


                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItems(
                                        ModItems.GOLDEN_SPEAR
                                ),
                                RecipeCategory.MISC,
                                Items.GOLD_NUGGET,
                                0.1F,
                                200
                        )
                        .criterion("has_golden_spear", this.conditionsFromItem(ModItems.GOLDEN_SPEAR))
                        .offerTo(this.exporter, getSmeltingItemPath(Items.GOLD_NUGGET));
                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItems(
                                        ModItems.IRON_SPEAR
                                ),
                                RecipeCategory.MISC,
                                Items.IRON_NUGGET,
                                0.1F,
                                200
                        )
                        .criterion("has_iron_spear", this.conditionsFromItem(ModItems.IRON_SPEAR))
                        .offerTo(this.exporter, getSmeltingItemPath(Items.IRON_NUGGET));

            }



            private void offerSpearRecipe(TagKey inputMaterial, ItemConvertible output, String criterion) {

                this.createShaped(RecipeCategory.COMBAT, output)
                        .input('#', Items.STICK)
                        .input('X', inputMaterial)
                        .pattern("  X")
                        .pattern(" # ")
                        .pattern("#  ")
                        .criterion("has_" + criterion, this.conditionsFromTag(inputMaterial))
                        .offerTo(this.exporter);
            }


    };

    }

    @Override
    public String getName() {
        return "";
    }
}
