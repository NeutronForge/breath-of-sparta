package com.echo.breath_of_sparta.client.render.entity.model;

import com.echo.breath_of_sparta.BreathOfSparta;
import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class ModEntityModelLayers extends EntityModelLayers {
    private static final Set<EntityModelLayer> LAYERS = Sets.<EntityModelLayer>newHashSet();

    public static final EntityModelLayer WOODEN_SPEAR = registerFromModMain("spear/wooden");
    public static final EntityModelLayer STONE_SPEAR = registerFromModMain("spear/stone");
    public static final EntityModelLayer IRON_SPEAR = registerFromModMain("spear/iron");
    public static final EntityModelLayer GOLDEN_SPEAR = registerFromModMain("spear/golden");
    public static final EntityModelLayer DIAMOND_SPEAR = registerFromModMain("spear/diamond");
    public static final EntityModelLayer NETHERITE_SPEAR = registerFromModMain("spear/netherite");


    private static EntityModelLayer registerFromModMain(String id) {
        return registerFromMod(id, "main");
    }

    private static EntityModelLayer registerFromMod(String id, String layer) {
        EntityModelLayer entityModelLayer = createFromMod(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        } else {
            return entityModelLayer;
        }
    }

    private static EntityModelLayer createFromMod(String id, String layer) {
        return new EntityModelLayer(Identifier.of(BreathOfSparta.MOD_ID, id), layer);

    }

}