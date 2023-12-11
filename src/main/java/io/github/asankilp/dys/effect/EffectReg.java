package io.github.asankilp.dys.effect;

import io.github.asankilp.dys.Dys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class EffectReg {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, Dys.MODID);
    public static final Supplier<MobEffect> SENPAI_STARE = EFFECTS.register("senpai_stare", SenpaiEffect::new);


}
