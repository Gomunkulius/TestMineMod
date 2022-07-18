package net.gomunkul.testingmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gomunkul.testingmod.TestingMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class Item1 {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item( new FabricItemSettings().group(ItemGroup.MISC)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }


    public static void registratingModItems(){
        TestingMod.LOGGER.info("Registering Mod Items for" + TestingMod.MOD_ID);

    }
}