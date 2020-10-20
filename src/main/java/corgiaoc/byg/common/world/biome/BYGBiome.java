package corgiaoc.byg.common.world.biome;

import com.mojang.datafixers.util.Pair;
import corgiaoc.byg.config.json.BiomeData;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class BYGBiome {
    public static final List<BYGBiome> BYG_BIOMES = new ArrayList<>();
    private final Biome biome;

    public static List<BiomeData> biomeData = new ArrayList<>();

    public static final List<Pair<Int2ObjectMap<WeightedList<Biome>>, Integer>> BIOME_TO_HILLS_LIST = new ArrayList<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_BEACH_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_EDGE_LIST = new Int2ObjectArrayMap<>();
    public static final Int2ObjectMap<Biome> BIOME_TO_RIVER_LIST = new Int2ObjectArrayMap<>();

    public BYGBiome(Biome.Climate climate, Biome.Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
        biome = new Biome(climate, category, depth, scale, effects, biomeGenerationSettings, mobSpawnInfo);
        BYG_BIOMES.add(this);
    }

    public BYGBiome(Biome.Builder builder) {
        this.biome = builder.build();
        BYG_BIOMES.add(this);
    }

    public BYGBiome(Biome biome) {
        this.biome = biome;
        BYG_BIOMES.add(this);
    }

    public Biome getBiome() {
        return this.biome;
    }

    @Nullable
    public Biome getHills(INoiseRandom random) {
        return null;
    }

    public Biome getRiver() {
        return WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER);
    }

    public int getWeight() {
        return 5;
    }

    public int getReplacementChance() {
        return 3;
    }

    @Nullable
    public WeightedList<Biome> getHills() {
        return null;
    }

    @Nullable
    public Biome getEdge() {
        return null;
    }

    @Nullable
    public Biome getBeach() {
        return null;
    }


    @Nullable
    public Biome getEdges(INoiseRandom rand, Biome north, Biome west, Biome south, Biome east) {
        return null;
    }

    public HashMap<Biome, Integer> getEdges() {
        return new HashMap<>();
    }

    public RegistryKey<Biome> getKey() {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, Objects.requireNonNull(WorldGenRegistries.BIOME.getKey(this.biome)));
    }
}
