package com.github.justcoderdev;

import com.github.justcoderdev.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpectralRainbowForest implements ModInitializer {
	public static final String SPECTRUM_ID = "spectrum";
	public static final String MOD_ID = "spectral_rainbow_forest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Modded Minecraft world!");

		//ModWorldGeneration.generateModWorldGen();
	}

	public static Identifier getSpectrumIdentifier(String name) {
		return Identifier.of(SpectralRainbowForest.SPECTRUM_ID, name);
	}
}