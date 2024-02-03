package net.hsneptune.elixiradventures.item.tool;

import net.hsneptune.elixiradventures.event.KeyInputHandler;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class ChargedPickaxeItem extends PickaxeItem {
    public int charge = 0;

    public ChargedPickaxeItem(int charge, ToolMaterial material, Settings settings) {
        super(material, charge - 1, 0.5f*charge, settings);
        this.charge = charge;


    }


    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        if (this.charge < 5) {
            tooltip.add(Text.translatable("item.elixiradventures.charged.tooltip1").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("item.elixiradventures.charged.tooltip2", KeyInputHandler.dechargeBinding.getBoundKeyLocalizedText()).formatted(Formatting.GRAY));
        } else if (this.charge == 5) {
            tooltip.add(Text.translatable("item.elixiradventures.charged.tooltip3").formatted(Formatting.RED));
            tooltip.add(Text.translatable("item.elixiradventures.charged.tooltip4", KeyInputHandler.dechargeBinding.getBoundKeyLocalizedText()).formatted(Formatting.RED));
        }
    }
}

