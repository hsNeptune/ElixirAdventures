package com.luckgod.luckyitems;

import com.luckgod.luckyitems.event.KeyInputHandler;
import com.luckgod.luckyitems.networking.PacketRegistration;
import net.fabricmc.api.ClientModInitializer;

public class ElixirAdventuresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyInputHandler.registerKeyPresses();
        PacketRegistration.registerReceivers();
    }
}
