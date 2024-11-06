package com.echo.breath_of_sparta.client.render.entity;

import com.echo.breath_of_sparta.BreathOfSparta;
import com.echo.breath_of_sparta.client.render.entity.model.ModEntityModelLayers;
import com.echo.breath_of_sparta.client.render.entity.model.SpearEntityModel;
import com.echo.breath_of_sparta.client.render.entity.state.SpearEntityRenderState;
import com.echo.breath_of_sparta.entity.projectile.SpearEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.util.function.UnaryOperator;

@Environment(EnvType.CLIENT)
public class SpearEntityRenderer extends EntityRenderer<SpearEntity, SpearEntityRenderState> {
    public final Identifier texture;// = Identifier.of(BreathOfSparta.MOD_ID, "textures/entity/" + ".png");
    private final SpearEntityModel model;

    public SpearEntityRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context);
        this.texture = layer.id().withPath((UnaryOperator<String>)(path -> BreathOfSparta.MOD_ID + "textures/entity/" + path + ".png"));
        this.model = new SpearEntityModel(context.getPart(layer));
    }

    public void render(SpearEntityRenderState spearEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(spearEntityRenderState.yaw - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(spearEntityRenderState.pitch + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumerProvider, this.model.getLayer(texture), false, spearEntityRenderState.enchanted
        );
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(spearEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    public SpearEntityRenderState createRenderState() {
        return new SpearEntityRenderState();
    }

    public void updateRenderState(SpearEntity spearEntity, SpearEntityRenderState spearEntityRenderState, float f) {
        super.updateRenderState(spearEntity, spearEntityRenderState, f);
        spearEntityRenderState.yaw = spearEntity.getLerpedYaw(f);
        spearEntityRenderState.pitch = spearEntity.getLerpedPitch(f);
        spearEntityRenderState.enchanted = spearEntity.isEnchanted();
    }




}

