package com.echo.breath_of_sparta.client.render.entity;


import com.echo.breath_of_sparta.BreathOfSparta;
import com.echo.breath_of_sparta.client.render.entity.model.ModEntityModelLayers;
import com.echo.breath_of_sparta.entity.ModEntityType;
import net.minecraft.client.render.entity.EntityRenderers;


public class ModEntityRenderers extends EntityRenderers {
    static {
        register(ModEntityType.CUSTOM_WIND_CHARGE, CustomWindChargeEntityRenderer::new);

        register(ModEntityType.WOODEN_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.WOODEN_SPEAR));
        register(ModEntityType.STONE_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.STONE_SPEAR));
        register(ModEntityType.IRON_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.IRON_SPEAR));
        register(ModEntityType.GOLDEN_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.GOLDEN_SPEAR));
        register(ModEntityType.DIAMOND_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.DIAMOND_SPEAR));
        register(ModEntityType.NETHERITE_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.NETHERITE_SPEAR));
/*
        register(ModEntityType.WOODEN_SPEAR, SpearEntityRenderer::new);
        register(ModEntityType.STONE_SPEAR, SpearEntityRenderer::new);
        register(ModEntityType.IRON_SPEAR, SpearEntityRenderer::new);
        register(ModEntityType.GOLDEN_SPEAR, SpearEntityRenderer::new);
        register(ModEntityType.DIAMOND_SPEAR, SpearEntityRenderer::new);
        register(ModEntityType.NETHERITE_SPEAR, SpearEntityRenderer::new);



 */
    }
    public static void registerModEntityRenderers() {
        BreathOfSparta.LOGGER.info("Registering entity renderers for " + BreathOfSparta.MOD_ID);

    }
}
