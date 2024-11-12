package com.echo.breath_of_sparta.client.render.entity.model;

import com.echo.breath_of_sparta.BreathOfSparta;
import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import java.util.Set;

public class ModEntityModelLayers {
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();

    public static final EntityModelLayer WOODEN_SPEAR = registerSpear("spear/wooden");
    public static final EntityModelLayer STONE_SPEAR = registerSpear("spear/stone");
    public static final EntityModelLayer IRON_SPEAR = registerSpear("spear/iron");
    public static final EntityModelLayer GOLDEN_SPEAR = registerSpear("spear/golden");
    public static final EntityModelLayer DIAMOND_SPEAR = registerSpear("spear/diamond");
    public static final EntityModelLayer NETHERITE_SPEAR = registerSpear("spear/netherite");

    private static EntityModelLayer registerSpear(String id) {
        return registerFromModMain(id, SpearEntityModel::getTexturedModelData);
    }

    private static EntityModelLayer registerFromModMain(String id, EntityModelLayerRegistry.TexturedModelDataProvider provider) {
        EntityModelLayer layer = registerFromMod(id, "main");
        EntityModelLayerRegistry.registerModelLayer(layer, provider);
        return layer;
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

    public static void init() { }
}