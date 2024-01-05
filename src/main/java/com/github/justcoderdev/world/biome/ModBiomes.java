package com.github.justcoderdev.world.biome;

import com.github.justcoderdev.SpectralRainbowForest;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.github.justcoderdev.world.ModPlacedFeatures.SPECTRUM_TREE_PLACED_KEYS;

public class ModBiomes {
    public static final RegistryKey<Biome> RAINBOW_FOREST_BIOME = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(SpectralRainbowForest.MOD_ID, "rainbow_forest_biome"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(RAINBOW_FOREST_BIOME, rainbowForestBiome(context));
    }


    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome rainbowForestBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        //spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.PORCUPINE, 2, 3, 5));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        ////DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        ////DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        ////biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

        for (var TREE_PLACED_KEY: SPECTRUM_TREE_PLACED_KEYS) {
            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TREE_PLACED_KEY);
        }

        DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        ////DefaultBiomeFeatures.addLargeFerns(biomeBuilder);

        DefaultBiomeFeatures.addDefaultFlowers(biomeBuilder);
        DefaultBiomeFeatures.addForestGrass(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
            .precipitation(true)
            .downfall(0.8f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects((new BiomeEffects.Builder())
                .waterColor(4159204)
                .waterFogColor(329011)
                .skyColor(7972607)

                .grassColor(0x7f03fc)
                //.foliageColor(0xd203fc)
                .fogColor(12638463)
                .moodSound(BiomeMoodSound.CAVE)
                //.music(MusicType.GAME)
                //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.BAR_BRAWL)))
                .build()
            ).build();
    }

}
