package com.github.justcoderdev.world;

import com.github.justcoderdev.SpectralRainbowForest;
import com.github.justcoderdev.block.SpectrumBlocks;
import com.github.justcoderdev.vanilla.VanillaColor;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Arrays;
import java.util.List;

public class ModConfiguredFeatures {
    public static final List<RegistryKey<ConfiguredFeature<?, ?>>> SPECTRUM_TREE_KEYS = Arrays.stream(VanillaColor.ALL)
            .map(VanillaColor::registerAsConfiguredKey).toList();

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        for (int i = 0; i < SPECTRUM_TREE_KEYS.size(); ++i) {
            final var TREE_KEY = SPECTRUM_TREE_KEYS.get(i);
            final var TREE_LOG = SpectrumBlocks.LOGS[i];
            final var TREE_LEAVES = SpectrumBlocks.LEAVES[i];

            register(context, TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(TREE_LOG),

                    //new ForkingTrunkPlacer(5, 4, 3),
                    new StraightTrunkPlacer(5, 4, 3),

                    //BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                    BlockStateProvider.of(TREE_LEAVES),
                    //new JungleFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 2),
                    new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 2),

                    new TwoLayersFeatureSize(1, 0, 2)
            ).build());
        }
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SpectralRainbowForest.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {

        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
