package cx.rain.mc.toast.generator.utility;

import cx.rain.mc.toast.generator.ToastGenerator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

public class Naming {
    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(ToastGenerator.MODID, path);
    }

    public static ResourceLocation mcLoc(String path) {
        return ResourceLocation.withDefaultNamespace(path);
    }

    public static String itemName(ItemLike item) {
        return itemId(item).getPath().replace('/', '_');
    }

    public static ResourceLocation itemId(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    public static ResourceKey<Recipe<?>> modRecipe(String path) {
        return ResourceKey.create(Registries.RECIPE, modLoc(path));
    }
}
