package cx.rain.mc.toast.generator.data;

import cx.rain.mc.toast.generator.data.tag.ModTags;
import cx.rain.mc.toast.generator.utility.Naming;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
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
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_helmet"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .group("chainmail_armors")
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_chestplate"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .group("chainmail_armors")
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_legging"));
        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .group("chainmail_armors")
                .pattern("I I")
                .pattern("I I")
                .define('I', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(output, Naming.modRecipe("chainmail_boots"));

        shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE, 2)
                .group("misc")
                .pattern("BEB")
                .pattern("BAB")
                .pattern("BBB")
                .define('B', Items.GOLD_BLOCK)
                .define('E', Items.ENCHANTED_GOLDEN_APPLE)
                .define('A', Items.GOLDEN_APPLE)
                .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                .unlockedBy(getHasName(Items.ENCHANTED_GOLDEN_APPLE), has(Items.ENCHANTED_GOLDEN_APPLE))
                .unlockedBy(getHasName(Items.GOLDEN_APPLE), has(Items.GOLDEN_APPLE))
                .save(output, Naming.modRecipe("enchanted_golden_apple"));

        shapeless(RecipeCategory.MISC, Items.GLOW_INK_SAC)
                .group("misc")
                .requires(Items.INK_SAC)
                .requires(ModTags.Items.GLOWING)
                .unlockedBy(getHasName(Items.INK_SAC), has(Items.INK_SAC))
                .unlockedBy("has_glowing", has(ModTags.Items.GLOWING))
                .save(output, Naming.modRecipe("glow_ink_sac"));

        oreProcessing(Items.RAW_IRON_BLOCK, Items.IRON_BLOCK, 6,1600);
        oreProcessing(Items.RAW_COPPER_BLOCK, Items.COPPER_BLOCK, 6,1600);
        oreProcessing(Items.RAW_GOLD_BLOCK, Items.GOLD_BLOCK, 6,1600);

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
            stoneCutting(Items.BAMBOO_BLOCK, Items.STRIPPED_BAMBOO_BLOCK, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.STRIPPED_BAMBOO_BLOCK, Items.BAMBOO_PLANKS, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_BLOCK, Items.BAMBOO_PLANKS, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.STRIPPED_BAMBOO_BLOCK, Items.BAMBOO_MOSAIC, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_BLOCK, Items.BAMBOO_MOSAIC, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_PLANKS, Items.BAMBOO_STAIRS, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_STAIRS, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
            stoneCutting(Items.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_SLAB, 2, RecipeCategory.BUILDING_BLOCKS, "bamboo_cutting");
        }

        stoneCutting(Items.GLASS, Items.GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.WHITE_STAINED_GLASS, Items.WHITE_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.ORANGE_STAINED_GLASS, Items.ORANGE_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.MAGENTA_STAINED_GLASS, Items.MAGENTA_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.YELLOW_STAINED_GLASS, Items.YELLOW_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.LIME_STAINED_GLASS, Items.LIME_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.PINK_STAINED_GLASS, Items.PINK_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.GRAY_STAINED_GLASS, Items.GRAY_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.CYAN_STAINED_GLASS, Items.CYAN_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.PURPLE_STAINED_GLASS, Items.PURPLE_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.BLUE_STAINED_GLASS, Items.BLUE_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.BROWN_STAINED_GLASS, Items.BROWN_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.GREEN_STAINED_GLASS, Items.GREEN_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.RED_STAINED_GLASS, Items.RED_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
        stoneCutting(Items.BLACK_STAINED_GLASS, Items.BLACK_STAINED_GLASS_PANE, 4, RecipeCategory.DECORATIONS, "glass_cutting");
    }
    
    private void woodCutter(ItemLike log, ItemLike wood, ItemLike strippedLog, ItemLike strippedWood,
                            ItemLike planks, ItemLike stairs, ItemLike slab) {
        stoneCutting(log, strippedLog, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(wood, strippedWood, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(log, planks, 4, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(wood, planks, 4, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(strippedLog, planks, 4, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(strippedWood, planks, 4, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(planks, stairs, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
        stoneCutting(planks, slab, 2, RecipeCategory.BUILDING_BLOCKS, "wood_cutting");
    }

    private void oreProcessing(ItemLike material, ItemLike result, float experience, int normalCookingTime) {
        smelting(material, result, experience, normalCookingTime, RecipeCategory.MISC, "raw_ore_block_smelting");
        blasting(material, result, experience, normalCookingTime / 2, RecipeCategory.MISC, "raw_ore_block_smelting");
    }

    private void stoneCutting(ItemLike material, ItemLike result, RecipeCategory category, String group) {
        stoneCutting(material, result, 1, category, group);
    }

    private void stoneCutting(ItemLike material, ItemLike result, int resultCount, RecipeCategory category, String group) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount)
                .unlockedBy(getHasName(material), this.has(material))
                .group(group)
                .save(output, Naming.modRecipe(getConversionRecipeName(result, material) + "_stonecutting"));
    }

    private void smelting(ItemLike material, ItemLike result, float experience, int cookingTime, RecipeCategory category, String group) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(material), category, result, experience, cookingTime, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new)
                .unlockedBy(getHasName(material), has(material))
                .group(group)
                .save(output, Naming.modRecipe(getSmeltingRecipeName(result) + "_" + getItemName(material)));
    }

    private void blasting(ItemLike material, ItemLike result, float experience, int cookingTime, RecipeCategory category, String group) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(material), category, result, experience, cookingTime, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new)
                .unlockedBy(getHasName(material), has(material))
                .group(group)
                .save(output, Naming.modRecipe(getBlastingRecipeName(result) + "_" + getItemName(material)));
    }
}
