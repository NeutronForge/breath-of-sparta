package com.echo.breath_of_sparta.client.render.entity.model;

import com.echo.breath_of_sparta.client.render.entity.state.SpearEntityRenderState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

public class SpearEntityModel extends EntityModel<SpearEntityRenderState> {
    public static final Identifier TEXTURE = Identifier.ofVanilla("textures/entity/trident.png");

    public SpearEntityModel(ModelPart modelPart) {
        super(modelPart, RenderLayer::getEntitySolid);
    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartDataRoot = modelData.getRoot();
        ModelPartData modelPartDataChild = modelPartDataRoot.addChild(
                "pole", ModelPartBuilder.create().uv(0, 6).cuboid(-0.5F, 2.0F, -0.5F, 1.0F, 25.0F, 1.0F), ModelTransform.NONE
        );

        modelPartDataChild.addChild("base", ModelPartBuilder.create().uv(4, 0).cuboid(-1.5F, 0.0F, -0.5F, 3.0F, 2.0F, 1.0F), ModelTransform.NONE);
        modelPartDataChild.addChild("left_spike", ModelPartBuilder.create().uv(4, 3).cuboid(-2.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        modelPartDataChild.addChild("middle_spike", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        modelPartDataChild.addChild("right_spike", ModelPartBuilder.create().uv(4, 3).mirrored().cuboid(1.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 32, 32);
    }
}