package com.wiiv.mysterymod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.gui.container.ContainerMine;
import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.network.MessageHandleGuiButtonPress;
import com.wiiv.mysterymod.network.MessageHandleTextUpdate;
import com.wiiv.mysterymod.network.NetworkHandler;
import com.wiiv.mysterymod.tileentities.TileEntityMine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMine extends GuiMMGeneric{
	
	private final TileEntityMine mine;
	
	private GuiButton resetButton;
	
	private GuiTextField textField;

	public GuiMine(InventoryPlayer invPlayer, TileEntityMine mine) {
		super(new ContainerMine(invPlayer, mine));
		
		this.mine = mine;
		
		xSize = 176;
		ySize = 144;
	}

	private static final ResourceLocation texture = new ResourceLocation("mm", "textures/gui/mine.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		
		GL11.glColor4f(1, 1, 1, 1);
		
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int meta = mine.getWorldObj().getBlockMetadata(mine.xCoord, mine.yCoord, mine.zCoord);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
		drawTexturedModelRectFromIcon(guiLeft + 151, guiTop + 26, BlocksMMInit.mine.getIcon(1, meta), 16, 16);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		super.drawGuiContainerForegroundLayer(x, y);
		fontRendererObj.drawString(I18n.format("gui.mm.mine.timer", mine.getTimer()), 27, 30, 0x404040);
	}
	
	private static final String ENABLE_TEXT = "ON";
	private static final String DISABLE_TEXT = "OFF";
	
	@Override
	public void initGui() {
		super.initGui();
		
		buttonList.clear();
		resetButton = new GuiButton(0, guiLeft + 122, guiTop + 24, 24, 20, "");
		buttonList.add(resetButton);
		
		textField = new GuiTextField(this.fontRendererObj, guiLeft + 8, guiTop + 6, 80, 12);
        textField.setMaxStringLength(40);
        textField.setText(mine.getTarget());
	}
	
	@Override
	public void onTextfieldUpdate(int id){
		
		if (id == 0) {
			textField.setText(mine.getTarget());
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		
		if (button.id == 0) {
			
			resetButton.displayString = button.displayString.equals(DISABLE_TEXT) ? ENABLE_TEXT : DISABLE_TEXT;
			
			NetworkHandler.sendToServer(new MessageHandleGuiButtonPress(mine, 0));
		}
	}
	
	/**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    @Override
	protected void keyTyped(char character, int keyCode)
    {
        if(textField.textboxKeyTyped(character, keyCode)){
        	NetworkHandler.sendToServer(new MessageHandleTextUpdate(mine, 0, textField.getText()));
        }else {
            super.keyTyped(character, keyCode);
        }
    }
	
	/**
     * Called when the mouse is clicked.
     */
    @Override
	protected void mouseClicked(int mouseX, int mouseY, int button)
    {
        super.mouseClicked(mouseX, mouseY, button);
        textField.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
	public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        super.drawScreen(mouseX, mouseY, partialTick);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        this.textField.drawTextBox();
    }
}
