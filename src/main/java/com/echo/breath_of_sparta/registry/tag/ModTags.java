package com.echo.breath_of_sparta.registry.tag;

import com.echo.breath_of_sparta.BreathOfSparta;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> SPEARS = of("spears");


        private static TagKey<Item> of(String id) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BreathOfSparta.MOD_ID, id));
        }

    }



}
