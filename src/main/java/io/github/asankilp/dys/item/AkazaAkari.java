package io.github.asankilp.dys.item;

import io.github.asankilp.dys.sound.DysSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AkazaAkari extends Item {
    public AkazaAkari() {
        super(new Properties());

    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 140, 4, true, false));
        playerIn.getCooldowns().addCooldown(this, 190);
        levelIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), DysSounds.AKARI_AKARIN_SOUND.get(), SoundSource.AMBIENT, 0.5f, 1f);
        if(!playerIn.getAbilities().instabuild) {
            stack.shrink(1);
        }
        return super.use(levelIn, playerIn, handIn);
    }
}
