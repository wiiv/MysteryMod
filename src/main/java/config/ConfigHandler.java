package config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import com.wiiv.mysterymod.reference.Blocks;
import com.wiiv.mysterymod.reference.Items;

public class ConfigHandler {
	
	public static Configuration configuration;
	
	public static void init(File configFile){
	Configuration config = new Configuration(configFile);
	
	try{
		
		//load config properties
		config.load();
		
			//read config properties
			/*
			Blocks.MACHINE_ID = config.getBlock(Blocks.MACHINE_KEY, Blocks.MACHINE_DEFAULT).getInt();
			Blocks.RAINBOW_ID = config.getBlock(Blocks.RAINBOW_KEY, Blocks.RAINBOW_DEFAULT).getInt();
			Blocks.ROTATIONAL_ID = config.getBlock(Blocks.ROTATIONAL_KEY, Blocks.ROTATIONAL_DEFAULT).getInt();
			Blocks.BOMB_ID = config.getBlock(Blocks.BOMB_KEY, Blocks.BOMB_DEFAULT).getInt();
			Blocks.POISON_ID = config.getBlock(Blocks.POISON_KEY, Blocks.POISON_DEFAULT).getInt();
			Blocks.ALEMBIC_ID = config.getBlock(Blocks.ALEMBIC_KEY, Blocks.ALEMBIC_DEFAULT).getInt();
			Blocks.CHANDELIER_ID = config.getBlock(Blocks.CHANDELIER_KEY, Blocks.CHANDELIER_DEFAULT).getInt();
			
			Items.WAND_ID = config.getItem(Items.WAND_KEY, Items.WAND_DEFAULT).getInt() - 256;
			Items.CARD_ID = config.getItem(Items.CARD_KEY, Items.CARD_DEFAULT).getInt() - 256;
			Items.DEATHSTONE_ID = config.getItem(Items.DEATHSTONE_KEY, Items.DEATHSTONE_DEFAULT).getInt() - 256;
			Items.PRISM_ID = config.getItem(Items.PRISM_KEY, Items.PRISM_DEFAULT).getInt() - 256;
			Items.DROID_ID = config.getItem(Items.DROID_KEY, Items.DROID_DEFAULT).getInt() - 256;
			*/
			boolean configValue = config.get(config.CATEGORY_GENERAL, "configValue", true, "").getBoolean();
	}
	
	catch (Exception e){
		//log the exception
	}
	
	finally{
		
		config.save();
	}
	
	}
}