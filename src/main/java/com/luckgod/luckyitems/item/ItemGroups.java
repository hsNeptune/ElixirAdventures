package com.luckgod.luckyitems.item;

import com.luckgod.luckyitems.ElixirAdventuresMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.luckgod.luckyitems.ElixirAdventuresMod.MOD_ID;
import static com.luckgod.luckyitems.blocks.ModBlocks.COMPRESSED_IRON_BLOCK;
import static com.luckgod.luckyitems.item.ModItems.*;

public class ItemGroups {
    public static final ItemGroup LUCKY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "luckyitems"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.luckyitems")).icon(() -> new ItemStack(ModItems.DIAMOND_APPLE)).entries((displayContext, entries) -> {
                entries.add(IRON_APPLE);
                entries.add(DIAMOND_APPLE);
                entries.add(EMERALD_APPLE);
                entries.add(UNCHARGED_PICKAXE);
                entries.add(CHARGED_PICKAXE_TIER_1);
                entries.add(CHARGED_PICKAXE_TIER_2);
                entries.add(CHARGED_PICKAXE_TIER_3);
                entries.add(CHARGED_PICKAXE_TIER_4);
                entries.add(OVERCHARGED_PICKAXE);
                entries.add(COMPRESSED_IRON_BLOCK);
            }).build());

    public static void registerItemGroups() {
        ElixirAdventuresMod.LOGGER.info("Registering item groups for " + MOD_ID);
    }
}
