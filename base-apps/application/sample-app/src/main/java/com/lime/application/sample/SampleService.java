package com.lime.application.sample;

import com.lime.converter.SampleConverter;
import com.lime.converter.model.response.SamplePresentationResponse;
import com.lime.persistence.domain.response.SampleResponse;
import com.lime.persistence.repository.mybatis.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    public SamplePresentationResponse now() {
        SampleResponse now = sampleRepository.getNow();

        return SampleConverter.toDomain(now, SamplePresentationResponse.class);
    }

    public String getSample() {
        return sampleRepository.getSample();
    }
}
