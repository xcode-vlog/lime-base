package com.lime.presentation.controller;

import com.lime.application.sample.SampleService;
import com.lime.common.utils.LimeStringUtils;
import com.lime.converter.model.response.SamplePresentationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/api/v1/sample")
    public String sample() {
        return "sample";
    }

    @GetMapping("/api/v1/hello-world")
    public String helloWorld() {
        String helloWorld = LimeStringUtils.emptyToDefault("", "hello world");

        return helloWorld;
    }

    @GetMapping("/api/v1/now")
    public SamplePresentationResponse now() {
        return sampleService.now();
    }

    @GetMapping("/api/v1/get-sample")
    public String getSample() {
        return sampleService.getSample();
    }
}
