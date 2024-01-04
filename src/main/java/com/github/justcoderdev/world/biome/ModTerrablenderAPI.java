package com.github.justcoderdev.world.biome;

import com.github.justcoderdev.SpectralRainbowForest;
import com.github.justcoderdev.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(SpectralRainbowForest.MOD_ID, "overworld"), 1));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SpectralRainbowForest.MOD_ID, ModMaterialRules.makeRules());
    }
}
