package com.exercise.poke.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDetailDto {
    private String name;
    private int height;
    private int weight;
    @JsonProperty("base_experience")
    private int baseExperience;
    private List<PokemonAbilityDto> abilities;
    private List<PokemonStatsDto> stats;

    private SpriteDto sprites;

    public List<PokemonStatsDto> getStats() {
        return stats;
    }

    public void setStats(List<PokemonStatsDto> stats) {
        this.stats = stats;
    }

    public SpriteDto getSprites() {
        return sprites;
    }

    public void setSprites(SpriteDto sprites) {
        this.sprites = sprites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<PokemonAbilityDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokemonAbilityDto> abilities) {
        this.abilities = abilities;
    }

}
