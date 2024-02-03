package com.luckgod.luckyitems.blocks;

import com.luckgod.luckyitems.ElixirAdventuresMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COMPRESSED_IRON_BLOCK = registerBlock("compressed_iron_block",
            new Block(FabricBlockSettings.create().strength(7.0f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ElixirAdventuresMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ElixirAdventuresMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }

    public static void registerBlocks() {
        ElixirAdventuresMod.LOGGER.info("Registering mod blocks!");
    }
}
