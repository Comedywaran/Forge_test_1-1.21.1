package de.timo_heise.timos_test_mod.item;

import de.timo_heise.timos_test_mod.TestMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> URAN_INGOT = ITEMS.register("uran_ingot", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
    .nutrition(2048)
    .saturationModifier(4096f)
    .build())));

    public static final RegistryObject<Item> RAW_URAN = ITEMS.register("raw_uran", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
