package com.luckgod.luckyitems.item.tool;

import com.luckgod.luckyitems.event.KeyInputHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;

import java.util.List;

import static com.luckgod.luckyitems.item.ModItems.OVERCHARGED_PICKAXE;

public class ChargedPickaxeItem extends PickaxeItem {
    public int charge = 0;

    public ChargedPickaxeItem(int charge, ToolMaterial material, Settings settings) {
        super(material, charge - 1, 0.5f*charge, settings);
        this.charge = charge;


    }


    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        if (this.charge < 5) {
            tooltip.add(Text.translatable("item.luckyitems.charged.tooltip1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.luckyitems.charged.tooltip2", KeyInputHandler.dechargeBinding.getBoundKeyLocalizedText()).formatted(Formatting.GRAY));
        } else if (this.charge == 5) {
            tooltip.add(Text.translatable("item.luckyitems.charged.tooltip3").formatted(Formatting.RED));
            tooltip.add(Text.translatable("item.luckyitems.charged.tooltip4", KeyInputHandler.dechargeBinding.getBoundKeyLocalizedText()).formatted(Formatting.RED));
        }
    }
}

