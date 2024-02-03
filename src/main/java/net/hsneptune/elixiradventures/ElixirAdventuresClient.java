package net.hsneptune.elixiradventures;

import net.hsneptune.elixiradventures.event.KeyInputHandler;
import net.hsneptune.elixiradventures.networking.PacketRegistration;
import net.fabricmc.api.ClientModInitializer;

public class ElixirAdventuresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyInputHandler.registerKeyPresses();
        PacketRegistration.registerReceivers();
    }
}
