package io.github.asankilp.dys.item;

import io.github.asankilp.dys.sound.DysSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Yaju extends Item {
    public Yaju() {
        super(new Properties());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        if (levelIn instanceof ServerLevel serverLevel) {
            LivingEntity attackTarget = serverLevel.getNearestEntity(Monster.class, TargetingConditions.DEFAULT, playerIn, 10, 10, 10, playerIn.getBoundingBox().inflate(10));
            if (attackTarget != null) {
                Vec3 vec3 = playerIn.position().add(0.0, 1.600000023841858, 0.0);
                Vec3 vec32 = attackTarget.getEyePosition().subtract(vec3);
                Vec3 vec33 = vec32.normalize();

                for (int i = 1; i < Mth.floor(vec32.length()) + 7; ++i) {
                    Vec3 vec34 = vec3.add(vec33.scale((double) i));
                    serverLevel.sendParticles(ParticleTypes.SONIC_BOOM, vec34.x, vec34.y, vec34.z, 1, 0.0, 0.0, 0.0, 0.0);
                }
                playerIn.getCooldowns().addCooldown(this, 50);
                levelIn.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), DysSounds.YAJU_SHORT_SHOUT_SOUND.get(), playerIn.getSoundSource(), 0.2F, 1F);
                levelIn.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.WARDEN_SONIC_BOOM, playerIn.getSoundSource(), 3.0F, 1.0F);
                attackTarget.hurt(serverLevel.damageSources().sonicBoom(playerIn), 10.0F);
            }
        }
        return super.use(levelIn, playerIn, handIn);
        }
}
