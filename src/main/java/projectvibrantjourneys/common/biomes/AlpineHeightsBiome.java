package projectvibrantjourneys.common.biomes;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import projectvibrantjourneys.init.world.PVJConfiguredSurfaceBuilders;

public class AlpineHeightsBiome {

	public static Biome makeAlpineHeightsBiome(float depth, float scale) {
		MobSpawnSettings.Builder MobSpawnSettings = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(MobSpawnSettings);
		BiomeDefaultFeatures.farmAnimals(MobSpawnSettings);
		BiomeGenerationSettings.Builder biomeGenBuilder = (new BiomeGenerationSettings.Builder())
				.surfaceBuilder(PVJConfiguredSurfaceBuilders.ALPINE_HEIGHTS);

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomeGenBuilder);
		biomeGenBuilder.addStructureStart(StructureFeatures.RUINED_PORTAL_MOUNTAIN);
		
		BiomeDefaultFeatures.addDefaultCarvers(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultLakes(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenBuilder);
		BiomeDefaultFeatures.addMossyStoneBlock(biomeGenBuilder);
		BiomeDefaultFeatures.addFerns(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultOres(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultFlowers(biomeGenBuilder);
		BiomeDefaultFeatures.addGiantTaigaVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultMushrooms(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenBuilder);
		BiomeDefaultFeatures.addSparseBerryBushes(biomeGenBuilder);
		BiomeDefaultFeatures.addDefaultSprings(biomeGenBuilder);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenBuilder);
		
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).depth(depth)
				.scale(scale).temperature(-0.4F).downfall(0.3F)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011)
				.fogColor(12638463).skyColor(BiomeUtils.getSkyColorWithTemperatureModifier(2.0F))
				.foliageColorOverride(0x00994d).grassColorOverride(0x00994d).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
				.build())
				.mobSpawnSettings(MobSpawnSettings.build())
				.generationSettings(biomeGenBuilder.build()).build();
	}
}
