package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.BlockRegistry;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ExtraSpongesModelGenerator extends FabricModelProvider {
    public ExtraSpongesModelGenerator(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(BlockRegistry.IRON_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.GOLD_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.DIAMOND_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.NETHERITE_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.WET_IRON_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.WET_GOLD_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.WET_DIAMOND_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.WET_NETHERITE_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.LAVA_SPONGE);
        blockStateModelGenerator.createTrivialCube(BlockRegistry.WET_LAVA_SPONGE);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
