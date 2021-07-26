package projectvibrantjourneys.init.world;

import java.util.OptionalInt;

import com.google.common.collect.ImmutableList;

import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Features.Placements;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.IntProviderConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.DoublePlantPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import projectvibrantjourneys.common.blocks.DryGrassBlock;
import projectvibrantjourneys.common.world.features.blockplacers.GroundcoverPlacer;
import projectvibrantjourneys.common.world.features.blockplacers.RocksBlockPlacer;
import projectvibrantjourneys.common.world.features.blockstateproviders.ShortGrassBlockStateProvider;
import projectvibrantjourneys.common.world.features.foliageplacers.AspenFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.BaobabFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.DesertJuniperFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.PVJPineFoliagePlacer;
import projectvibrantjourneys.common.world.features.foliageplacers.PalmFoliagePlacer;
import projectvibrantjourneys.common.world.features.treedecorators.CoconutDecorator;
import projectvibrantjourneys.common.world.features.treedecorators.JuniperBerriesDecorator;
import projectvibrantjourneys.common.world.features.trunkplacers.AspenTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.BaobabTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.DesertJuniperTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.MangroveTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.PalmTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.RedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.SmallRedwoodTrunkPlacer;
import projectvibrantjourneys.common.world.features.trunkplacers.WillowTrunkPlacer;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.object.PVJBlocks;

