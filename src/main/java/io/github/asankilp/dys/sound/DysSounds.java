package io.github.asankilp.dys.sound;

import io.github.asankilp.dys.Dys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class DysSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Dys.MODID);
    public static final Supplier<SoundEvent> YAJU_SOUND = SOUNDS.register("ambient.yaju.shout", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.yaju.shout")));
    public static final Supplier<SoundEvent> YAJU_SHORT_SHOUT_SOUND = SOUNDS.register("ambient.yaju.short_shout", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.yaju.short_shout")));
    public static final Supplier<SoundEvent> YAJU_BLOCK_PLACE_SOUND = SOUNDS.register("block.yaju_block.place", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "block.yaju_block.place")));
    public static final Supplier<SoundEvent> TOKUGAWA_SHOUT_SOUND = SOUNDS.register("ambient.tokugawa.shout", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.tokugawa.shout")));
    public static final Supplier<SoundEvent> YAJU_YARIMASU_SOUND = SOUNDS.register("ambient.yaju.yarimasu", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.yaju.yarimasu")));
    public static final Supplier<SoundEvent> AKARI_AKARIN_SOUND = SOUNDS.register("ambient.akaza_akari.akarin", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.akaza_akari.akarin")));
    public static final Supplier<SoundEvent> GABA_GOLD_SOUND = SOUNDS.register("ambient.gaba.gold", () ->
            SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID,"ambient.gaba.gold")));
    public static final Supplier<SoundEvent> DEDEDON_SOUND = SOUNDS.register("ambient.dededon", ()
            -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Dys.MODID, "ambient.dededon")));


}
