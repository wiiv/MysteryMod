package com.wiiv.mysterymod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;


public class ModelUrn extends ModelBase {
	
    public ModelRenderer body1;
    public ModelRenderer lid1;
    public ModelRenderer body2;
    public ModelRenderer lid2;
    public ModelRenderer lid3;

    public ModelUrn() {
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body1 = new ModelRenderer(this, 0, 39);
        this.body1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.body1.addBox(-4.0F, 0.0F, -4.0F, 8, 10, 8, 0.0F);
        this.lid1 = new ModelRenderer(this, 0, 30);
        this.lid1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.lid1.addBox(-4.0F, -2.0F, -4.0F, 8, 1, 8, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 0);
        this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body2.addBox(-5.0F, 1.0F, -5.0F, 10, 8, 10, 0.0F);
        this.lid2 = new ModelRenderer(this, 0, 18);
        this.lid2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lid2.addBox(-5.0F, -1.0F, -5.0F, 10, 2, 10, 0.0F);
        this.lid3 = new ModelRenderer(this, 0, 0);
        this.lid3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lid3.addBox(-1.0F, -3.0F, -1.0F, 2, 1, 2, 0.0F);
        this.body1.addChild(this.body2);
        this.lid1.addChild(this.lid2);
        this.lid1.addChild(this.lid3);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	public void renderModel(float f) {
		
		this.body1.render(f);
		this.lid1.render(f);
	}
}
