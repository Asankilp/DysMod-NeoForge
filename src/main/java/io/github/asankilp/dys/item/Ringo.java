package io.github.asankilp.dys.item;

import io.github.asankilp.dys.sound.DysSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Ringo extends Item {
    private static final FoodProperties RINGO = (new FoodProperties.Builder())
            .saturationMod(1.2F)
            .nutrition(4)
            .effect((new MobEffectInstance(MobEffects.CONFUSION, 114, 514, true, false)), 1)
            .build();

    public Ringo() {
        super(new Properties().food(RINGO));
    }
    @Override
    public ItemStack finishUsingItem(ItemStack itemIn, Level levelIn, LivingEntity entityIn) {
        levelIn.playSound((Player) null, entityIn.getX(), entityIn.getY(), entityIn.getZ(), DysSounds.TOKUGAWA_SHOUT_SOUND.get(), SoundSource.AMBIENT, 0.5f, 1f);
        return super.finishUsingItem(itemIn, levelIn, entityIn);
    }
}