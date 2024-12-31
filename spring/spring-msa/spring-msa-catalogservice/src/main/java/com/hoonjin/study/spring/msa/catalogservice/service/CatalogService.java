package com.hoonjin.study.spring.msa.catalogservice.service;

import com.hoonjin.study.spring.msa.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
