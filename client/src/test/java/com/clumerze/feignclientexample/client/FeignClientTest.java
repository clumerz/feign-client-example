package com.clumerze.feignclientexample.client;

import com.clumerze.feignclientexample.controller.IHelloController;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import reactivefeign.ReactiveContract;
import reactivefeign.webclient.WebReactiveFeign;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeignClientTest {

    static final String HOST = "http://localhost:8080";

    @Test
    void test() {
        var client = WebReactiveFeign.<IHelloController>builder()
                .contract(new ReactiveContract(new SpringMvcContract()))
                .target(IHelloController.class, HOST);

        var actual = client.hello("Denis").block();
        var expected = "Hello Denis!";

        assertEquals(expected, actual);
    }
}
