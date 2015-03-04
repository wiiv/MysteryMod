package com.wiiv.mysterymod.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChandelier extends ModelBase{
	
	//ceiling
	private ArrayList<ModelRenderer> partsChandelierCeiling = new ArrayList<ModelRenderer>();
	
	ModelRenderer chandelierCeiling;
	ModelRenderer supportCeiling;
	ModelRenderer mainTube;
	ModelRenderer mainConnection;
	
	ModelRenderer subConnection;
	ModelRenderer supportTorch;
	ModelRenderer torch;
	ModelRenderer crystal;
	
	//wall
	private ArrayList<ModelRenderer> partsChandelierWall = new ArrayList<ModelRenderer>();//
	ModelRenderer chandelierWall;
	
	
	public ModelChandelier() {
		
	    textureWidth = 32;
	    textureHeight = 24;
	    
	    //ceiling
	    
	    chandelierCeiling = new ModelRenderer(this, 0, 0);
	    chandelierCeiling.setRotationPoint(0.0F, -16.0F, 0.0F);
   
	    //
	    supportCeiling = new ModelRenderer(this, 0, 0);
	    supportCeiling.addBox(-3F, 0F, -3F, 6, 2, 6);
	    supportCeiling.setRotationPoint(0F, 8F, 0F);
	  
	    chandelierCeiling.addChild(supportCeiling);
	    
	    mainTube = new ModelRenderer(this, 24, 0);
	    mainTube.addBox(-1F, 1F, -1F, 2, 13, 2);
	    mainTube.setRotationPoint(0F, 8F, 0F);
	    
	    chandelierCeiling.addChild(mainTube);
	    
	    mainConnection = new ModelRenderer(this, 0, 8);
	    mainConnection.addBox(-2F, 0F, -2F, 4, 1, 4);
	    mainConnection.setRotationPoint(0F, 20F, 0F);
	    
	    chandelierCeiling.addChild(mainConnection);
	    
		
	    for (float r = 0; r <= Math.PI * 2; r += Math.PI / 2) {
			 
	    	subConnection = new ModelRenderer(this, 0, 13);	
			subConnection.addBox(-1.0F, 0.0F, 2.0F, 2, 1, 2);
			subConnection.setRotationPoint(0F, 4F, 0F);
			
			subConnection.rotateAngleY = r;
				
				supportTorch = new ModelRenderer(this, 0, 8);
				supportTorch.addBox(-2F, 0F, 4F, 4, 1, 4);
					
					torch = new ModelRenderer(this, 16, 8);
					torch.addBox(-1F, -4F, 5F, 2, 6, 2);
						
				supportTorch.addChild(torch);
					
			subConnection.addChild(supportTorch);
			
		partsChandelierCeiling.add(subConnection);
		
		}
		
		crystal = new ModelRenderer(this, 0, 16);
	    crystal.addBox(-2F, -2F, -2F, 4, 4, 4);
	    crystal.setRotationPoint(0F, 15F, 0F);
	  
	    chandelierCeiling.addChild(crystal);
	    //
		
		//wall
	    
    	chandelierWall = new ModelRenderer(this, 0, 0); 
    	chandelierWall.setRotationPoint(0.0F, 32.0F, 0.0F);

	}
	  
	private void setRotation(ModelRenderer model, float x, float y, float z) {
	    
		model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;  
	}
	  
	public void renderModel(float mult) {
			
		for (ModelRenderer part : partsChandelierCeiling) {
            part.render(mult);
        }
		chandelierCeiling.render(mult);
			
		//chandelierWall.render(mult);	
	}

}