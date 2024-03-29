package me.ultrusmods.extrasponges.client;

import me.ultrusmods.extrasponges.ExtraSponges;
import me.ultrusmods.extrasponges.block.BlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    private static final String MOD_ID = ExtraSponges.MOD_ID;
    public static Item IRON_SPONGE = register("iron_sponge", new BlockItem(BlockRegistry.IRON_SPONGE, new FabricItemSettings()));
    public static Item GOLD_SPONGE = register("gold_sponge", new BlockItem(BlockRegistry.GOLD_SPONGE, new FabricItemSettings()));
    public static Item DIAMOND_SPONGE = register("diamond_sponge", new BlockItem(BlockRegistry.DIAMOND_SPONGE, new FabricItemSettings()));
    public static Item NETHERITE_SPONGE = register("netherite_sponge", new BlockItem(BlockRegistry.NETHERITE_SPONGE, new FabricItemSettings()));
    public static Item WET_IRON_SPONGE = register("wet_iron_sponge", new BlockItem(BlockRegistry.WET_IRON_SPONGE, new FabricItemSettings()));
    public static Item WET_GOLD_SPONGE = register("wet_gold_sponge", new BlockItem(BlockRegistry.WET_GOLD_SPONGE, new FabricItemSettings()));
    public static Item WET_DIAMOND_SPONGE = register("wet_diamond_sponge", new BlockItem(BlockRegistry.WET_DIAMOND_SPONGE, new FabricItemSettings()));
    public static Item WET_NETHERITE_SPONGE = register("wet_netherite_sponge", new BlockItem(BlockRegistry.WET_NETHERITE_SPONGE, new FabricItemSettings()));
    public static Item LAVA_SPONGE = register("lava_sponge", new BlockItem(BlockRegistry.LAVA_SPONGE, new FabricItemSettings()));
    public static Item WET_LAVA_SPONGE = register("wet_lava_sponge", new BlockItem(BlockRegistry.WET_LAVA_SPONGE, new FabricItemSettings()));

    public static void register() {

    }
    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);
    }
}
