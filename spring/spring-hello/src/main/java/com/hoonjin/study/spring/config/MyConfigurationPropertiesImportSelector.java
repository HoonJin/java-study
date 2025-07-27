package com.hoonjin.study.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class MyConfigurationPropertiesImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());

        Class propertyClass = (Class) allAnnotationAttributes.getFirst("value");
        return new String[] { propertyClass.getName() };
    }
}
