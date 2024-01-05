package com.github.justcoderdev.block;

import com.github.justcoderdev.SpectralRainbowForest;
import com.github.justcoderdev.vanilla.VanillaColor;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.Arrays;

public class SpectrumBlocks {
    public static final Block[] LOGS = Arrays.stream(VanillaColor.ALL)
            .map(VanillaColor::registerAsBlockLog).toArray(Block[]::new);

    public static final Block[] LEAVES = Arrays.stream(VanillaColor.ALL)
            .map(VanillaColor::registerAsBlockLeaves).toArray(Block[]::new);

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, SpectralRainbowForest.getSpectrumIdentifier(name), block);
    }
}
