package com.hoonjin.study.spring.advanced.aop.exam;

import com.hoonjin.study.spring.advanced.aop.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExampleRepository exampleRepository;

    @Trace
    public void request(String itemId) {
        exampleRepository.save(itemId);
    }
}
