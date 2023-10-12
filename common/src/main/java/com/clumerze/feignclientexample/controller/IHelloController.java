package com.clumerze.feignclientexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

public interface IHelloController {

    @GetMapping("/hello/{name}")
    Mono<String> hello(@PathVariable String name);
}
