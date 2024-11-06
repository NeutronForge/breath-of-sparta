package com.echo.breath_of_sparta.item;

import com.echo.breath_of_sparta.BreathOfSparta;
import com.echo.breath_of_sparta.entity.ModEntityType;
import com.echo.breath_of_sparta.item.custom.CustomWindChargeItem;
import com.echo.breath_of_sparta.item.custom.SpearItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final float SpearDurabilityMultiplier = 0.5F;


    public static final Item STORM_CHARGE = registerItem("storm_charge", (settings) ->
            new CustomWindChargeItem(settings));



    public static final Item WOODEN_SPEAR = registerItem("wooden_spear", (settings) ->
            new SpearItem(ModEntityType.WOODEN_SPEAR, settings
                    .maxDamage((int) (59 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
            ));

    public static final Item STONE_SPEAR = registerItem("stone_spear", (settings) ->
            new SpearItem(ModEntityType.STONE_SPEAR, settings
                    .maxDamage((int) (131 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
            ));

    public static final Item IRON_SPEAR = registerItem("iron_spear", (settings) ->
            new SpearItem(ModEntityType.IRON_SPEAR, settings
                    .maxDamage((int) (250 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
            ));

    public static final Item GOLDEN_SPEAR = registerItem("golden_spear", (settings) ->
            new SpearItem(ModEntityType.GOLDEN_SPEAR, settings
                    .maxDamage((int) (32 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
            ));

    public static final Item DIAMOND_SPEAR = registerItem("diamond_spear", (settings) ->
            new SpearItem(ModEntityType.DIAMOND_SPEAR, settings
                    .maxDamage((int) (1561 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
            ));

    public static final Item NETHERITE_SPEAR = registerItem("netherite_spear", (settings) ->
            new SpearItem(ModEntityType.NETHERITE_SPEAR, settings
                    .maxDamage((int) (2031 * SpearDurabilityMultiplier))
                    .attributeModifiers(SpearItem.createAttributeModifiers())
                    .component(DataComponentTypes.TOOL, SpearItem.createToolComponent())
                    .enchantable(1)
                    .modelId(Identifier.ofVanilla("trident_in_hand"))
                    .fireproof()
            ));





    public static void registerCombatToVanilla() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {

            content.addBefore(Items.TRIDENT, ModItems.NETHERITE_SPEAR);
            content.addBefore(ModItems.NETHERITE_SPEAR, ModItems.DIAMOND_SPEAR);
            content.addBefore(ModItems.DIAMOND_SPEAR, ModItems.GOLDEN_SPEAR);
            content.addBefore(ModItems.GOLDEN_SPEAR, ModItems.IRON_SPEAR);
            content.addBefore(ModItems.IRON_SPEAR, ModItems.STONE_SPEAR);
            content.addBefore(ModItems.STONE_SPEAR, ModItems.WOODEN_SPEAR);


        });
    }


    public static <T extends Item> T registerItem(String name, Function<Item.Settings, T> factory) {
        return registerItem(Identifier.of(BreathOfSparta.MOD_ID, name), factory);
    }

    public static <T extends Item> T registerItem(Identifier identifier, Function<Item.Settings, T> factory) {
        return Registry.register(
                Registries.ITEM,
                identifier,
                factory.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, identifier)))
        );
    }


    public static void registerModItems() {
        BreathOfSparta.LOGGER.info("Registering mod items for " + BreathOfSparta.MOD_ID);

        registerCombatToVanilla();

    }
}