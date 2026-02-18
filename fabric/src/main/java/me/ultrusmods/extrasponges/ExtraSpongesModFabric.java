package me.ultrusmods.extrasponges;

import me.ultrusmods.extrasponges.register.BlockRegistry;
import me.ultrusmods.extrasponges.register.CreativeTabRegistry;
import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class ExtraSpongesModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ExtraSpongesMod.init();
        BlockRegistry.register();
        ItemRegistry.register();
        CreativeTabRegistry.register();
    }
}
