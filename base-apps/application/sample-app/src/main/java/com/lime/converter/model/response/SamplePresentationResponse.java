package com.lime.converter.model.response;

import com.lime.persistence.domain.response.SampleResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SamplePresentationResponse {
    private String text;

    public static SamplePresentationResponse from(SampleResponse sampleResponse) {
        return SamplePresentationResponse.builder()
                .text(sampleResponse.getNow().toString())
                .build();
    }
}
