package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {
    private final DemoTableRepository demoTableRepository;

    public DemoController(DemoTableRepository demoTableRepository) {
        this.demoTableRepository = demoTableRepository;
    }

    @GetMapping
    public List<DemoTable> findAll() {
        return demoTableRepository.findAll();
    }
}
