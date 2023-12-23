package io.github.asankilp.dys;
import io.github.asankilp.dys.block.DysBlocks;
import io.github.asankilp.dys.effect.DysEffects;
import io.github.asankilp.dys.item.DysItems;
import io.github.asankilp.dys.sound.DysSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Dys.MODID)
public class Dys {
    public static final String MODID = "dys";
    public Dys() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        DysBlocks.BLOCKS.register(modEventBus);
        DysItems.ITEMS.register(modEventBus);
        DysSounds.SOUNDS.register(modEventBus);
        DysEffects.EFFECTS.register(modEventBus);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }
}
