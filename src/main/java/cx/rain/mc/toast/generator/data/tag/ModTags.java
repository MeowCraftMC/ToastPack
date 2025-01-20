package cx.rain.mc.toast.generator.data.tag;

import cx.rain.mc.toast.generator.utility.Naming;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> GLOWING = TagKey.create(Registries.ITEM, Naming.modLoc("glowing"));
    }
}
