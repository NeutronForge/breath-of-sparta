package com.echo.breath_of_sparta.mixin;

import com.echo.breath_of_sparta.client.render.entity.model.ModEntityModelLayers;
import com.echo.breath_of_sparta.client.render.entity.model.SpearEntityModel;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(EntityModels.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "getModels")
	private static void init(CallbackInfoReturnable<Map<EntityModelLayer, TexturedModelData>> cir) {
		ImmutableMap.Builder<EntityModelLayer, TexturedModelData> builder = ImmutableMap.builder();

		builder.put(ModEntityModelLayers.WOODEN_SPEAR, SpearEntityModel.getTexturedModelData());
		builder.put(ModEntityModelLayers.STONE_SPEAR, SpearEntityModel.getTexturedModelData());
		builder.put(ModEntityModelLayers.IRON_SPEAR, SpearEntityModel.getTexturedModelData());
		builder.put(ModEntityModelLayers.GOLDEN_SPEAR, SpearEntityModel.getTexturedModelData());
		builder.put(ModEntityModelLayers.DIAMOND_SPEAR, SpearEntityModel.getTexturedModelData());
		builder.put(ModEntityModelLayers.NETHERITE_SPEAR, SpearEntityModel.getTexturedModelData());
		// This code is injected into the start of EntityModels.getModels()V

	}
}
