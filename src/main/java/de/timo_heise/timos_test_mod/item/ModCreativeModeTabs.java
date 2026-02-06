package de.timo_heise.timos_test_mod.item;

import de.timo_heise.timos_test_mod.TestMod;
import de.timo_heise.timos_test_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("uran_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.URAN_INGOT.get().getDefaultInstance())
            .title(Component.translatable("item_group." + TestMod.MODID + ".uran_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.URAN_INGOT.get());
                output.accept(ModItems.RAW_URAN.get());
                output.accept(ModBlocks.URAN_BLOCK.get());
                output.accept(ModBlocks.RAW_URAN_BLOCK.get());
                output.accept(ModBlocks.URAN_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_URAN_ORE.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
