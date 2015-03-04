package com.wiiv.mysterymod.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAlembic extends ModelBase{
	
	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();//
	
	private ModelRenderer legs;
	
	private ModelRenderer filter;

	public ModelAlembic () {
		
		textureWidth = 64;   //default = 64
    	textureHeight = 32;  //default = 32
    	
    	
    	//structure S = TNB
    	
    	ModelRenderer structure = new ModelRenderer(this, 0, 0);
    
    	structure.setRotationPoint(0.0F, 3.0F, 0.0F);
    	
		
			//top T
		
			ModelRenderer top = new ModelRenderer(this, 0, 0);
				
			top.addBox(-3.0F, -11.0F, -3.0F,
					   6, 5, 6);
							
			top.setRotationPoint(0.0F, 0.0F, 0.0F);
		
				//snout	S
			
				ModelRenderer snout = new ModelRenderer(this, 24, 0);
			
				snout.addBox(3.0F, -11.0F, -1.0F,
						     5, 2, 2);
							
				//snout.setRotationPoint(5.0F, -8.0F, 0.0F);
					
			top.addChild(snout);
			
		structure.addChild(top);	
		
			//neck N
			
			ModelRenderer neck = new ModelRenderer(this, 30, 11);
			
			neck.addBox(-2.0F, -6.0F, -2.0F,
					    4, 1, 4);
						
			//neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		structure.addChild(neck);
			
			//bottom B
	    	
    		ModelRenderer bottom = new ModelRenderer(this, 0, 11);
    	
    		bottom.addBox(-5.0F, -5.0F, -5.0F, 
    				      10, 9, 10);
    		
    		//bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		
    	structure.addChild(bottom);
    	
		parts.add(structure);//
		
		
		//filter -"F"-
		
		filter = new ModelRenderer(this, 48, 0);
		
		filter.addBox(-2.0F, -4.0F, -2.0F, 
				      4, 7, 4);
		
		filter.setRotationPoint(-6.0F, -5.0F, 0.0F);
		
			//tubeTop "-"F-
		
			ModelRenderer tubeTop = new ModelRenderer(this, 40, 0);
			
			tubeTop.addBox(-1.0F, -6.0F, -1.0F, 
				           2, 2, 2);
			
			//tubeTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		filter.addChild(tubeTop);
		
			//tubeBottom -F"-"
	
			ModelRenderer tubeBottom = new ModelRenderer(this, 40, 0);
			
			tubeBottom.addBox(-1.0F, 3.0F, -1.0F, 
				              2, 2, 2);
			
			//tubeBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		filter.addChild(tubeBottom);
		
			//tubeConnection "|"
		
			ModelRenderer tubeConnection = new ModelRenderer(this, 30, 11);
		
			tubeConnection.addBox(4.0F, -4.0F, -2.0F, 
			                      4, 1, 4);
		
			tubeConnection.setRotationPoint(0.0F, 0.0F, 0.0F);
	
		filter.addChild(tubeConnection);
		
		parts.add(filter);
		
		
		//legs on ground ....
		
		legs = new ModelRenderer(this, 0, 0);
		
		for (int x = -1; x <= 1; x += 2) {
			
			for (int z = -1; z <= 1; z += 2) {
				
				legs.addBox(0.0F + (x * 3.4999F), 0.0F, 0.0F + (z * 3.4999F), 
						       1, 1, 1);
				legs.setRotationPoint(-0.5F, 7.0F, -0.5F);
			}
		}
		
		parts.add(legs);
		
	}
	
	public void renderModel(float mult) {
		
		for (ModelRenderer part : parts) {
	        part.render(mult);
	    }
	}

}
