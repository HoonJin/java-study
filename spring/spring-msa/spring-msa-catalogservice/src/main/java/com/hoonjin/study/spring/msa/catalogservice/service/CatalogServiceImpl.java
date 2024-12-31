package com.hoonjin.study.spring.msa.catalogservice.service;

import com.hoonjin.study.spring.msa.catalogservice.jpa.CatalogEntity;
import com.hoonjin.study.spring.msa.catalogservice.jpa.CatalogRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
