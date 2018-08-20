package vibrantjourneys.worldgen;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import vibrantjourneys.init.PVJBlocks;

public class WorldGenFirTree extends WorldGenAbstractTree
{
    private static final IBlockState TRUNK = PVJBlocks.fir_log.getDefaultState();
    private static final IBlockState LEAF = PVJBlocks.fir_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenFirTree(boolean notify)
    {
        super(notify);
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(8) + 16;
        int j = 3 + rand.nextInt(2);
        int k = i - j;
        int l = 3 + rand.nextInt(2);
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight())
        {
            for (int i1 = position.getY(); i1 <= position.getY() + 1 + i && flag; ++i1)
            {
                int j1;

                if (i1 - position.getY() < j)
                {
                    j1 = 0;
                }
                else
                {
                    j1 = l;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int k1 = position.getX() - j1; k1 <= position.getX() + j1 && flag; ++k1)
                {
                    for (int l1 = position.getZ() - j1; l1 <= position.getZ() + j1 && flag; ++l1)
                    {
                        if (i1 >= 0 && i1 < worldIn.getHeight())
                        {
                            IBlockState state = worldIn.getBlockState(blockpos$mutableblockpos.setPos(k1, i1, l1));

                            if (!state.getBlock().isAir(state, worldIn, blockpos$mutableblockpos.setPos(k1, i1, l1)) && !state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos.setPos(k1, i1, l1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.down();
                IBlockState state = worldIn.getBlockState(down);

                if (state.getBlock().canSustainPlant(state, worldIn, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, down, position);
                    int i3 = rand.nextInt(3) + 1;
                    int j3 = 1;
                    int k3 = 0;

                    for (int l3 = 0; l3 <= k; ++l3)
                    {
                        int j4 = position.getY() + i - l3;
                        int i4 = i3;
                        if(j4 == position.getY() + i)
                        {
                        	i4 = 1;
                        }

                        for (int i2 = position.getX() - i4; i2 <= position.getX() + i4; ++i2)
                        {
                            int j2 = i2 - position.getX();

                            for (int k2 = position.getZ() - i4; k2 <= position.getZ() + i4; ++k2)
                            {
                                int l2 = k2 - position.getZ();

                                if (Math.abs(j2) != i4 || Math.abs(l2) != i4 || i4 <= 0)
                                {
                                    BlockPos blockpos = new BlockPos(i2, j4, k2);
                                    state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().canBeReplacedByLeaves(state, worldIn, blockpos))
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, LEAF);
                                    }
                                }
                            }
                        }

                        if (i3 >= j3)
                        {
                            i3 = k3;
                            k3 = 1;
                            ++j3;

                            if (j3 > l)
                            {
                                j3 = l;
                            }
                        }
                        else
                        {
                            ++i3;
                        }
                    }

                    int i4 = rand.nextInt(3);

                    for (int k4 = 0; k4 < i - i4; ++k4)
                    {
                        BlockPos upN = position.up(k4);
                        state = worldIn.getBlockState(upN);

                        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(k4), TRUNK);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}