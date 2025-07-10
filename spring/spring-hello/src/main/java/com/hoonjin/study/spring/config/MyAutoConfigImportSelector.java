package com.hoonjin.study.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[] {
//            "com.hoonjin.study.spring.config.autoconfig.DispatcherServletConfig",
//            "com.hoonjin.study.spring.config.autoconfig.TomcatWebServerConfig",
//        };
        ImportCandidates candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//        return candidates.getCandidates().toArray(String[]::new);
        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
    }
}
