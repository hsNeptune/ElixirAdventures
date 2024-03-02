package net.hsneptune.elixiradventures.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.hsneptune.elixiradventures.item.ModItems.*;


//
@Mixin(Entity.class)
public abstract class EntityMixin implements LivingEntityMixin  {
    public long lastLightningStrike = 0;
    @Inject( at = @At("HEAD"), method = "onStruckByLightning(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LightningEntity;)V")
    private void onStrikeByLightning(CallbackInfo ci) {
        if (((Entity) (Object) this) instanceof ServerPlayerEntity) {
            System.out.println("It was a player!");
            ItemStack itemStack = ((PlayerEntity) (Object) this).getMainHandStack();
            if (((((LivingEntity) (Object) this).getWorld().getTime() - this.lastLightningStrike) > 20)) {

                if ((itemStack.getItem()) == UNCHARGED_PICKAXE) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(CHARGED_PICKAXE_TIER_1));

                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));

                } else if (((itemStack.getItem()) == CHARGED_PICKAXE_TIER_1)) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(CHARGED_PICKAXE_TIER_2));

                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));
                } else if (((itemStack.getItem()) == CHARGED_PICKAXE_TIER_2)) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(CHARGED_PICKAXE_TIER_3));

                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));
                } else if (((itemStack.getItem()) == CHARGED_PICKAXE_TIER_3)) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(CHARGED_PICKAXE_TIER_4));

                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));
                } else if (((itemStack.getItem()) == CHARGED_PICKAXE_TIER_4)) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, new ItemStack(OVERCHARGED_PICKAXE));

                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));
                } else if (((itemStack.getItem()) == OVERCHARGED_PICKAXE)) {
                    ((LivingEntity) (Object) this).clearActiveItem();
                    ((PlayerEntity) (Object) this).equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    ((PlayerEntity) (Object) this).sendMessage(Text.of("Your pickaxe fried up"));
                    ItemStack newItemStack = ((PlayerEntity) (Object) this).getMainHandStack();
                    newItemStack.damage(itemStack.getDamage() + 200, ((PlayerEntity) (Object) this), player -> player.sendToolBreakStatus(player.getActiveHand()));
                }
            }
        }
        this.lastLightningStrike = ((Entity) (Object) this).getWorld().getTime();
    }


}
