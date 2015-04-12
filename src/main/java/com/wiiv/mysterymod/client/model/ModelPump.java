package com.wiiv.mysterymod.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPump extends ModelBase{
	
	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();//

	private ModelRenderer innerRing;//-
	private ModelRenderer outerRing;//--

	public ModelPump() {

		textureWidth = 64;
		textureHeight = 32;
		
		//main
		
		ModelRenderer main = new ModelRenderer(this, 0, 0);
		main.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 14);
		main.setRotationPoint(0.0F, 4.0F, 0.0F);
		
			//sides
		
			for (float r = 0; r <= Math.PI * 2; r += Math.PI) {
				
				ModelRenderer side = new ModelRenderer(this, 22, 0);
				
				side.addBox(-4.0F, -4.0F, 7.0F, 8, 8, 1);	
				side.setRotationPoint(0.0F, 0.0F, 0.0F);
				side.rotateAngleY = r;
				
				main.addChild(side);
			}
		
		parts.add(main);
		
		ModelRenderer innerRing = new ModelRenderer(this, 0, 0);

		ModelRenderer outerRing = new ModelRenderer(this, 0, 0);
		
			//rings
			for (float r = 0; r <= Math.PI * 2; r += Math.PI / 2) {
				
				//inner ring
				ModelRenderer innerPlate = new ModelRenderer(this, 0, 18);
				
				innerPlate.addBox(-3.0F, -3.0F, -7.0F, 5, 1, 6);
				innerPlate.setRotationPoint(0.0F, 4.0F, 0.0F);
				innerPlate.rotateAngleZ = r;
				
				innerRing.addChild(innerPlate);
				
				//outer ring
				ModelRenderer outerPlate = new ModelRenderer(this, 22, 18);
						
				outerPlate.addBox(-4.0F, -4.0F, 3.0F, 7, 1, 4);
				outerPlate.setRotationPoint(0.0F, 4.0F, 0.0F);
				outerPlate.rotateAngleZ = r;
						
				outerRing.addChild(outerPlate);
			}
		
		parts.add(innerRing);
		parts.add(outerRing);
	}  

	public void renderModel(float innerRingPosition, float outerRingPosition, float mult) { 

		//innerRing.rotationPointZ = innerRingPosition;
		//outerRing.rotationPointZ = outerRingPosition;
	    	
		for (ModelRenderer part : parts) {
	            part.render(mult);
	        }
	    }
	}
	