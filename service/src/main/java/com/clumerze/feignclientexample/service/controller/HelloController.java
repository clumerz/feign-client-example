package com.clumerze.feignclientexample.service.controller;

import com.clumerze.feignclientexample.controller.IHelloController;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController implements IHelloController {
    @Override
    public Mono<String> hello(String name) {
        return Mono.just("Hello %s!".formatted(name));
    }
}
