package com.delivery.api.service.services;

import com.delivery.api.service.dto.googleMaps.GoogleMapsDTO;
import com.delivery.api.service.dto.googleMaps.GoogleMapsRequestDTO;
import com.delivery.api.service.dto.price.PriceDTO;
import com.delivery.api.service.utils.GoogleMapsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleMapsService {

    public List<PriceDTO> getPriceList(GoogleMapsRequestDTO googleMapsRequestDTO) {
        GoogleMapsDTO googleMapsDTO = GoogleMapsUtil.getGoogleMapsInfo(googleMapsRequestDTO.getCityFrom(), googleMapsRequestDTO.getCityTo());
        List<PriceDTO> priceDTOList = new ArrayList<>();
        int originCount = googleMapsDTO.getOrigin_addresses().size();
        int destinationCount = googleMapsDTO.getDestination_addresses().size();
        for (int i = 0; i < originCount; i++) {
            for (int j = 0; j < destinationCount; j++) {
                PriceDTO priceDTO = new PriceDTO();
                priceDTO.setCityFrom(googleMapsDTO.getOrigin_addresses().get(i));
                priceDTO.setCityTo(googleMapsDTO.getDestination_addresses().get(j));
                int distance = googleMapsDTO.getRows().get(i).getElements().get(j).getDistance().getValue();
                priceDTO.setDistance(distance);
                priceDTO.setPrice(1.0 * distance / 1000);
                priceDTOList.add(priceDTO);
            }
        }
        return priceDTOList;
    }
}
