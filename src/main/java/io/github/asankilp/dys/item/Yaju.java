package io.github.asankilp.dys.item;

import io.github.asankilp.dys.sound.SoundReg;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Yaju extends Item {
    public Yaju() {
        super(new Properties());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        if (levelIn.isClientSide) {
            levelIn.playSound(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundReg.YAJU_SOUND.get(), playerIn.getSoundSource(), 10F, 1F);
        }
        return super.use(levelIn, playerIn, handIn);
        }
}
