package com.api.olympic.service;

import com.api.olympic.model.Medal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OlympicService {

    private static final String BASE_URL = "https://apis.codante.io/olympic-games";

    @Autowired
    private RestTemplate restTemplate;

    public List<Medal> getMedalsByCountry(String countryId) {
        // Chama a API para obter a lista de medalhas
        String url = BASE_URL + "/countries";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || response.get("data") == null) {
            return List.of(); // Retorna uma lista vazia em caso de falha
        }

        // Filtra as medalhas pelo país
        List<Map<String, Object>> medalsData = (List<Map<String, Object>>) response.get("data");

        return medalsData.stream()
                .filter(medal -> countryId.equals(medal.get("id")))
                .map(this::convertToMedal)
                .collect(Collectors.toList());
    }

    public List<Medal> getAllMedals() {
        // Chama a API para obter a lista de medalhas
        String url = BASE_URL + "/countries";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || response.get("data") == null) {
            return List.of(); // Retorna uma lista vazia em caso de falha
        }

        // Converte todos os dados de medalhas em objetos Medal
        List<Map<String, Object>> medalsData = (List<Map<String, Object>>) response.get("data");

        return medalsData.stream()
                .map(this::convertToMedal)
                .collect(Collectors.toList());
    }

    private Medal convertToMedal(Map<String, Object> medalData) {
        Medal medal = new Medal();
        medal.setId((String) medalData.get("id"));
        medal.setName((String) medalData.get("name"));
        medal.setContinent((String) medalData.get("continent"));
        medal.setFlagUrl((String) medalData.get("flag_url"));
        medal.setGoldMedals(((Number) medalData.get("gold_medals")).intValue());
        medal.setSilverMedals(((Number) medalData.get("silver_medals")).intValue());
        medal.setBronzeMedals(((Number) medalData.get("bronze_medals")).intValue());
        medal.setTotalMedals(((Number) medalData.get("total_medals")).intValue());
        medal.setRank(((Number) medalData.get("rank")).intValue());
        medal.setRankTotalMedals(((Number) medalData.get("rank_total_medals")).intValue());
        return medal;
    }
}
