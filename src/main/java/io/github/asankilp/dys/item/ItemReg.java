package io.github.asankilp.dys.item;

import io.github.asankilp.dys.Dys;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ItemReg {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Dys.MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Dys.MODID);



     public static final DeferredBlock<Block> YAJU_BLOCK = BLOCKS.register("yaju_block", YajuBlock::new);
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
     public static final DeferredItem<BlockItem> YAJU_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("yaju_block",YAJU_BLOCK);
    public static final DeferredItem<Item> YAJU = ITEMS.register("yaju", Yaju::new);
    public static final DeferredItem<Item> RINGO = ITEMS.register("ringo", Ringo::new);
    public static final DeferredItem<Item> GOLDEN_RINGO = ITEMS.register("golden_ringo", GoldenRingo::new);
    public static final DeferredItem<Item> DEAD_IRON = ITEMS.register("dead_iron", DeadIron::new);
    public static final DeferredItem<Item> KURUMI_SHOVEL = ITEMS.register("kurumi_shovel", KurumiShovel::new);
    public static final DeferredItem<Item> AKAZA_AKARI = ITEMS.register("akaza_akari", AkazaAkari::new);
}
