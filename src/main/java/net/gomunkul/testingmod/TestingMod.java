package net.gomunkul.testingmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gomunkul.testingmod.block.Blocks;
import net.gomunkul.testingmod.items.Item1;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;



public class TestingMod implements ModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	private static Block regBlock(String name, Block block, ItemGroup tab){
		registerBlockItem(name,block,tab);
		return Registry.register(Registry.BLOCK, new Identifier(TestingMod.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup tab){
		return Registry.register(Registry.ITEM, new Identifier(TestingMod.MOD_ID,name), new BlockItem(block, new FabricItemSettings().group(tab)));
	}

	public static final Block MYTHRIL_BLOCK = regBlock("mythril_block",
			new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ItemGroup.MISC);

	public static final String MOD_ID = "testingmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Item1.registratingModItems();
		Blocks.registerModBlocks();
	}
}
