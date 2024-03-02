package net.hsneptune.elixiradventures.item.food;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.stat.Stat;

public class CombatApple extends Item {
    public static final FoodComponent CombatAppleFood = (new FoodComponent.Builder())
            .hunger(4)
            .saturationModifier(9.6f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 2), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 3), 1F)
            .build();

    public CombatApple(Settings settings) {
        super(settings);
    }
}
