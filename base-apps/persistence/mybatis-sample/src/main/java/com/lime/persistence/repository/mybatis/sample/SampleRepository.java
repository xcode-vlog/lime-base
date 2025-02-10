package com.lime.persistence.repository.mybatis.sample;

import com.lime.persistence.domain.response.SampleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SampleRepository {
    private final SampleMybatisRepository sampleMybatisRepository;

    public SampleResponse getNow() {
        return sampleMybatisRepository.getNow();
    }

    public String getSample() {
        log.info("get sample");
        return sampleMybatisRepository.getSample();
    }
}
