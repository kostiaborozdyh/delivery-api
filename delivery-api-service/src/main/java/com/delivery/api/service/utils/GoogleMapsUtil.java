package com.delivery.api.service.utils;

import com.delivery.api.service.dto.googleMaps.GoogleMapsDTO;
import lombok.experimental.UtilityClass;
import org.springframework.web.client.RestTemplate;

@UtilityClass
public class GoogleMapsUtil {
    public static final String API_KEY = "&key=AIzaSyDZ_4ASyzLdt1d16-mekZg5W4X24P0zIR4";
    public static final String HTTP_MAPS = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";
    public static final String DESTINATIONS = "&destinations=";
    public static final String LANGUAGE = "&language=uk&departure_time=now";

    public GoogleMapsDTO getGoogleMapsInfo(String cityFrom, String cityTo){
        final String url = HTTP_MAPS + cityFrom + DESTINATIONS + cityTo + LANGUAGE + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
       return restTemplate.getForObject(url,GoogleMapsDTO.class);
    }
}
