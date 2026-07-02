package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ExtraSpongesLootGenerator extends FabricBlockLootSubProvider {


    protected ExtraSpongesLootGenerator(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.dropSelf(BlockRegistry.IRON_SPONGE);
        this.dropSelf(BlockRegistry.GOLD_SPONGE);
        this.dropSelf(BlockRegistry.DIAMOND_SPONGE);
        this.dropSelf(BlockRegistry.NETHERITE_SPONGE);
        this.dropSelf(BlockRegistry.WET_IRON_SPONGE);
        this.dropSelf(BlockRegistry.WET_GOLD_SPONGE);
        this.dropSelf(BlockRegistry.WET_DIAMOND_SPONGE);
        this.dropSelf(BlockRegistry.WET_NETHERITE_SPONGE);
        this.dropSelf(BlockRegistry.LAVA_SPONGE);
        this.dropSelf(BlockRegistry.WET_LAVA_SPONGE);
    }
}
