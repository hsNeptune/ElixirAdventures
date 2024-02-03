package com.luckgod.luckyitems.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import static com.luckgod.luckyitems.networking.PacketRegistration.OVERCHARGE;

public class KeyInputHandler {
    public static KeyBinding dechargeBinding;

    public static final String KEY_CATEGORY_1 = "key.category.luckyitems.general";

    public static void registerKeyPresses() {
        initializeKeys();
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!(client.player == null)) {
                if (dechargeBinding.isPressed() && MinecraftClient.getInstance().options.attackKey.isPressed()) {
                    ClientPlayNetworking.send(OVERCHARGE, PacketByteBufs.empty());
                }


            }
        });
    }

    public static void initializeKeys() {
        dechargeBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.luckyitems.use_overcharge",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                KEY_CATEGORY_1
        ));

    }
}