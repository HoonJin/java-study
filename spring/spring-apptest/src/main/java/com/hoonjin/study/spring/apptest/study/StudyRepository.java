package com.hoonjin.study.spring.apptest.study;

import com.hoonjin.study.spring.apptest.domain.Study;

public interface StudyRepository {

    Study save(Study study);
}
