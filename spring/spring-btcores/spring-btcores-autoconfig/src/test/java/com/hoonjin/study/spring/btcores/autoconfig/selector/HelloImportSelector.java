package com.hoonjin.study.spring.btcores.autoconfig.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.hoonjin.study.spring.btcores.autoconfig.selector.HelloConfig"};
//        return new String[]{};
    }
}
