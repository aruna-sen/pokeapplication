package com.exercise.poke;

import com.exercise.poke.controller.PokeController;
import com.exercise.poke.dto.*;
import com.exercise.poke.service.PokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokeControllerTest {
    private WebTestClient webTestClient;
    private PokeService pokeService;

     @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        pokeService=mock(PokeService.class);
        webTestClient = WebTestClient.bindToController(new PokeController(pokeService)).build();
    }


    @Test
    void testGetHundreadPoke(){
        List<PokemonDto> mockPokemonList = Arrays.asList(
                new PokemonDto("bulbasaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                new PokemonDto("ivysaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png")
        );

        Mockito.when(pokeService.fetchHundredPoke()).thenReturn(Mono.just(mockPokemonList));

        webTestClient.get().uri("/rest/api/v1/getHundredPokemon")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectBodyList(PokemonDto.class)
                        .value(response->{
                                assert response.size() == 2;
                                assert response.get(0).getName().equals("bulbasaur");
                                assert response.get(0).getImageUrl().equals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
                        });
         }

         @Test
          void testGetPokemondetails(){
           String name = "bulbasaur";
            PokemonAbilityDto ability1 = new PokemonAbilityDto(new AbilityDto("overgrow"));
            PokemonAbilityDto ability2 = new PokemonAbilityDto(new AbilityDto("chlorophyll"));
            List<PokemonAbilityDto> abilities = new ArrayList<>();
            abilities.add(ability1);
            abilities.add(ability2);

             PokemonStatsDto statsDto1= new PokemonStatsDto(45,new StatDto("hp"));
             PokemonStatsDto statsDto2= new PokemonStatsDto(49,new StatDto("attack"));
             List<PokemonStatsDto> stats = new ArrayList<>();
             stats.add(statsDto1);
             stats.add(statsDto2);

             SpriteDto sprite = new SpriteDto("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
             PokemonDetailDto pokemonDetailDto = new PokemonDetailDto();
             pokemonDetailDto.setName(name);
             pokemonDetailDto.setHeight(7);
             pokemonDetailDto.setWeight(69);
             pokemonDetailDto.setBaseExperience(64);
             pokemonDetailDto.setAbilities(abilities);
             pokemonDetailDto.setStats(stats);
             pokemonDetailDto.setSprites(sprite);

             Mockito.when(pokeService.fetchPokemonDetails(name)).thenReturn(Mono.just(pokemonDetailDto));

             webTestClient.get().uri("/rest/api/v1/getPokemonDetails/"+name)
                     .accept(MediaType.APPLICATION_JSON)
                     .exchange()
                     .expectStatus().isOk()
                     .expectBody(PokemonDetailDto.class)
                     .value(response->{
                             assert response.getName().equals(name);
                             assert response.getHeight() == 7;
                             assert response.getWeight() == 69;
                             assert response.getBaseExperience() == 64;
                             assert response.getAbilities().get(0).getAbility().getName().equals("overgrow");
                             assert response.getAbilities().get(1).getAbility().getName().equals("chlorophyll");
                             assert response.getStats().get(0).getBaseStat() == 45;
                             assert response.getStats().get(0).getStat().getName().equals("hp");
                             assert response.getStats().get(1).getStat().getName().equals("attack");
                             assert response.getSprites().getFrontDefault().equals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
                     });
         }
}
