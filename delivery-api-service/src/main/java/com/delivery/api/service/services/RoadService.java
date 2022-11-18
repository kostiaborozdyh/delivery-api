package com.delivery.api.service.services;

import com.delivery.db.entities.Road;
import com.delivery.db.repository.RoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoadService {
    private final RoadRepository roadRepository;
    @Transactional(readOnly = true)
    public List<Road> getAll() {
        return roadRepository.findAll();
    }
}
