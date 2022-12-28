package com.delivery.api.service.convertor;


import java.util.List;

public interface Convertable<V,Z,T> {
    V convertFromRequestDto(Z t);
    List<T> convertToListResponseDTO(List<V> v);
    T convertToResponseDTO(V v);


}
