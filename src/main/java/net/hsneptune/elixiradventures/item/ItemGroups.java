package net.hsneptune.elixiradventures.item;

import net.hsneptune.elixiradventures.ElixirAdventuresMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hsneptune.elixiradventures.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.hsneptune.elixiradventures.ElixirAdventuresMod.MOD_ID;

public class ItemGroups {
    public static final ItemGroup LUCKY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "elixiradventures"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elixiradventures")).icon(() -> new ItemStack(ModItems.DIAMOND_APPLE)).entries((displayContext, entries) -> {
                entries.add(ModItems.IRON_APPLE);
                entries.add(ModItems.DIAMOND_APPLE);
                entries.add(ModItems.EMERALD_APPLE);
                entries.add(ModItems.UNCHARGED_PICKAXE);
                entries.add(ModItems.CHARGED_PICKAXE_TIER_1);
                entries.add(ModItems.CHARGED_PICKAXE_TIER_2);
                entries.add(ModItems.CHARGED_PICKAXE_TIER_3);
                entries.add(ModItems.CHARGED_PICKAXE_TIER_4);
                entries.add(ModItems.OVERCHARGED_PICKAXE);
                entries.add(ModBlocks.COMPRESSED_IRON_BLOCK);
            }).build());

    public static void registerItemGroups() {
        ElixirAdventuresMod.LOGGER.info("Registering item groups for " + MOD_ID);
    }
}
