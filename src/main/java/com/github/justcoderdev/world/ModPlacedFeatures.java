package com.github.justcoderdev.world;

import com.github.justcoderdev.SpectralRainbowForest;
import com.github.justcoderdev.vanilla.VanillaColor;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.Arrays;
import java.util.List;

import static com.github.justcoderdev.world.ModConfiguredFeatures.SPECTRUM_TREE_KEYS;

public class ModPlacedFeatures {
    public static final List<RegistryKey<PlacedFeature>> SPECTRUM_TREE_PLACED_KEYS = Arrays.stream(VanillaColor.ALL)
            .map(VanillaColor::registerAsPlacedKey).toList();

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        for (int i = 0; i < SPECTRUM_TREE_PLACED_KEYS.size(); ++i) {
            final var TREE_PLACED_KEY = SPECTRUM_TREE_PLACED_KEYS.get(i);
            final var TREE_KEY = SPECTRUM_TREE_KEYS.get(i);

            register(context, TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TREE_KEY),
                    VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.2f, 1), Blocks.OAK_SAPLING));
        }
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SpectralRainbowForest.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {

        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
