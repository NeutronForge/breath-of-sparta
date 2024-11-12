package com.echo.breath_of_sparta;

import com.echo.breath_of_sparta.client.render.entity.CustomWindChargeEntityRenderer;
import com.echo.breath_of_sparta.client.render.entity.SpearEntityRenderer;
import com.echo.breath_of_sparta.client.render.entity.model.ModEntityModelLayers;
import com.echo.breath_of_sparta.entity.ModEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BreathOfSpartaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityModelLayers.init();


        EntityRendererRegistry.register(ModEntityType.CUSTOM_WIND_CHARGE, CustomWindChargeEntityRenderer::new);

        EntityRendererRegistry.register(ModEntityType.WOODEN_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.WOODEN_SPEAR));
        EntityRendererRegistry.register(ModEntityType.STONE_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.STONE_SPEAR));
        EntityRendererRegistry.register(ModEntityType.IRON_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.IRON_SPEAR));
        EntityRendererRegistry.register(ModEntityType.GOLDEN_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.GOLDEN_SPEAR));
        EntityRendererRegistry.register(ModEntityType.DIAMOND_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.DIAMOND_SPEAR));
        EntityRendererRegistry.register(ModEntityType.NETHERITE_SPEAR, context -> new SpearEntityRenderer(context, ModEntityModelLayers.NETHERITE_SPEAR));
    }
}
