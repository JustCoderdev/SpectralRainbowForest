package com.github.justcoderdev.block;

import com.github.justcoderdev.SpectralRainbowForest;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class SpectrumBlocks {
   public static final Block WHITE_LOG = registerBlock("white_log", new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block WHITE_LEAVES = registerBlock("white_leaves", new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));



    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, SpectralRainbowForest.getSpectrumIdentifier(name), block);
    }
}
