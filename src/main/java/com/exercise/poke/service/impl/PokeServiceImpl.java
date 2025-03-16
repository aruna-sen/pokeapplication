package com.exercise.poke.service.impl;

import com.exercise.poke.dto.PokemonDetailDto;
import com.exercise.poke.dto.PokemonDto;
import com.exercise.poke.service.PokeService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
public class PokeServiceImpl implements PokeService {

    private final WebClient webClient;
    public PokeServiceImpl(WebClient.Builder builder){
        final int size= 16*1024*1024;
        final ExchangeStrategies strategies=ExchangeStrategies.builder()
                .codecs(codecs->codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        this.webClient = builder.exchangeStrategies(strategies).baseUrl("https://pokeapi.co/api/v2").build();
    }
    public Mono<List<PokemonDto>> fetchHundredPoke(){
      return webClient.get().uri("/pokemon?limit=100&offset=0")
              .retrieve()
              .bodyToMono(JsonNode.class)
              .flatMap(jsonNode -> {
                  List<Mono<PokemonDto>> pokemonDtos = new ArrayList<>();
                  for(JsonNode node: jsonNode.get("results")) {
                      String name = node.get("name").asText();
                    //  String detailUrl = node.get("url").asText();

                      Mono<PokemonDto> pokemonDtoMono = webClient.get().uri("/pokemon/" + name).retrieve()
                              .bodyToMono(JsonNode.class)
                              .map(details -> new PokemonDto(name,details.get("sprites").get("front_default").asText()));
                      pokemonDtos.add(pokemonDtoMono);
                  }
                  return Flux.merge(pokemonDtos).collectList();
      });
    }


   public Mono<PokemonDetailDto> fetchPokemonDetails(String name){
        return webClient.get()
                .uri("/pokemon/{name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PokemonDetailDto.class);
   }

}
