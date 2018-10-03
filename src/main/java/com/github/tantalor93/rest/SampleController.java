package com.github.tantalor93.rest;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final Counter counter = Metrics.counter("sample.controller.requests");
    
    @GetMapping
    public ResponseEntity<String> sampleEndpoint() {
        counter.increment();
        return ResponseEntity.ok("sample output");
    }
}
