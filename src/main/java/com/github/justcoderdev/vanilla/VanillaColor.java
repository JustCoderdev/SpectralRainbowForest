package com.github.justcoderdev.vanilla;

import com.github.justcoderdev.block.SpectrumBlocks;
import com.github.justcoderdev.world.ModConfiguredFeatures;
import com.github.justcoderdev.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class VanillaColor {
	public static VanillaColor[] ALL = {
			new VanillaColor("black"),
			new VanillaColor("dark_blue"),
			new VanillaColor("dark_green"),
			new VanillaColor("dark_aqua"),
			new VanillaColor("dark_red"),
			new VanillaColor("dark_purple"),
			new VanillaColor("gold"),
			new VanillaColor("gray"),
			new VanillaColor("dark_gray"),
			new VanillaColor("blue"),
			new VanillaColor("green"),
			new VanillaColor("aqua"),
			new VanillaColor("red"),
			new VanillaColor("light_purple"),
			new VanillaColor("yellow"),
			new VanillaColor("white")
	};

	private final String color_id;

	private VanillaColor(String color_id) {
		this.color_id = color_id;
	}

	public Block registerAsBlockLog() {
		return SpectrumBlocks.registerBlock(this.color_id + "_log", getBlockOakWood());
	}
	private static Block getBlockOakWood() {
		return new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
	}

	public Block registerAsBlockLeaves() {
		return SpectrumBlocks.registerBlock(this.color_id + "_leaves", getBlockOakLeaves());
	}
	private static Block getBlockOakLeaves() {
		return new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES));
	}

	public RegistryKey<ConfiguredFeature<?, ?>> registerAsConfiguredKey() {
		return ModConfiguredFeatures.registerKey("spectrum_" + this.color_id + "_tree");
	}

	public RegistryKey<PlacedFeature> registerAsPlacedKey() {
		return ModPlacedFeatures.registerKey("spectrum_" + this.color_id + "_tree_placed");
	}
}

