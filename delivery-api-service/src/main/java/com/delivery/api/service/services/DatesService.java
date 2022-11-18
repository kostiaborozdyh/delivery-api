package com.delivery.api.service.services;

import com.delivery.db.entities.Dates;
import com.delivery.db.repository.DatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DatesService {
    private final DatesRepository datesRepository;
    @Transactional(readOnly = true)
    public List<Dates> getAll() {
        return datesRepository.findAll();
    }
}
