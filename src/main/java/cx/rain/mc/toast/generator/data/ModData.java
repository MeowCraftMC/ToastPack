package cx.rain.mc.toast.generator.data;

import cx.rain.mc.toast.generator.ToastGenerator;
import cx.rain.mc.toast.generator.data.advancement.ModAdvancementProvider;
import cx.rain.mc.toast.generator.data.tag.ModBlockTagsProvider;
import cx.rain.mc.toast.generator.data.tag.ModItemTagsProvider;
import net.minecraft.DetectedVersion;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ToastGenerator.MODID)
public class ModData {
    @SubscribeEvent
    public static void onData(GatherDataEvent.Server event) {
        var registries = event.getLookupProvider();
        var generator = event.getGenerator();
        var output = generator.getPackOutput();

        event.addProvider(new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(Component.literal("The data-pack for Catopia"), DetectedVersion.BUILT_IN.packVersion(PackType.SERVER_DATA))));
        event.addProvider(new ModAdvancementProvider(output, registries));
        event.addProvider(new ModRecipeProvider.Runner(output, registries));
        event.addProvider(new ModBlockTagsProvider(output, registries, ToastGenerator.MODID));
        event.addProvider(new ModItemTagsProvider(output, registries, ToastGenerator.MODID));
    }
}
