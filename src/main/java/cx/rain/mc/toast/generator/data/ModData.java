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

@EventBusSubscriber(modid = ToastGenerator.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModData {
    @SubscribeEvent
    public static void onData(GatherDataEvent event) {
        var registries = event.getLookupProvider();
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var exHelper = event.getExistingFileHelper();

        event.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(Component.literal("The data-pack for Catopia"), DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA))));
        event.addProvider(true, new ModAdvancementProvider(output, registries, exHelper));
        event.addProvider(true, new ModRecipeProvider.Runner(output, registries));
        var blockTags = event.addProvider(true, new ModBlockTagsProvider(output, registries, ToastGenerator.MODID, exHelper));
        event.addProvider(true, new ModItemTagsProvider(output, registries, blockTags.contentsGetter(), ToastGenerator.MODID, exHelper));
    }
}
