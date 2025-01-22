package cx.rain.mc.toast.generator.data;

import cx.rain.mc.toast.generator.data.tag.ModTags;
import cx.rain.mc.toast.generator.utility.Naming;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;
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

        oreSmelting(List.of(Items.RAW_IRON_BLOCK), RecipeCategory.MISC, Items.IRON_BLOCK, 6,1600, "raw_block_smelting");
        oreBlasting(List.of(Items.RAW_IRON_BLOCK), RecipeCategory.MISC, Items.IRON_BLOCK, 6,800, "raw_block_smelting");
        oreSmelting(List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC, Items.COPPER_BLOCK, 6,1600, "raw_block_smelting");
        oreBlasting(List.of(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC, Items.COPPER_BLOCK, 6,800, "raw_block_smelting");
        oreSmelting(List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC, Items.GOLD_BLOCK, 6,1600, "raw_block_smelting");
        oreBlasting(List.of(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC, Items.GOLD_BLOCK, 6,800, "raw_block_smelting");

        woodCutter(Items.OAK_LOG, Items.OAK_WOOD, Items.STRIPPED_OAK_LOG, Items.STRIPPED_OAK_WOOD, Items.OAK_PLANKS, Items.OAK_STAIRS, Items.OAK_SLAB);
        woodCutter(Items.SPRUCE_LOG, Items.SPRUCE_WOOD, Items.STRIPPED_SPRUCE_LOG, Items.STRIPPED_SPRUCE_WOOD, Items.SPRUCE_PLANKS, Items.SPRUCE_STAIRS, Items.SPRUCE_SLAB);
        woodCutter(Items.BIRCH_LOG, Items.BIRCH_WOOD, Items.STRIPPED_BIRCH_LOG, Items.STRIPPED_BIRCH_WOOD, Items.BIRCH_PLANKS, Items.BIRCH_STAIRS, Items.BIRCH_SLAB);
        woodCutter(Items.JUNGLE_LOG, Items.JUNGLE_WOOD, Items.STRIPPED_JUNGLE_LOG, Items.STRIPPED_JUNGLE_WOOD, Items.JUNGLE_PLANKS, Items.JUNGLE_STAIRS, Items.JUNGLE_SLAB);
        woodCutter(Items.ACACIA_LOG, Items.ACACIA_WOOD, Items.STRIPPED_ACACIA_LOG, Items.STRIPPED_ACACIA_WOOD, Items.ACACIA_PLANKS, Items.ACACIA_STAIRS, Items.ACACIA_SLAB);
        woodCutter(Items.CHERRY_LOG, Items.CHERRY_WOOD, Items.STRIPPED_CHERRY_LOG, Items.STRIPPED_CHERRY_WOOD, Items.CHERRY_PLANKS, Items.CHERRY_STAIRS, Items.CHERRY_SLAB);
        woodCutter(Items.DARK_OAK_LOG, Items.DARK_OAK_WOOD, Items.STRIPPED_DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_WOOD, Items.DARK_OAK_PLANKS, Items.DARK_OAK_STAIRS, Items.DARK_OAK_SLAB);
        woodCutter(Items.PALE_OAK_LOG, Items.PALE_OAK_WOOD, Items.STRIPPED_PALE_OAK_LOG, Items.STRIPPED_PALE_OAK_WOOD, Items.PALE_OAK_PLANKS, Items.PALE_OAK_STAIRS, Items.PALE_OAK_SLAB);
        woodCutter(Items.MANGROVE_LOG, Items.MANGROVE_WOOD, Items.STRIPPED_MANGROVE_LOG, Items.STRIPPED_MANGROVE_WOOD, Items.MANGROVE_PLANKS, Items.MANGROVE_STAIRS, Items.MANGROVE_SLAB);
        woodCutter(Items.CRIMSON_STEM, Items.CRIMSON_HYPHAE, Items.STRIPPED_CRIMSON_STEM, Items.STRIPPED_CRIMSON_HYPHAE, Items.CRIMSON_PLANKS, Items.CRIMSON_STAIRS, Items.CRIMSON_SLAB);
        woodCutter(Items.WARPED_STEM, Items.WARPED_HYPHAE, Items.STRIPPED_WARPED_STEM, Items.STRIPPED_WARPED_HYPHAE, Items.WARPED_PLANKS, Items.WARPED_STAIRS, Items.WARPED_SLAB);

        {
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.STRIPPED_BAMBOO_BLOCK, Items.BAMBOO_BLOCK);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PLANKS, Items.STRIPPED_BAMBOO_BLOCK, 2);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PLANKS, Items.BAMBOO_BLOCK, 2);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC, Items.STRIPPED_BAMBOO_BLOCK, 2);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC, Items.BAMBOO_BLOCK, 2);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC, Items.BAMBOO_PLANKS);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_STAIRS, Items.BAMBOO_PLANKS);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB, Items.BAMBOO_PLANKS, 2);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_STAIRS, Items.BAMBOO_MOSAIC);
            stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC_SLAB, Items.BAMBOO_MOSAIC, 2);
        }

        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.WHITE_STAINED_GLASS_PANE, Items.WHITE_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.ORANGE_STAINED_GLASS_PANE, Items.ORANGE_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.MAGENTA_STAINED_GLASS_PANE, Items.MAGENTA_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.LIGHT_BLUE_STAINED_GLASS_PANE, Items.LIGHT_BLUE_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.YELLOW_STAINED_GLASS_PANE, Items.YELLOW_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.LIME_STAINED_GLASS_PANE, Items.LIME_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.PINK_STAINED_GLASS_PANE, Items.PINK_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.GRAY_STAINED_GLASS_PANE, Items.GRAY_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.LIGHT_GRAY_STAINED_GLASS_PANE, Items.LIGHT_GRAY_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.CYAN_STAINED_GLASS_PANE, Items.CYAN_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.PURPLE_STAINED_GLASS_PANE, Items.PURPLE_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.BLUE_STAINED_GLASS_PANE, Items.BLUE_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.BROWN_STAINED_GLASS_PANE, Items.BROWN_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.GREEN_STAINED_GLASS_PANE, Items.GREEN_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.RED_STAINED_GLASS_PANE, Items.RED_STAINED_GLASS, 4);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, Items.BLACK_STAINED_GLASS_PANE, Items.BLACK_STAINED_GLASS, 4);

    }
    
    private void woodCutter(ItemLike log, ItemLike wood, ItemLike strippedLog, ItemLike strippedWood,
                            ItemLike planks, ItemLike stairs, ItemLike slab) {
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, strippedLog, log);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, strippedWood, wood);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, planks, log, 4);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, planks, wood, 4);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, planks, strippedLog, 4);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, planks, strippedWood, 4);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stairs, planks);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, planks, 2);
    }
}
