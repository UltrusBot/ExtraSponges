package me.ultrusmods.extrasponges.register;

import me.ultrusmods.extrasponges.Constants;
import me.ultrusmods.extrasponges.block.ExtraSpongeBlock;
import me.ultrusmods.extrasponges.block.ExtraWetSpongeBlock;
import me.ultrusmods.extrasponges.block.LavaSpongeBlock;
import me.ultrusmods.extrasponges.block.WetLavaSpongeBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class 
BlockRegistry {
    public static Block IRON_SPONGE = registerSponge("iron_sponge", 18, 128);
    public static Block GOLD_SPONGE = registerSponge("gold_sponge", 30, 192);
    public static Block DIAMOND_SPONGE = registerSponge("diamond_sponge", 42, 256);
    public static Block NETHERITE_SPONGE = registerSponge("netherite_sponge", 66, 384);
    public static Block WET_IRON_SPONGE = registerWetSponnge("wet_iron_sponge", IRON_SPONGE);
    public static Block WET_GOLD_SPONGE = registerWetSponnge("wet_gold_sponge", GOLD_SPONGE);
    public static Block WET_DIAMOND_SPONGE = registerWetSponnge("wet_diamond_sponge", DIAMOND_SPONGE);
    public static Block WET_NETHERITE_SPONGE = registerWetSponnge("wet_netherite_sponge", NETHERITE_SPONGE);
    
    public static Block LAVA_SPONGE = register("lava_sponge", new LavaSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE).setId(Constants.key(Registries.BLOCK, "lava_sponge")), 6, 64));
    public static Block WET_LAVA_SPONGE = register("wet_lava_sponge", new WetLavaSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE).setId(Constants.key(Registries.BLOCK, "wet_lava_sponge")), LAVA_SPONGE.defaultBlockState()));

    public static void register() {
        ((ExtraSpongeBlock)IRON_SPONGE).setWetSponge(WET_IRON_SPONGE);
        ((ExtraSpongeBlock)GOLD_SPONGE).setWetSponge(WET_GOLD_SPONGE);
        ((ExtraSpongeBlock)DIAMOND_SPONGE).setWetSponge(WET_DIAMOND_SPONGE);
        ((ExtraSpongeBlock)NETHERITE_SPONGE).setWetSponge(WET_NETHERITE_SPONGE);

        ((LavaSpongeBlock)LAVA_SPONGE).setWetSponge(WET_LAVA_SPONGE);

    }
    
    public static Block registerSponge(String id, int absorption, int maxAbsorption) {
        return register(id, new ExtraSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE)
                .setId(Constants.key(Registries.BLOCK, id)), absorption, maxAbsorption));
    }
    public static Block registerWetSponnge(String id, Block drySponge) {
        return register(id, new ExtraWetSpongeBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.SPONGE)
                .setId(Constants.key(Registries.BLOCK, id)), drySponge.defaultBlockState()));
    }

    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Constants.id(id), block);
    }
}
