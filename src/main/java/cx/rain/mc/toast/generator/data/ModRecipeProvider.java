package cx.rain.mc.toast.generator.data;

import cx.rain.mc.toast.generator.data.tag.ModTags;
import cx.rain.mc.toast.generator.utility.Naming;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider registries,
                                                               @NotNull RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public @NotNull String getName() {
            return "packRecipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .group("chainmail_armors")
                .pattern("III")
                .pattern("I I")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("iron_nugget", has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_helmet"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .group("chainmail_armors")
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("iron_nugget", has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_chestplate"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .group("chainmail_armors")
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("iron_nugget", has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_legging"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .group("chainmail_armors")
                .pattern("I I")
                .pattern("I I")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("iron_nugget", has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_boots"));

        shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE, 2)
                .group("misc")
                .pattern("BEB")
                .pattern("BAB")
                .pattern("BBB")
                .define('B', Items.GOLD_BLOCK)
                .define('E', Items.ENCHANTED_GOLDEN_APPLE)
                .define('A', Items.GOLDEN_APPLE)
                .unlockedBy("gold_block", has(Items.GOLD_BLOCK))
                .unlockedBy("enchanted_golden_apple", has(Items.ENCHANTED_GOLDEN_APPLE))
                .unlockedBy("golden_apple", has(Items.GOLDEN_APPLE))
                .save(output, Naming.modRecipe("enchanted_golden_apple"));

        shapeless(RecipeCategory.MISC, Items.GLOW_INK_SAC)
                .group("misc")
                .requires(Items.INK_SAC)
                .requires(ModTags.Items.GLOWING)
                .unlockedBy("ink", has(Items.INK_SAC))
                .unlockedBy("glowing", has(ModTags.Items.GLOWING))
                .save(output, Naming.modRecipe("glow_ink_sac"));
    }
}
