package com.wiiv.mysterymod.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBomb extends ModelBase
{
  //fields
	
	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();
	
    //ModelRenderer bomb;
    //ModelRenderer jet;
    //ModelRenderer [] wings;
    //ModelRenderer wing;
    
  public ModelBomb() {
	  
	  textureWidth = 64;
	  textureHeight = 32;
     
	  //bomb
    
	  ModelRenderer bomb = new ModelRenderer(this, 0, 0);
	  bomb.addBox(-3F, -7F, -3F, 
			      6, 12, 6, 
			      0.0F);
	  bomb.setRotationPoint(0F, 12F, 0F);
	  
	  bomb.mirror = true;
	  
	  parts.add(bomb);
	  
	  setRotation(bomb, 0F, 0F, 0F);
      
	  //jet
      
	  ModelRenderer jet = new ModelRenderer(this, 24, 0);
      jet.addBox(-2F, -11F, -2F,
    		     4, 4, 4, 
    		     0.0F);
      jet.setRotationPoint(0F, 12F, 0F);
      
      //jet.mirror = true;
      
      parts.add(jet);
      
      setRotation(jet, 0F, 0F, 0F);
      
      //wings
      
      /*wings = new ModelRenderer[4];
      for (int i = 0; i < wings.length; i++) {
   */
      for (float r = 0; r <= Math.PI * 2; r += Math.PI / 2) {
    	  
    	  ModelRenderer wing = new ModelRenderer(this, 24, 8);
    	  wing.addBox(-5F, -13F, -0.5F, 
    			      4, 8, 1, 
    			      0.0F);
    	  wing.setRotationPoint(0F, 12F, 0F);
    	  
    	  wing.mirror = true;
    	  
    	  setRotation(wing, 0F, 0F, 0F); 
    	  
    	  wing.rotateAngleY = r;
    	  
    	  parts.add(wing);
      }
    	/*  
      }*/
  }
  
  public void render(Entity entity, float val1, float val2, float val3, float val4, float val5, float mult) {
	  
    /*for (int i = 0; i < wings.length; i++) {
    	wings[i].render(f5);
    }*/
    
	  for (ModelRenderer part : parts) {
        part.render(mult);
        
	  }
    
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    
	  model.rotateAngleX = x;
	  model.rotateAngleY = y;
	  model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float val1, float val2, float val3, float val4, float val5, float val6, Entity entity) {
    
	  super.setRotationAngles(val1, val2, val3, val4, val5, val6, entity);
  }

}
