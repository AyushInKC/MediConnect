package com.JavaJunkie.Hack2Skill.Service;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalService {
    private static final String NOMINATIM_BASE_URL = "https://nominatim.openstreetmap.org/search";

    public Map<String, Object> findNearbyHospitals(double latitude, double longitude) {
        String apiUrl = String.format(
                "%s?format=json&q=hospital&viewbox=%f,%f,%f,%f&bounded=1",
                NOMINATIM_BASE_URL,
                longitude - 0.05, latitude + 0.05,
                longitude + 0.05, latitude - 0.05
        );

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        Map<String, Object> result = new HashMap<>();
        List<Map<String, String>> hospitals = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(response.getBody());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject hospital = jsonArray.getJSONObject(i);
                Map<String, String> hospitalData = new HashMap<>();
                hospitalData.put("name", hospital.optString("display_name", "Name not available"));
                hospitalData.put("latitude", hospital.optString("lat", "0"));
                hospitalData.put("longitude", hospital.optString("lon", "0"));
                hospitals.add(hospitalData);
            }

            result.put("status", "success");
            result.put("hospitals", hospitals);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("message", "Error fetching hospital data");
        }

        return result;
    }
}