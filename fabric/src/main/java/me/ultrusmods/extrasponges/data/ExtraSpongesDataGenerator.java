package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

public class ExtraSpongesDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ExtraSpongesModelGenerator::new);
        pack.addProvider(ExtraSpongesLootGenerator::new);
        pack.addProvider(ExtraSpongesRecipeGenerator::new);

        pack.addProvider((output, registriesFuture) -> new FabricTagsProvider.ItemTagsProvider(output, registriesFuture) {
            @Override
            protected void addTags(HolderLookup.Provider registries) {
                this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT)
                        .add(ItemRegistry.IRON_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.GOLD_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.DIAMOND_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.NETHERITE_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.WET_IRON_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.WET_GOLD_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.WET_DIAMOND_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.WET_NETHERITE_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.LAVA_SPONGE.builtInRegistryHolder().key())
                        .add(ItemRegistry.WET_LAVA_SPONGE.builtInRegistryHolder().key());
            }
        });

    }
}
