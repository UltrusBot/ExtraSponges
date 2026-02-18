package me.ultrusmods.extrasponges.register;

import me.ultrusmods.extrasponges.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ItemRegistry {
    public static Item IRON_SPONGE =  register("iron_sponge",BlockRegistry.IRON_SPONGE);
    public static Item GOLD_SPONGE =  register("gold_sponge",BlockRegistry.GOLD_SPONGE);
    public static Item DIAMOND_SPONGE =  register("diamond_sponge",BlockRegistry.DIAMOND_SPONGE);
    public static Item NETHERITE_SPONGE =  register("netherite_sponge",BlockRegistry.NETHERITE_SPONGE);
    public static Item WET_IRON_SPONGE =  register("wet_iron_sponge",BlockRegistry.WET_IRON_SPONGE);
    public static Item WET_GOLD_SPONGE =  register("wet_gold_sponge",BlockRegistry.WET_GOLD_SPONGE);
    public static Item WET_DIAMOND_SPONGE =  register("wet_diamond_sponge",BlockRegistry.WET_DIAMOND_SPONGE);
    public static Item WET_NETHERITE_SPONGE =  register("wet_netherite_sponge",BlockRegistry.WET_NETHERITE_SPONGE);
    public static Item LAVA_SPONGE =  register("lava_sponge",BlockRegistry.LAVA_SPONGE);
    public static Item WET_LAVA_SPONGE =  register("wet_lava_sponge",BlockRegistry.WET_LAVA_SPONGE);

    public static void register() {
    }


    private static Item register(String id, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(id), new BlockItem(block, new Item.Properties()
                .setId(Constants.key(Registries.ITEM, id))
        ));
    }
}
