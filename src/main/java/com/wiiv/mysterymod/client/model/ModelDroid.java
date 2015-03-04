package com.wiiv.mysterymod.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

public class ModelDroid extends ModelBase {

	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();//
	
	private ModelRenderer pillars;
	
	private ModelRenderer core;
	
	private ArrayList<ModelRenderer> innerPanels = new ArrayList<ModelRenderer>();//-
	private ArrayList<ModelRenderer> outerPanels = new ArrayList<ModelRenderer>();//--
	
	public ModelDroid () {
		
		textureWidth = 64;   //default = 64
    	textureHeight = 64;  //default = 32
		
		//main
		
		ModelRenderer main = new ModelRenderer(this, 0, 0);
		
		main.addBox(-5.0F, -5.0F, -5.0F, 
				     10, 10, 10);
		
		main.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		parts.add(main);//
		
		
		//pillars
		
		pillars = new ModelRenderer(this, 0, 20);
		
		for (int x = -1; x <= 1; x += 2) {
			
			for (int z = -1; z <= 1; z += 2) {
				
				pillars.addBox(-1.0F + (x * 3.9999F), -1.0F, -1.0F + (z * 3.9999F), 
						       2, 8, 2);
			}
		}

		//pillars.setRotationPoint(0.0F, -6.0F, 0.0F);
		
			//top
		
			ModelRenderer top = new ModelRenderer(this, 0, 20);
			
			top.addBox(-5.0F, -2.0F, -5.0F, 
					   10, 4, 10);
					
			top.setRotationPoint(0.0F, -3.0F, 0.0F);
		
		pillars.addChild(top);//=
		
		parts.add(pillars);//....
	
		
		//sides
		
		for (float r = 0; r <= Math.PI * 2; r += Math.PI / 2) {

			
			ModelRenderer side = new ModelRenderer(this, 0, 34);
			
			side.addBox(-4.0F, -2.5F, 5.0F,
					    8, 5, 1);
						
			side.setRotationPoint(0.0F, 0.0F, 0.0F);
			
			side.rotateAngleY = r;
		
				//panel layer 1 (inner)
				
				ModelRenderer panel1 = new ModelRenderer(this, 18, 34);
				
				panel1.addBox(-4.0F, -0.5F,  -0.5F,
						     8, 5, 1);
						
				panel1.setRotationPoint(0.0F, -2.0F, 6.5F);
				
					//panel layer 2 (outer)
					
					ModelRenderer panel2 = new ModelRenderer(this, 18, 34);
					
					panel2.addBox(-4.0F, -0.5F,  -0.5F,
							     8, 5, 1);

					panel2.setRotationPoint(0.0F, 5.0F, 0.0F);
			
					//panel2.rotateAngleX = -(float)Math.PI / 2;
							
				panel1.addChild(panel2);
			
			side.addChild(panel1);//**
			
			outerPanels.add(panel2);//--
			
			innerPanels.add(panel1);//-	
				
			parts.add(side);//
				
		}
		
		
		//core
		
		core = new ModelRenderer(this, 30, 0);
		
		core.addBox(-3.0F, -1.0F, -3.0F,
				    6, 2, 6);
		
		core.setRotationPoint(0.0F, -6.0F, 0.0F);
		
		//parts.add(core);//
		
	}
	
	
	public void render(float helmetRotationPosition, float coreRotation, float innerPanelRotation, float outerPanelRotation, float coreR, float coreG, float coreB, float mult) {
		
		pillars.rotationPointY = helmetRotationPosition;
		
		core.rotateAngleY = coreRotation;
		
		for (ModelRenderer panel : innerPanels) {
			
            panel.rotateAngleX = innerPanelRotation;
        }
		
		for (ModelRenderer panel : outerPanels) {
			
            panel.rotateAngleX = outerPanelRotation;
        }
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		//render all parts
		
		for (ModelRenderer part : parts) {
            part.render(mult);
        }
		
		GL11.glColor4f(coreR, coreG, coreB, 1.0F);
		//GL11.glColor4f(droid.getRedCoreColor(), droid.getGreenCoreColor(), droid.getBlueCoreColor(), 1);
		
		core.render(mult);
	}
	

}
