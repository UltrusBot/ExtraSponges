package me.ultrusmods.extrasponges;


import me.ultrusmods.extrasponges.register.BlockRegistry;
import me.ultrusmods.extrasponges.register.CreativeTabRegistry;
import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class ExtraSpongesModNeoForge {

    public ExtraSpongesModNeoForge(IEventBus eventBus) {
        ExtraSpongesMod.init();
        eventBus.addListener(this::registerEvent);

    }

    public void registerEvent(RegisterEvent event) {
        event.register(Registries.BLOCK, blockRegisterHelper -> BlockRegistry.register());
        event.register(Registries.ITEM, itemRegisterHelper -> ItemRegistry.register());
        event.register(Registries.CREATIVE_MODE_TAB, creativeModeTabRegisterHelper -> CreativeTabRegistry.register());
    }
}