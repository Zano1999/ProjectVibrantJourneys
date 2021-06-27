package projectvibrantjourneys.init.world;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Features.Placements;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import projectvibrantjourneys.common.world.features.blockplacers.GroundcoverPlacer;
import projectvibrantjourneys.common.world.features.blockplacers.RocksBlockPlacer;
import projectvibrantjourneys.common.world.features.blockstateproviders.ShortGrassBlockStateProvider;
import projectvibrantjourneys.common.world.features.foliageplacers.BaobabFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.PVJPineFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.PalmFoliagePlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.BaobabTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.MangroveTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.PalmTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.RedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.SmallRedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.WillowTrunkPlacer;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.object.PVJBlocks;

public class PVJConfiguredFeatures {
	public static final GroundcoverPlacer GROUNDCOVER_PLACER = new GroundcoverPlacer();
	public static BlockClusterFeatureConfig twigsCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.twigs.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig fallenLeavesCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.fallen_leaves.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig rocksCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.rocks.defaultBlockState()), new RocksBlockPlacer(), 5);
	public static BlockClusterFeatureConfig iceChunksCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.ice_chunks.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig bonesCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.bones.defaultBlockState()), GROUNDCOVER_PLACER, 1);
	public static BlockClusterFeatureConfig charredBonesCluster = new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.charred_bones.defaultBlockState()), new GroundcoverPlacer())
					.tries(64).noProjection().build();
	public static BlockClusterFeatureConfig pineconesCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.pinecones.defaultBlockState()), GROUNDCOVER_PLACER, 4);
	public static BlockClusterFeatureConfig seashellsCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.seashells.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static BlockClusterFeatureConfig seaOatsCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.sea_oats.defaultBlockState()), DoublePlantBlockPlacer.INSTANCE, 15);
	public static BlockClusterFeatureConfig cattailCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.cattail.defaultBlockState()), DoublePlantBlockPlacer.INSTANCE, 15);
	public static BlockClusterFeatureConfig glowcapCluster = new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PVJBlocks.glowcap.defaultBlockState()), SimpleBlockPlacer.INSTANCE).tries(64)
					.noProjection().build();
	public static BlockStateProvidingFeatureConfig crimsonNettleConfig = new BlockStateProvidingFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.crimson_nettle.defaultBlockState()));
	public static BlockStateProvidingFeatureConfig warpedNettleConfig = new BlockStateProvidingFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.warped_nettle.defaultBlockState()));
	public static BlockClusterFeatureConfig shortGrassCluster = (new BlockClusterFeatureConfig.Builder(
			new ShortGrassBlockStateProvider(), SimpleBlockPlacer.INSTANCE)).tries(16).build();
	public static BlockClusterFeatureConfig beachGrassCluster = makeFeatureConfig(
			new SimpleBlockStateProvider(PVJBlocks.beach_grass.defaultBlockState()), SimpleBlockPlacer.INSTANCE, 15);

	public static ConfiguredFeature<?, ?> sea_oats;
	public static ConfiguredFeature<?, ?> cattails;
	public static ConfiguredFeature<?, ?> water_cattails;
	public static ConfiguredFeature<?, ?> twigs;
	public static ConfiguredFeature<?, ?> fallen_leaves;
	public static ConfiguredFeature<?, ?> rocks;
	public static ConfiguredFeature<?, ?> ice_chunks;
	public static ConfiguredFeature<?, ?> bones;
	public static ConfiguredFeature<?, ?> charred_bones;
	public static ConfiguredFeature<?, ?> pinecones;
	public static ConfiguredFeature<?, ?> seashells;
	public static ConfiguredFeature<?, ?> ocean_seashells;
	public static ConfiguredFeature<?, ?> bushes;
	public static ConfiguredFeature<?, ?> bark_mushrooms;
	public static ConfiguredFeature<?, ?> cobwebs;
	public static ConfiguredFeature<?, ?> glowcap;
	public static ConfiguredFeature<?, ?> crimson_nettle;
	public static ConfiguredFeature<?, ?> warped_nettle;
	public static ConfiguredFeature<?, ?> short_grass;
	public static ConfiguredFeature<?, ?> beach_grass;
	public static ConfiguredFeature<?, ?> fallen_tree;
	
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> mega_redwood_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> redwood_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> fir_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> pine_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> willow_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> mangrove_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> palm_tree;
	public static ConfiguredFeature<BaseTreeFeatureConfig, ?> baobab_tree;

	public static ConfiguredFeature<?, ?> overgrown_spires_vegetation;
	public static ConfiguredFeature<?, ?> redwood_forest_vegetation;
	public static ConfiguredFeature<?, ?> boreal_forest_vegetation;
	public static ConfiguredFeature<?, ?> pine_meadows_vegetation;

	public static void init() {
		sea_oats = Feature.RANDOM_PATCH.configured(seaOatsCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2);
		cattails = Feature.RANDOM_PATCH.configured(cattailCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5).chance(2);
		water_cattails = PVJFeatures.waterCattailFeature.configured(IFeatureConfig.NONE).squared().count(30).chance(3);

		twigs = Feature.RANDOM_PATCH.configured(twigsCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(3).chance(2);
		fallen_leaves = Feature.RANDOM_PATCH.configured(fallenLeavesCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(4).chance(2);
		rocks = Feature.RANDOM_PATCH.configured(rocksCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(3).chance(2);
		ice_chunks = Feature.RANDOM_PATCH.configured(iceChunksCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2).chance(2);
		bones = Feature.RANDOM_PATCH.configured(bonesCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(1).chance(2);
		charred_bones = Feature.RANDOM_PATCH.configured(charredBonesCluster).range(128).chance(2);
		pinecones = Feature.RANDOM_PATCH.configured(pineconesCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2).chance(2);
		seashells = Feature.RANDOM_PATCH.configured(seashellsCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(3).chance(2);
		ocean_seashells = PVJFeatures.oceanFloorSeashellsFeature.configured(IFeatureConfig.NONE).decorated(Placements.TOP_SOLID_HEIGHTMAP_SQUARE).count(10).chance(2);

		bushes = PVJFeatures.bushFeature.configured(new ProbabilityConfig(0.3F)).decorated(Features.Placements.HEIGHTMAP_WORLD_SURFACE);
		bark_mushrooms = PVJFeatures.barkMushroomFeature.configured(IFeatureConfig.NONE).squared().count(30);
		cobwebs = PVJFeatures.cobwebFeature.configured(new ProbabilityConfig(0.1F)).squared().count(30).chance(25);
		glowcap = Feature.RANDOM_PATCH.configured(glowcapCluster).range(128).chance(2);
		crimson_nettle = Feature.NETHER_FOREST_VEGETATION.configured(crimsonNettleConfig).chance(40).decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(4)));
		warped_nettle = Feature.NETHER_FOREST_VEGETATION.configured(warpedNettleConfig).chance(40).decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(4)));
		short_grass =  Feature.RANDOM_PATCH.configured(shortGrassCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5);
		beach_grass = Feature.RANDOM_PATCH.configured(beachGrassCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2);
		
		overgrown_spires_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(ImmutableList.of(Features.FANCY_OAK.weighted(0.1F),
						Features.JUNGLE_BUSH.weighted(0.5F), Features.MEGA_JUNGLE_TREE.weighted(0.33333334F)),
						Features.JUNGLE_TREE))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(15, 0.4F, 1)));

		fallen_tree = PVJFeatures.fallenTreeFeature.configured(NoFeatureConfig.NONE).decorated(Placements.TOP_SOLID_HEIGHTMAP);
		
		mega_redwood_tree = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(PVJBlocks.redwood_log.defaultBlockState()),
				new SimpleBlockStateProvider(PVJBlocks.redwood_leaves.defaultBlockState()),
				new MegaPineFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0),
						FeatureSpread.of(25, 7)),
				new RedwoodTrunkPlacer(40, 30, 14), new TwoLayerFeature(1, 1, 2))).build());

		redwood_tree = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(PVJBlocks.redwood_log.defaultBlockState()),
						new SimpleBlockStateProvider(PVJBlocks.redwood_leaves.defaultBlockState()),
						new PineFoliagePlacer(FeatureSpread.fixed(1), FeatureSpread.fixed(1),
								FeatureSpread.of(3, 1)),
						new SmallRedwoodTrunkPlacer(7, 5, 0), new TwoLayerFeature(2, 0, 2))).ignoreVines()
								.build());
		
		fir_tree = PVJFeatures.snowTree.configured(
				(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PVJBlocks.fir_log.defaultBlockState()),
						new SimpleBlockStateProvider(PVJBlocks.fir_leaves.defaultBlockState()),
						new SpruceFoliagePlacer(FeatureSpread.of(3, 1), FeatureSpread.of(1, 1),
								FeatureSpread.of(4, 2)),
						new StraightTrunkPlacer(15, 3, 4), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());

		pine_tree = Feature.TREE.configured(
				(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PVJBlocks.pine_log.defaultBlockState()),
						new SimpleBlockStateProvider(PVJBlocks.pine_leaves.defaultBlockState()),
						new PVJPineFoliagePlacer(FeatureSpread.of(3, 1), FeatureSpread.of(1, 1),
								FeatureSpread.of(3, 2)),
						new StraightTrunkPlacer(9, 2, 2), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());
		
		willow_tree = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState()),
						new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
						new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0),
								3),
						new WillowTrunkPlacer(6, 3, 3), new TwoLayerFeature(1, 0, 1))).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.INSTANCE)).build());
		
		mangrove_tree = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState()),
						new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
						new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0),
								3),
						new MangroveTrunkPlacer(4, 2, 2), new TwoLayerFeature(1, 0, 1))).maxWaterDepth(5).build());

		palm_tree = Feature.TREE.configured(
				(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState()),
						new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
						new PalmFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
						new PalmTrunkPlacer(7, 2, 2), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());
		
		baobab_tree = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(Blocks.OAK_LOG.defaultBlockState()),
				new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()),
				new BaobabFoliagePlacer(FeatureSpread.fixed(0), FeatureSpread.fixed(0)),
				new BaobabTrunkPlacer(20, 5, 2), new TwoLayerFeature(1, 1, 2))).build());
		
		redwood_forest_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(mega_redwood_tree.weighted(0.75F), redwood_tree.weighted(0.25F)), mega_redwood_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(4, 0.3F, 1)));

		boreal_forest_vegetation = Feature.RANDOM_SELECTOR
						.configured(new MultipleRandomFeatureConfig(
								ImmutableList.of(fir_tree.weighted(0.75F), pine_tree.weighted(0.25F)), fir_tree))
						.decorated(Features.Placements.HEIGHTMAP_SQUARE)
						.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.3F, 1)));
		
		pine_meadows_vegetation = Feature.RANDOM_SELECTOR
						.configured(new MultipleRandomFeatureConfig(
								ImmutableList.of(baobab_tree.weighted(0.75F)), pine_tree))
						.decorated(Features.Placements.HEIGHTMAP_SQUARE)
						.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.5F, 2)));
		
		register("sea_oats", sea_oats);
		register("cattails", cattails);
		register("water_cattails", water_cattails);
		register("twigs", twigs);
		register("fallen_leaves", fallen_leaves);
		register("rocks", rocks);
		register("ice_chunks", ice_chunks);
		register("bones", bones);
		register("charred_bones", charred_bones);
		register("pinecones", pinecones);
		register("seashells", seashells);
		register("ocean_seashells", ocean_seashells);
		register("bushes", bushes);
		register("bark_mushrooms", bark_mushrooms);
		register("cobwebs", cobwebs);
		register("glowcap", glowcap);
		register("crimson_nettle", crimson_nettle);
		register("warped_nettle", warped_nettle);
		register("short_grass", short_grass);
		register("beach_grass", beach_grass);
		register("fallen_tree", fallen_tree);
		register("mega_redwood_tree", mega_redwood_tree);
		register("redwood", redwood_tree);
		register("fir", fir_tree);
		register("pine", pine_tree);
		register("willow", willow_tree);
		register("mangrove", mangrove_tree);
		register("palm", palm_tree);
		register("baobab", baobab_tree);
		
		register("overgrown_spires_vegetation", overgrown_spires_vegetation);
		register("redwood_forest_vegetation", redwood_forest_vegetation);
		register("boreal_forest_vegetation", boreal_forest_vegetation);
		register("pine_meadows_vegetation", pine_meadows_vegetation);
	}

	private static BlockClusterFeatureConfig makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer, int tries) {
		return new BlockClusterFeatureConfig.Builder(provider, placer).tries(tries).build();
	}

	private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key), configuredFeature);
	}
}
