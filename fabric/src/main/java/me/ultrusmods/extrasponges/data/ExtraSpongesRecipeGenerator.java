package me.ultrusmods.extrasponges.data;

import me.ultrusmods.extrasponges.register.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class ExtraSpongesRecipeGenerator extends FabricRecipeProvider {

    public ExtraSpongesRecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                createSpongeRecipe(Items.SPONGE, Items.IRON_INGOT, ItemRegistry.IRON_SPONGE, ItemRegistry.WET_IRON_SPONGE, exporter);
                createSpongeRecipe(ItemRegistry.IRON_SPONGE, Items.GOLD_INGOT, ItemRegistry.GOLD_SPONGE, ItemRegistry.WET_GOLD_SPONGE, exporter);
                createSpongeRecipe(ItemRegistry.GOLD_SPONGE, Items.DIAMOND, ItemRegistry.DIAMOND_SPONGE, ItemRegistry.WET_DIAMOND_SPONGE, exporter);
                createSpongeRecipe(ItemRegistry.DIAMOND_SPONGE, Items.NETHERITE_INGOT, ItemRegistry.NETHERITE_SPONGE, ItemRegistry.WET_NETHERITE_SPONGE, exporter);

                this.shaped(RecipeCategory.MISC, ItemRegistry.LAVA_SPONGE, 1)
                        .pattern("MSM")
                        .pattern("SBS")
                        .pattern("MSM")
                        .define('M', Items.MAGMA_BLOCK)
                        .define('S', Items.SPONGE)
                        .define('B', Items.BASALT)
                        .unlockedBy("has_basalt", has(Items.BASALT)
                        ).save(exporter);
            }


            public void createSpongeRecipe(Item spongeBase, Item upgradeItem, Item resultItem, Item wetForm, RecipeOutput exporter) {
                this.shaped(RecipeCategory.BUILDING_BLOCKS, resultItem, 8)
                        .pattern("SSS")
                        .pattern("SUS")
                        .pattern("SSS")
                        .define('S', spongeBase)
                        .define('U', upgradeItem)
                        .unlockedBy("has_upgrade", has(upgradeItem))
                        .save(exporter);


                SimpleCookingRecipeBuilder.smelting(Ingredient.of(wetForm),
                                RecipeCategory.BUILDING_BLOCKS,
                                resultItem, 0.15F, 200)
                        .unlockedBy("has_wet_sponge", has(wetForm)).save(exporter, getDefaultRecipeId(resultItem).withSuffix("_smelted").toString());

            }
        };
    }
    
    @Override
    public String getName() {
        return "Extra Sponges Recipes";
    }
}
