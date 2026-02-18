package me.ultrusmods.extrasponges.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

public class ExtraSpongeBlock extends Block {

    private final int range;
    private final int absorbAmount;
    private Block wetSponge;
    public ExtraSpongeBlock(Properties settings, int range, int absorbAmount) {
        super(settings);
        this.range = range;
        this.absorbAmount = absorbAmount;
    }

    public void setWetSponge(Block wetSponge) {
        this.wetSponge = wetSponge;
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.is(state.getBlock())) {
            this.update(level, pos);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
        this.update(level, pos);
        super.neighborChanged(state, level, pos, neighborBlock, orientation, movedByPiston);
    }

    protected void update(Level level, BlockPos pos) {
        if (this.absorbWater(level, pos)) {
            level.setBlock(pos, wetSponge.defaultBlockState(), 2);
            level.globalLevelEvent(2001, pos, Block.getId(Blocks.WATER.defaultBlockState()));
        }

    }

    private boolean absorbWater(Level world, BlockPos pos) {
        return BlockPos.breadthFirstTraversal(pos, range, absorbAmount, (posx, consumer) -> {
            for (Direction direction : BlockBehaviour.UPDATE_SHAPE_ORDER) {
                consumer.accept(posx.relative(direction));
            }
        }, (checkedPos) -> {
            if (checkedPos.equals(pos)) {
                return BlockPos.TraversalNodeStatus.ACCEPT;
            } else {
                BlockState blockState = world.getBlockState(checkedPos);
                FluidState fluidState = world.getFluidState(checkedPos);
                if (!fluidState.is(FluidTags.WATER)) {
                    return BlockPos.TraversalNodeStatus.SKIP;
                } else {
                    Block block = blockState.getBlock();
                    if (block instanceof BucketPickup bucketPickup) {
                        if (!bucketPickup.pickupBlock(null, world, checkedPos, blockState).isEmpty()) {
                            return BlockPos.TraversalNodeStatus.ACCEPT;
                        }
                    }

                    if (blockState.getBlock() instanceof LiquidBlock) {
                        world.setBlock(checkedPos, Blocks.AIR.defaultBlockState(), 3);
                    } else {
                        if (!blockState.is(Blocks.KELP) && !blockState.is(Blocks.KELP_PLANT) && !blockState.is(Blocks.SEAGRASS) && !blockState.is(Blocks.TALL_SEAGRASS)) {
                            return BlockPos.TraversalNodeStatus.SKIP;
                        }

                        BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(checkedPos) : null;
                        dropResources(blockState, world, checkedPos, blockEntity);
                        world.setBlock(checkedPos, Blocks.AIR.defaultBlockState(), 3);
                    }

                    return BlockPos.TraversalNodeStatus.ACCEPT;
                }
            }
        }) > 1;
    }

}
