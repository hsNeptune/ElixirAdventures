package net.hsneptune.elixiradventures.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hsneptune.elixiradventures.ElixirAdventuresMod.MOD_ID;

public class RegisterEffects {
    public static final StatusEffect CHARGED = new ChargedEffect();

    public static void registerStatusEffects () {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "charged"), CHARGED);
    }
}
