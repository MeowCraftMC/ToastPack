package cx.rain.mc.toast.generator.data.advancement;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static cx.rain.mc.toast.generator.utility.Naming.*;
import static net.minecraft.advancements.Advancement.Builder.advancement;
import static net.minecraft.network.chat.Component.literal;

public class MemeAdvancements implements AdvancementSubProvider {

    @Override
    public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver) {
        var entityHolderGetter = registries.lookupOrThrow(Registries.ENTITY_TYPE);
        var itemHolderGetter = registries.lookupOrThrow(Registries.ITEM);

        var tree = new AdvancementTree(saver, modLoc("meme/root"), advancement()
                .display(Items.DIRT_PATH,
                        literal("模因污染"),
                        literal("这一切的一切还要从一只狼说起……"),
                        mcLoc("textures/block/dirt_path_top.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick()));


        tree.branch(modLoc("meme/duplicated_enhanced_golden_apple"), advancement()
                .display(Items.ENCHANTED_GOLDEN_APPLE,
                        literal("一生二，二生三……"),
                        literal("以附魔金苹果合成附魔金苹果"),
                        null, AdvancementType.GOAL, false, true, false)
                .addCriterion("crafted", RecipeCraftedTrigger.TriggerInstance.craftedItem(modRecipe("enchanted_golden_apple"))));

        tree.child(modLoc("meme/automatically_craft_enhanced_golden_apple"), advancement()
                .display(Items.ENCHANTED_GOLDEN_APPLE,
                        literal("三，生万物！"),
                        literal("用合成器以附魔金苹果合成附魔金苹果"),
                        null, AdvancementType.GOAL, false, true, false)
                .addCriterion("crafted", RecipeCraftedTrigger.TriggerInstance.crafterCraftedItem(modRecipe("enchanted_golden_apple"))));

        tree.endBranch();


        tree.child(modLoc("meme/potato_server_provider"), advancement()
                .display(Items.POTATO,
                        literal("服务器提供商"),
                        literal("土豆种植业是服务器发展的基础"),
                        null, AdvancementType.TASK, false, true, false)
                .addCriterion("potato", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.POTATOES)));

        tree.child(modLoc("meme/is_that_a_cat"), advancement()
                .display(Items.CAT_SPAWN_EGG,
                        literal("那是猫吗？"),
                        literal("透过望远镜观察一名猫托邦玩家"),
                        null, AdvancementType.TASK, false, true, false)
                .addCriterion("spyglass", lookEntityViaItem(
                        EntityPredicate.Builder.entity().of(entityHolderGetter, EntityType.PLAYER),
                        ItemPredicate.Builder.item().of(itemHolderGetter, Items.SPYGLASS))));

    }

    private static Criterion<UsingItemTrigger.TriggerInstance> lookEntityViaItem(EntityPredicate.Builder entity, ItemPredicate.Builder item) {
        return UsingItemTrigger.TriggerInstance.lookingAt(
                EntityPredicate.Builder.entity()
                        .subPredicate(PlayerPredicate.Builder.player()
                                .setLookingAt(entity)
                                .build()), item);
    }
}
