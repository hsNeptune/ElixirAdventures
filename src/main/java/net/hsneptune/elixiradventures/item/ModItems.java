package net.hsneptune.elixiradventures.item;

import net.hsneptune.elixiradventures.ElixirAdventuresMod;
import net.hsneptune.elixiradventures.item.food.CombatApple;
import net.hsneptune.elixiradventures.item.food.DApple;
import net.hsneptune.elixiradventures.item.food.EApple;
import net.hsneptune.elixiradventures.item.food.IApple;
import net.hsneptune.elixiradventures.item.tool.ChargedPickaxeItem;
import net.hsneptune.elixiradventures.materials.ChargedToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item IRON_APPLE = registerItem("iron_apple", new IApple(new FabricItemSettings().food(IApple.IAppleFood)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new DApple(new FabricItemSettings().food(DApple.DAppleFood)));
    public static final Item EMERALD_APPLE = registerItem("emerald_apple", new EApple(new FabricItemSettings().food(EApple.EAppleFood)));
    public static final Item COMBAT_APPLE = registerItem("combat_apple", new EApple(new FabricItemSettings().food(CombatApple.CombatAppleFood)));
    public static final Item UNCHARGED_PICKAXE = registerItem("uncharged_pickaxe", new ChargedPickaxeItem(0, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));
    public static final Item CHARGED_PICKAXE_TIER_1 = registerItem("charged_pickaxe_t1", new ChargedPickaxeItem(1, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));
    public static final Item CHARGED_PICKAXE_TIER_2 = registerItem("charged_pickaxe_t2", new ChargedPickaxeItem(2, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));
    public static final Item CHARGED_PICKAXE_TIER_3 = registerItem("charged_pickaxe_t3", new ChargedPickaxeItem(3, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));
    public static final Item CHARGED_PICKAXE_TIER_4 = registerItem("charged_pickaxe_t4", new ChargedPickaxeItem(4, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));
    public static final Item OVERCHARGED_PICKAXE = registerItem("overcharged_pickaxe", new ChargedPickaxeItem(5, ChargedToolMaterial.INSTANCE, new FabricItemSettings()));

    private static void addItemsToFoodsTabItemGroup(FabricItemGroupEntries entries){
        entries.add(IRON_APPLE);
        entries.add(DIAMOND_APPLE);
        entries.add(EMERALD_APPLE);
        entries.add(COMBAT_APPLE);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries){
        entries.add(UNCHARGED_PICKAXE);
        entries.add(CHARGED_PICKAXE_TIER_1);
        entries.add(CHARGED_PICKAXE_TIER_2);
        entries.add(CHARGED_PICKAXE_TIER_3);
        entries.add(CHARGED_PICKAXE_TIER_4);
        entries.add(OVERCHARGED_PICKAXE);

    }

    public static void registerModItems(){
        ElixirAdventuresMod.LOGGER.info("Mod items registered baby! " + ElixirAdventuresMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodsTabItemGroup);


    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ElixirAdventuresMod.MOD_ID, name), item);

    }
}
