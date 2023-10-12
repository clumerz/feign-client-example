package com.clumerze.feignclientexample.client;

import com.clumerze.feignclientexample.controller.IHelloController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import reactivefeign.ReactiveContract;
import reactivefeign.client.log.DefaultReactiveLogger;
import reactivefeign.webclient.WebReactiveFeign;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeignClientTest {

    static final String HOST = "http://localhost:8080";
    static final Logger logger = LoggerFactory.getLogger(FeignClientTest.class);

    @Test
    void test() {

        var client = WebReactiveFeign.<IHelloController>builder()
                .contract(new ReactiveContract(new SpringMvcContract()))
                .addLoggerListener(new DefaultReactiveLogger(Clock.systemUTC(), logger))
                .target(IHelloController.class, HOST);

        var actual = client.hello("Denis").block();

        logger.info(actual);

        var expected = "Hello Denis!";

        assertEquals(expected, actual);
    }
}
