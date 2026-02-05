package de.timo_heise.timos_test_mod;

import com.mojang.logging.LogUtils;

import de.timo_heise.timos_test_mod.block.ModBlocks;
import de.timo_heise.timos_test_mod.item.ModCreativeModeTabs;
import de.timo_heise.timos_test_mod.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.MODID)
public class TestMod
{
    public static final String MODID = "timos_test_mod"; // Define mod id in a common place for everything to reference
    private static final Logger LOGGER = LogUtils.getLogger(); // Directly reference a slf4j logger

    public TestMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Registers
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this); // Register ourselves for server and other game events we are interested in

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC); // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    // @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    // public static class ClientModEvents
    // {
    //     @SubscribeEvent
    //     public static void onClientSetup(FMLClientSetupEvent event)
    //     {
    //         LOGGER.info("HELLO FROM CLIENT SETUP");
    //         LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    //     }
    // }
}
