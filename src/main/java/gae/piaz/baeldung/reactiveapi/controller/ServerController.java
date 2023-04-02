package gae.piaz.baeldung.reactiveapi.controller;

import java.time.Duration;
import java.util.Random;

import gae.piaz.baeldung.reactiveapi.event.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sse-server")
public class ServerController {

    @GetMapping(path = "/stream-foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> streamFlux() {
        Random r = new Random();
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> new Foo(r.nextInt(100), generateRandomAlphaNumericString()));
    }

    // https://www.baeldung.com/java-random-string
    public String generateRandomAlphaNumericString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}