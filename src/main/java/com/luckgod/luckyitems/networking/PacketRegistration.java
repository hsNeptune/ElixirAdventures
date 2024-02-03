package com.luckgod.luckyitems.networking;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import static com.luckgod.luckyitems.ElixirAdventuresMod.MOD_ID;
import static com.luckgod.luckyitems.item.ModItems.OVERCHARGED_PICKAXE;


public class PacketRegistration {
    public static final Identifier OVERCHARGE = new Identifier(MOD_ID, "overcharge");
    public static void registerReceivers () {
        ServerPlayNetworking.registerGlobalReceiver(OVERCHARGE, PacketRegistration::recieveOverchargeCommand);
    }

    public static void recieveOverchargeCommand(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                                                PacketByteBuf buf, PacketSender responseSender){
        if (player.getMainHandStack().getItem() == OVERCHARGED_PICKAXE) {




                for (ServerPlayerEntity players: player.getServerWorld().getPlayers()) {



                    if (player.distanceTo(players) < 5.0f) { // todo add math to check player distance from person

                        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(player.getServerWorld());
                        if (lightningEntity != null) {
                            lightningEntity.refreshPositionAfterTeleport(players.getBlockX(), players.getBlockY(), players.getBlockZ());
                            player.getServerWorld().spawnEntity(lightningEntity);
                        }
                        players.damage(players.getDamageSources().lightningBolt(), 15.0f);
                    }
                }
                player.getMainHandStack().damage(player.getMainHandStack().getMaxDamage(), player, player_ -> player_.sendToolBreakStatus(player_.getActiveHand()));

            }
        }
    }

