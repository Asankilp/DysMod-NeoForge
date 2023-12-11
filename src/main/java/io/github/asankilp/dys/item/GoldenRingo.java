package io.github.asankilp.dys.item;

import io.github.asankilp.dys.effect.EffectReg;
import io.github.asankilp.dys.sound.SoundReg;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class GoldenRingo extends Item {
    private static final FoodProperties ringo = (new FoodProperties.Builder())
            .saturationMod(1.2F)
            .nutrition(4)
            .effect((new MobEffectInstance(MobEffects.CONFUSION, 114, 514, true, false)), 1)
//            .effect((new MobEffectInstance(MobEffects.DARKNESS, 114, 514, true, false)), 1)

            .build();

    public GoldenRingo() {
        super(new Properties().food(ringo));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemIn, Level levelIn, LivingEntity entityIn) {
//         entityIn.getEffect(EffectReg.SENPAI.get()).getAmplifier();
//         entityIn.addEffect(new MobEffectInstance(EffectReg.SENPAI.get(), 1000, 1, true, false), entityIn);
        if (entityIn.hasEffect(EffectReg.SENPAI_STARE.get())) {
            int level = entityIn.getEffect(EffectReg.SENPAI_STARE.get()).getAmplifier();
            if (level < 1) {
                entityIn.addEffect(new MobEffectInstance(EffectReg.SENPAI_STARE.get(), 1000, level + 1, true, true), entityIn);
            }
            if (level == 0) {
                levelIn.playSound((Player) null, entityIn.getX(), entityIn.getY(), entityIn.getZ(), SoundReg.GABA_GOLD_SOUND.get(), SoundSource.AMBIENT, 0.5f, 1f);
                entityIn.sendSystemMessage(Component.translatable("msg.golden_ringo.2"));

            }
            if (level >= 1) {
                entityIn.removeEffect(EffectReg.SENPAI_STARE.get());
                entityIn.addEffect((new MobEffectInstance(MobEffects.DARKNESS, 114, 514, true, false)));
                if (levelIn instanceof ServerLevel serverLevel) {
                    if (SpawnUtil.trySpawnMob(EntityType.WARDEN, MobSpawnType.TRIGGERED, serverLevel, entityIn.blockPosition(), 20, 5, 6, SpawnUtil.Strategy.ON_TOP_OF_COLLIDER).isPresent()) {
                        entityIn.sendSystemMessage(Component.translatable("msg.golden_ringo.3"));
                        levelIn.playSound((Player) null, entityIn.getX(), entityIn.getY(), entityIn.getZ(), SoundReg.DEDEDON_SOUND.get(), SoundSource.AMBIENT, 0.5f, 1f);
                    } else {
                        entityIn.sendSystemMessage(Component.translatable("msg.golden_ringo.3.1"));
                    }
                }
            }
        } else {
            entityIn.addEffect(new MobEffectInstance(EffectReg.SENPAI_STARE.get(), 1000, 0, true, true), entityIn);
            levelIn.playSound((Player) null, entityIn.getX(), entityIn.getY(), entityIn.getZ(), SoundReg.TOKUGAWA_SHOUT_SOUND.get(), SoundSource.AMBIENT, 0.5f, 1f);
            entityIn.sendSystemMessage(Component.translatable("msg.golden_ringo.1"));
        }
        return super.finishUsingItem(itemIn, levelIn, entityIn);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level levelIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.golden_ringo.tip1"));
        tooltip.add(Component.translatable("item.golden_ringo.tip2"));
    }
}