package net.hsneptune.elixiradventures.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ChargedToolMaterial implements ToolMaterial {
    public static final ChargedToolMaterial INSTANCE = new ChargedToolMaterial();




    @Override
    public int getDurability() {
        return 1450;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1.5F;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
}
