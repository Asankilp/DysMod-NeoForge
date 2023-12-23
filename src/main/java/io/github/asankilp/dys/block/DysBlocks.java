package io.github.asankilp.dys.block;

import io.github.asankilp.dys.Dys;
import io.github.asankilp.dys.item.YajuBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DysBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Dys.MODID);



    public static final DeferredBlock<Block> YAJU_BLOCK = BLOCKS.register("yaju_block", YajuBlock::new);

}
