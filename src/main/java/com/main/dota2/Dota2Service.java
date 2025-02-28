package com.main.dota2;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Dota2Service {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://api.opendota.com/api";

    public Profile getPlayerById(Long accountId) {
        String url = BASE_URL + "/players/" + accountId;
        return restTemplate.getForObject(url, Profile.class);
    }
    public List<Profile> getAllPlayers() {
        String url = BASE_URL + "/proPlayers";
        ResponseEntity<Profile[]> response = restTemplate.getForEntity(url, Profile[].class);
        return response.getBody() != null ? Arrays.asList(response.getBody()) : List.of();
    }

    public List<Profile> findByName(String name) {
        return getAllPlayers().stream()
                .filter(profile -> profile.getName() != null &&
                        profile.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