public class PVJConfiguredFeatures {
	public static final GroundcoverPlacer GROUNDCOVER_PLACER = new GroundcoverPlacer();
	public static RandomPatchConfiguration.GrassConfigurationBuilder twigsCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.twigs.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder fallenLeavesCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.fallen_leaves.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder rocksCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.rocks.defaultBlockState()), new RocksBlockPlacer(), 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder iceChunksCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.ice_chunks.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder bonesCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.bones.defaultBlockState()), GROUNDCOVER_PLACER, 1);
	public static RandomPatchConfiguration charredBonesCluster = new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(PVJBlocks.charred_bones.defaultBlockState()), new GroundcoverPlacer()).tries(64).noProjection().build();
	public static RandomPatchConfiguration.GrassConfigurationBuilder pineconesCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.pinecones.defaultBlockState()), GROUNDCOVER_PLACER, 4);
	public static RandomPatchConfiguration.GrassConfigurationBuilder seashellsCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.seashells.defaultBlockState()), GROUNDCOVER_PLACER, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder seaOatsCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.sea_oats.defaultBlockState()), DoublePlantPlacer.INSTANCE, 15);
	public static RandomPatchConfiguration.GrassConfigurationBuilder cattailCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.cattail.defaultBlockState()), DoublePlantPlacer.INSTANCE, 15);
	public static RandomPatchConfiguration glowcapCluster = new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(PVJBlocks.glowcap.defaultBlockState()), SimpleBlockPlacer.INSTANCE).tries(64).noProjection().build();
	public static BlockStateProvidingFeatureConfig crimsonNettleConfig = new BlockStateProvidingFeatureConfig(new SimpleStateProvider(PVJBlocks.crimson_nettle.defaultBlockState()));
	public static BlockStateProvidingFeatureConfig warpedNettleConfig = new BlockStateProvidingFeatureConfig(new SimpleStateProvider(PVJBlocks.warped_nettle.defaultBlockState()));
	public static RandomPatchConfiguration cindercaneConfig = new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(PVJBlocks.cindercane.defaultBlockState()), new ColumnBlockPlacer(2, 4)).tries(20).noProjection().build();
	
	public static RandomPatchConfiguration.GrassConfigurationBuilder autumnFoliageCluster = makeFeatureConfig(new WeightedStateProvider(SimpleWeightedRandomList.builder()
																						.add(PVJBlocks.aspen_fallen_leaves.defaultBlockState(), 1)
																						.add(PVJBlocks.orange_maple_fallen_leaves.defaultBlockState(), 1)
																						.add(PVJBlocks.red_maple_fallen_leaves.defaultBlockState(), 1)
																						.add(PVJBlocks.purple_maple_fallen_leaves.defaultBlockState(), 1).build()), SimpleBlockPlacer.INSTANCE, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder sakuraFoliageCluster = makeFeatureConfig(new WeightedStateProvider()
																						.add(PVJBlocks.pink_sakura_fallen_leaves.defaultBlockState(), 1)
																						.add(PVJBlocks.white_sakura_fallen_leaves.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE, 5);
	public static RandomPatchConfiguration.GrassConfigurationBuilder crimsonFoliageCluster = makeFeatureConfig(new WeightedStateProvider()
																						.add(PVJBlocks.red_maple_fallen_leaves.defaultBlockState(), 1)
																						.add(PVJBlocks.purple_maple_fallen_leaves.defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE, 5);
	
	public static RandomPatchConfiguration.GrassConfigurationBuilder shortGrassCluster = (new RandomPatchConfiguration.GrassConfigurationBuilder.Builder(new ShortGrassBlockStateProvider(), SimpleBlockPlacer.INSTANCE)).tries(16).build();
	public static RandomPatchConfiguration.GrassConfigurationBuilder beachGrassCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.beach_grass.defaultBlockState()), SimpleBlockPlacer.INSTANCE, 15);
	public static RandomPatchConfiguration.GrassConfigurationBuilder prairieGrassCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.prairie_grass.defaultBlockState()), SimpleBlockPlacer.INSTANCE, 50);
	public static RandomPatchConfiguration.GrassConfigurationBuilder desertSageCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.desert_sage.defaultBlockState()), SimpleBlockPlacer.INSTANCE, 3);
	public static RandomPatchConfiguration.GrassConfigurationBuilder dryGrassCluster = makeFeatureConfig(new WeightedBlockStateProvider()
			.add(PVJBlocks.dry_grass.defaultBlockState().setValue(DryGrassBlock.MODEL, 0), 1)
			.add(PVJBlocks.dry_grass.defaultBlockState().setValue(DryGrassBlock.MODEL, 1), 1), SimpleBlockPlacer.INSTANCE, 15);
	public static RandomPatchConfiguration.GrassConfigurationBuilder bloomingAgaveCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.blooming_desert_agave.defaultBlockState()), DoublePlantBlockPlacer.INSTANCE, 2);
	public static RandomPatchConfiguration.GrassConfigurationBuilder desertAgaveCluster = makeFeatureConfig(new SimpleStateProvider(PVJBlocks.desert_agave.defaultBlockState()), SimpleBlockPlacer.INSTANCE, 2);
	
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
	public static ConfiguredFeature<?, ?> cindercane;
	public static ConfiguredFeature<?, ?> short_grass;
	public static ConfiguredFeature<?, ?> beach_grass;
	public static ConfiguredFeature<?, ?> prairie_grass;
	public static ConfiguredFeature<?, ?> dry_grass;
	public static ConfiguredFeature<?, ?> desert_sage;
	public static ConfiguredFeature<?, ?> blooming_desert_agave;
	public static ConfiguredFeature<?, ?> desert_agave;
	public static ConfiguredFeature<?, ?> fallen_tree;
	public static ConfiguredFeature<?, ?> desert_rock;
	public static ConfiguredFeature<?, ?> tropical_beach_bush;
	public static ConfiguredFeature<?, ?> oak_bush;
	public static ConfiguredFeature<?, ?> cliff_rocks;

	public static ConfiguredFeature<TreeConfiguration, ?> mega_redwood_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> redwood_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> fir_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> pine_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> willow_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> mangrove_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> palm_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> baobab_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> juniper_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> cottonwood_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> cottonwood_tree_bees005;
	public static ConfiguredFeature<TreeConfiguration, ?> aspen_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> aspen_tree_bees002;
	public static ConfiguredFeature<TreeConfiguration, ?> red_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> orange_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> purple_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> large_red_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> large_orange_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> large_purple_maple_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> pink_sakura_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> white_sakura_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> pink_sakura_tree_bees002;
	public static ConfiguredFeature<TreeConfiguration, ?> white_sakura_tree_bees002;
	public static ConfiguredFeature<TreeConfiguration, ?> tamarack_tree;
	public static ConfiguredFeature<TreeConfiguration, ?> tamarack_tree_bees002;
	public static ConfiguredFeature<TreeConfiguration, ?> joshua_tree;

	public static ConfiguredFeature<?, ?> overgrown_spires_vegetation;
	public static ConfiguredFeature<?, ?> redwood_forest_vegetation;
	public static ConfiguredFeature<?, ?> boreal_forest_vegetation;
	public static ConfiguredFeature<?, ?> pine_meadows_vegetation;
	public static ConfiguredFeature<?, ?> boreal_plateau_vegetation;
	public static ConfiguredFeature<?, ?> aspen_grove_vegetation;
	public static ConfiguredFeature<?, ?> mangrove_marsh_vegetation;
	public static ConfiguredFeature<?, ?> willow_wetlands_vegetation;
	public static ConfiguredFeature<?, ?> baobab_fields_vegetation;
	public static ConfiguredFeature<?, ?> prairie_vegetation;
	public static ConfiguredFeature<?, ?> blossoming_fields_vegetation;
	public static ConfiguredFeature<?, ?> autumnnal_coniferous_forest_vegetation;
	public static ConfiguredFeature<?, ?> crimson_thicket_vegetation;
	public static ConfiguredFeature<?, ?> desert_shrubland_vegetation;
	public static ConfiguredFeature<?, ?> tropical_beach_vegetation;
	public static ConfiguredFeature<?, ?> crystal_lakes_vegetation;
	public static ConfiguredFeature<?, ?> windswept_cliffs_vegetation;
	
	public static ConfiguredFeature<?, ?> marsh_tall_grass;
	
	public static ConfiguredFeature<?, ?> autumn_floor_foliage;
	public static ConfiguredFeature<?, ?> sakura_floor_foliage;
	public static ConfiguredFeature<?, ?> crimson_thicket_floor_foliage;
	
	public static ConfiguredFeature<?, ?> vanilla_juniper;
	public static ConfiguredFeature<?, ?> vanilla_palm;
	
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

		autumn_floor_foliage = Feature.RANDOM_PATCH.configured(autumnFoliageCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(10);
		sakura_floor_foliage = Feature.RANDOM_PATCH.configured(sakuraFoliageCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(20);
		crimson_thicket_floor_foliage = Feature.RANDOM_PATCH.configured(crimsonFoliageCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(10);
		
		bushes = PVJFeatures.bushFeature.configured(new ProbabilityFeatureConfiguration(0.3F)).decorated(Features.Decorators.HEIGHTMAP_WORLD_SURFACE);
		bark_mushrooms = PVJFeatures.barkMushroomFeature.configured(IFeatureConfig.NONE).squared().count(30);
		cobwebs = PVJFeatures.cobwebFeature.configured(new ProbabilityConfig(0.1F)).squared().count(30).chance(25);
		glowcap = Feature.RANDOM_PATCH.configured(glowcapCluster).range(128).chance(2);
		crimson_nettle = Feature.NETHER_FOREST_VEGETATION.configured(crimsonNettleConfig).chance(40).decorated(Placement.COUNT_MULTILAYER.configured(new IntProviderConfig(4)));
		warped_nettle = Feature.NETHER_FOREST_VEGETATION.configured(warpedNettleConfig).chance(40).decorated(Placement.COUNT_MULTILAYER.configured(new IntProviderConfig(4)));
		cindercane = Feature.RANDOM_PATCH.configured(cindercaneConfig).count(10).range(128);
		short_grass = Feature.RANDOM_PATCH.configured(shortGrassCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5);
		beach_grass = Feature.RANDOM_PATCH.configured(beachGrassCluster).decorated(Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2);
		prairie_grass = Feature.RANDOM_PATCH.configured(prairieGrassCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(40);
		dry_grass = Feature.RANDOM_PATCH.configured(dryGrassCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(25);
		desert_sage = Feature.RANDOM_PATCH.configured(desertSageCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5);
		blooming_desert_agave = Feature.RANDOM_PATCH.configured(bloomingAgaveCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(1);
		desert_agave = Feature.RANDOM_PATCH.configured(desertAgaveCluster).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(2);
		tropical_beach_bush = PVJFeatures.sandTree.configured((new TreeConfiguration.Builder(new SimpleStateProvider(Blocks.JUNGLE_LOG.defaultBlockState()), new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState()), new BushFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(1), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build());
		oak_bush = PVJFeatures.sandTree.configured((new TreeConfiguration.Builder(new SimpleStateProvider(Blocks.OAK_LOG.defaultBlockState()), new SimpleStateProvider(Blocks.OAK_LEAVES.defaultBlockState()), new BushFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(1), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build());
		
		fallen_tree = PVJFeatures.fallenTreeFeature.configured(NoFeatureConfig.NONE).decorated(Placements.TOP_SOLID_HEIGHTMAP);
		
		desert_rock = PVJFeatures.sandRock.configured(new BlockStateFeatureConfig(Blocks.SANDSTONE.defaultBlockState())).decorated(Features.Placements.HEIGHTMAP_SQUARE).countRandom(2);
		cliff_rocks = PVJFeatures.cliffRock.configured(new ProbabilityConfig(0.5F)).decorated(Features.Placements.HEIGHTMAP_WORLD_SURFACE).count(2);
		
		mega_redwood_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.redwood_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.redwood_leaves.defaultBlockState()),
				new MegaPineFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0), IntProvider.of(25, 7)),
				new RedwoodTrunkPlacer(40, 30, 14), new TwoLayerFeature(1, 1, 2))).build());

		redwood_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.redwood_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.redwood_leaves.defaultBlockState()),
				new PineFoliagePlacer(IntProvider.fixed(1), IntProvider.fixed(1), IntProvider.of(3, 1)),
				new SmallRedwoodTrunkPlacer(7, 5, 0), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());

		fir_tree = PVJFeatures.snowTree.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.fir_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.fir_leaves.defaultBlockState()),
						new SpruceFoliagePlacer(IntProvider.of(3, 1), IntProvider.of(1, 1), IntProvider.of(4, 2)),
						new StraightTrunkPlacer(15, 3, 4), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());

		pine_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.pine_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.pine_leaves.defaultBlockState()),
						new PVJPineFoliagePlacer(IntProvider.of(3, 1), IntProvider.of(1, 1),
								IntProvider.of(3, 2)),
						new StraightTrunkPlacer(9, 2, 2), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());

		willow_tree = PVJFeatures.sandTree.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.willow_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.willow_leaves.defaultBlockState()),
						new BlobFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(0), 3),
						new WillowTrunkPlacer(6, 3, 3), new TwoLayerFeature(1, 0, 1))).decorators(
								ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.INSTANCE))
								.build());

		mangrove_tree = PVJFeatures.sandTree.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.mangrove_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.mangrove_leaves.defaultBlockState()),
						new BlobFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(0), 3),
						new MangroveTrunkPlacer(4, 2, 2), new TwoLayerFeature(1, 0, 1))).maxWaterDepth(7).build());

		palm_tree = PVJFeatures.sandTree.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.palm_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.palm_leaves.defaultBlockState()),
						new PalmFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0)),
						new PalmTrunkPlacer(7, 2, 2), new TwoLayerFeature(2, 0, 2)).decorators(
								ImmutableList.of(CoconutDecorator.INSTANCE))).ignoreVines().build());

		baobab_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.baobab_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.baobab_leaves.defaultBlockState()),
						new BaobabFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0)),
						new BaobabTrunkPlacer(20, 5, 2), new TwoLayerFeature(1, 1, 2))).build());

		juniper_tree = PVJFeatures.juniperTree.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.juniper_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.juniper_leaves.defaultBlockState()),
						new DesertJuniperFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0)),
						new DesertJuniperTrunkPlacer(7, 2, 1), new TwoLayerFeature(2, 0, 2)).decorators(
								ImmutableList.of(JuniperBerriesDecorator.INSTANCE)).ignoreVines().build()));

		cottonwood_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.cottonwood_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.cottonwood_leaves.defaultBlockState()),
						new FancyFoliagePlacer(IntProvider.fixed(3), IntProvider.fixed(4), 4),
						new FancyTrunkPlacer(15, 4, 3), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
								.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		cottonwood_tree_bees005 = Feature.TREE.configured(cottonwood_tree.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005)));
		
		pink_sakura_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.sakura_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.pink_sakura_leaves.defaultBlockState()),
						new FancyFoliagePlacer(IntProvider.fixed(3), IntProvider.fixed(4), 4),
						new FancyTrunkPlacer(10, 4, 3), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
								.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		white_sakura_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.sakura_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.white_sakura_leaves.defaultBlockState()),
						new FancyFoliagePlacer(IntProvider.fixed(3), IntProvider.fixed(4), 4),
						new FancyTrunkPlacer(10, 4, 3), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
								.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		pink_sakura_tree_bees002 = Feature.TREE.configured(pink_sakura_tree.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002)));
		white_sakura_tree_bees002 = Feature.TREE.configured(white_sakura_tree.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002)));
		
		aspen_tree = Feature.TREE.configured(
				(new TreeConfiguration.Builder(new SimpleStateProvider(PVJBlocks.aspen_log.defaultBlockState()),
						new SimpleStateProvider(PVJBlocks.aspen_leaves.defaultBlockState()),
						new AspenFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0)),
						new AspenTrunkPlacer(11, 5, 2), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());
		
		aspen_tree_bees002 = Feature.TREE.configured(aspen_tree.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002)));
		
		red_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.red_maple_leaves.defaultBlockState()),
				new BlobFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(0), 3),
				new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
		
		orange_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.orange_maple_leaves.defaultBlockState()),
				new BlobFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(0), 3),
				new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
		
		purple_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.purple_maple_leaves.defaultBlockState()),
				new BlobFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(0), 3),
				new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());

		large_red_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.red_maple_leaves.defaultBlockState()),
				new FancyFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(4), 4),
				new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
						.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		large_orange_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.orange_maple_leaves.defaultBlockState()),
				new FancyFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(4), 4),
				new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
						.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		large_purple_maple_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.maple_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.purple_maple_leaves.defaultBlockState()),
				new FancyFoliagePlacer(IntProvider.fixed(2), IntProvider.fixed(4), 4),
				new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
						.heightmap(Heightmap.Type.MOTION_BLOCKING).build());
		
		tamarack_tree = Feature.TREE.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.tamarack_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.tamarack_leaves.defaultBlockState()),
				new SpruceFoliagePlacer(IntProvider.of(3, 1), IntProvider.of(1, 1), IntProvider.of(4, 2)),
				new StraightTrunkPlacer(15, 3, 4), new TwoLayerFeature(2, 0, 2))).ignoreVines().build());
		
		tamarack_tree_bees002 = Feature.TREE.configured(tamarack_tree.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002)));
		
		joshua_tree = PVJFeatures.juniperTree.configured((new TreeConfiguration.Builder(
				new SimpleStateProvider(PVJBlocks.joshua_log.defaultBlockState()),
				new SimpleStateProvider(PVJBlocks.joshua_leaves.defaultBlockState()),
				new DesertJuniperFoliagePlacer(IntProvider.fixed(0), IntProvider.fixed(0)),
				new FancyTrunkPlacer(8, 8, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
						.heightmap(Heightmap.Type.MOTION_BLOCKING).build());

		overgrown_spires_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
						Features.FANCY_OAK.weighted(0.05F),
						Features.JUNGLE_BUSH.weighted(0.35F),
						Features.MEGA_JUNGLE_TREE.weighted(0.3F),
						Features.DARK_OAK.weighted(0.05F),
						Features.OAK.weighted(0.15F),
						palm_tree.weighted(0.05F),
						Features.JUNGLE_TREE.weighted(0.2F)),
						Features.JUNGLE_TREE))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(20, 0.4F, 1)));
		
		redwood_forest_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(mega_redwood_tree.weighted(0.75F), redwood_tree.weighted(0.25F)),
						mega_redwood_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(7, 0.4F, 2)));

		boreal_forest_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(fir_tree.weighted(0.75F), pine_tree.weighted(0.25F)), fir_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(10, 0.3F, 1)));

		pine_meadows_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(ImmutableList.of(pine_tree.weighted(0.4F),
						Features.OAK.weighted(0.2F), Features.OAK_BEES_0002.weighted(0.05F)), oak_bush))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.2F, 2)));
		
		boreal_plateau_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(fir_tree.weighted(0.75F), Features.SPRUCE.weighted(0.25F)), fir_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(3, 0.3F, 1)));
		
		aspen_grove_vegetation = Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(
				aspen_tree_bees002.weighted(0.3F),
				red_maple_tree.weighted(0.15F),
				orange_maple_tree.weighted(0.15F),
				purple_maple_tree.weighted(0.15F),
				large_red_maple_tree.weighted(0.05F),
				large_orange_maple_tree.weighted(0.05F),
				large_purple_maple_tree.weighted(0.05F),
				Features.OAK_BEES_005.weighted(0.25F),
				Features.FANCY_OAK_BEES_005.weighted(0.05F)), Features.FANCY_OAK_BEES_005))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(6, 0.1F, 1)));
		
		mangrove_marsh_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(mangrove_tree.weighted(0.75F)), mangrove_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(4, 0.4F, 1)));
		
		willow_wetlands_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(willow_tree.weighted(0.75F)), willow_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(3, 0.4F, 1)));
		
		baobab_fields_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(Features.ACACIA.weighted(0.5F)), baobab_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(7, 0.3F, 1)));
		
		prairie_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(cottonwood_tree_bees005.weighted(1.0F)), cottonwood_tree_bees005))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.15F, 1)));
		
		blossoming_fields_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(white_sakura_tree_bees002.weighted(0.5F), pink_sakura_tree_bees002.weighted(0.5F)), pink_sakura_tree_bees002))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.4F, 1)));
		
		autumnnal_coniferous_forest_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(tamarack_tree_bees002.weighted(0.4F), fir_tree.weighted(0.55F)), Features.SPRUCE))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(8, 0.4F, 1)));
		
		crimson_thicket_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(Features.PINE.weighted(0.05F), Features.SPRUCE.weighted(0.15F), Features.SPRUCE.weighted(0.15F),
								red_maple_tree.weighted(0.25F), purple_maple_tree.weighted(0.25F), fir_tree.weighted(0.1F)), fir_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(9, 0.4F, 1)));
		
		desert_shrubland_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(joshua_tree.weighted(1.0F)), joshua_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.30F, 1)));
		
		tropical_beach_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(palm_tree.weighted(0.5F), tropical_beach_bush.weighted(0.5F)), palm_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(6, 0.4F, 1)));
		
		crystal_lakes_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(fir_tree.weighted(0.4F), pine_tree.weighted(0.2F)), Features.SPRUCE))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(8, 0.3F, 1)));
		
		windswept_cliffs_vegetation = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(ImmutableList.of(Features.OAK.weighted(0.6F)), oak_bush))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.4F, 2)));

		vanilla_juniper = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(juniper_tree.weighted(1.0F)), juniper_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.05F, 1)));
		
		vanilla_palm = Feature.RANDOM_SELECTOR
				.configured(new MultipleRandomFeatureConfig(
						ImmutableList.of(palm_tree.weighted(1.0F)), palm_tree))
				.decorated(Features.Placements.HEIGHTMAP_SQUARE)
				.decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(0, 0.1F, 1)));
		
		marsh_tall_grass = Features.PATCH_TALL_GRASS.count(30);

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
		register("warped_nettle", warped_nettle);
		register("cindercane", cindercane);
		register("autumn_floor_foliage", autumn_floor_foliage);
		register("sakura_floor_foliage", sakura_floor_foliage);
		register("crimson_thicket_floor_foliage", crimson_thicket_floor_foliage);
		register("desert_rock", desert_rock);
		register("desert_sage", desert_sage);
		register("blooming_desert_agave", blooming_desert_agave);
		register("desert_agave", desert_agave);
		register("tropical_beach_bush", tropical_beach_bush);
		register("oak_bush", oak_bush);
		register("cliff_rocks", cliff_rocks);
		
		register("short_grass", short_grass);
		register("beach_grass", beach_grass);
		register("prairie_grass", prairie_grass);
		register("dry_grass", dry_grass);
		
		register("mega_redwood_tree", mega_redwood_tree);
		register("redwood_tree", redwood_tree);
		register("fir_tree", fir_tree);
		register("pine_tree", pine_tree);
		register("willow_tree", willow_tree);
		register("mangrove_tree", mangrove_tree);
		register("palm_tree", palm_tree);
		register("baobab_tree", baobab_tree);
		register("juniper_tree", juniper_tree);
		register("cottonwood_tree", cottonwood_tree);
		register("cottonwood_tree_bees005", cottonwood_tree_bees005);
		register("aspen_tree", aspen_tree);
		register("aspen_tree_bees002", aspen_tree_bees002);
		register("red_maple_tree", red_maple_tree);
		register("orange_maple_tree", orange_maple_tree);
		register("purple_maple_tree", purple_maple_tree);
		register("large_red_maple_tree", large_red_maple_tree);
		register("large_orange_maple_tree", large_orange_maple_tree);
		register("large_purple_maple_tree", large_purple_maple_tree);
		register("pink_sakura_tree", pink_sakura_tree);
		register("white_sakura_tree", white_sakura_tree);
		register("pink_sakura_tree_bees002", pink_sakura_tree_bees002);
		register("white_sakura_tree_bees002", white_sakura_tree_bees002);
		register("tamarack_tree", tamarack_tree);
		register("tamarack_tree_bees002", tamarack_tree_bees002);
		register("joshua_tree", joshua_tree);

		register("overgrown_spires_vegetation", overgrown_spires_vegetation);
		register("redwood_forest_vegetation", redwood_forest_vegetation);
		register("boreal_forest_vegetation", boreal_forest_vegetation);
		register("pine_meadows_vegetation", pine_meadows_vegetation);
		register("boreal_plateau_vegetation", boreal_plateau_vegetation);
		register("aspen_grove_vegetation", aspen_grove_vegetation);
		register("mangrove_marsh_vegetation", mangrove_marsh_vegetation);
		register("willow_wetlands_vegetation", willow_wetlands_vegetation);
		register("baobab_fields_vegetation", baobab_fields_vegetation);
		register("prairie_vegetation", prairie_vegetation);
		register("blossoming_fields_vegetation", blossoming_fields_vegetation);
		register("autumnnal_coniferous_forest_vegetation", autumnnal_coniferous_forest_vegetation);
		register("crimson_thicket_vegetation", crimson_thicket_vegetation);
		register("desert_shrubland_vegetation", desert_shrubland_vegetation);
		register("tropical_beach_vegetation", tropical_beach_vegetation);
		register("crystal_lakes_vegetation", crystal_lakes_vegetation);
		register("windswept_cliffs_vegetation", windswept_cliffs_vegetation);
		
		register("vanilla_juniper", vanilla_juniper);
		register("vanilla_palm", vanilla_palm);
		
		register("marsh_tall_grass", marsh_tall_grass);
	}

	private static RandomPatchConfiguration.GrassConfigurationBuilder makeFeatureConfig(BlockStateProvider provider, BlockPlacer placer, int tries) {
		return new RandomPatchConfiguration.GrassConfigurationBuilder.Builder(provider, placer).tries(tries).build();
	}

	private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE,
				new ResourceLocation(ProjectVibrantJourneys.MOD_ID, key), configuredFeature);
	}
}
