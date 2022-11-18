package com.delivery.api.service.services;

import com.delivery.db.entities.Dates;
import com.delivery.db.entities.Description;
import com.delivery.db.repository.DatesRepository;
import com.delivery.db.repository.DescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DescriptionService {
    private final DescriptionRepository descriptionRepository;
    @Transactional(readOnly = true)
    public List<Description> getAll() {
        return descriptionRepository.findAll();
    }
}
