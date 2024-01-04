package com.github.justcoderdev.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
	public ModOverworldRegion(Identifier name, int weight) {
		super(name, RegionType.OVERWORLD, weight);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
		VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
		// Overlap Vanilla's parameters with our own for our COLD_BLUE biome.
		// The parameters for this biome are chosen arbitrarily.
		new ParameterPointListBuilder()
				.temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
				.humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
				.continentalness(Continentalness.NEAR_INLAND)
				.erosion(Erosion.EROSION_0, Erosion.EROSION_1)
				.depth(Depth.SURFACE, Depth.FLOOR)
				.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
				.build().forEach(point -> builder.add(point, ModBiomes.RAINBOW_FOREST_BIOME));

		// Add our points to the mapper
		builder.build().forEach(mapper);

//		this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
//			modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FOREST, ModBiomes.RAINBOW_FOREST_BIOME);
//		});
	}
}
