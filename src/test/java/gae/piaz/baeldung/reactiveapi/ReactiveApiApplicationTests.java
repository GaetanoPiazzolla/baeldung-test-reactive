package gae.piaz.baeldung.reactiveapi;

import gae.piaz.baeldung.reactiveapi.event.Foo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = ReactiveApiApplication.class)
public class ReactiveApiApplicationTests {

    private final WebTestClient client = WebTestClient.bindToServer()
        .baseUrl("http://localhost:8080/sse-server")
            .defaultHeader("produces",MediaType.TEXT_EVENT_STREAM_VALUE)
        .build();

    @Test
    public void whenSSEEndpointIsCalled_thenEventStreamingBegins() throws Throwable {

        Executable sseStreamingCall = () -> client.get()
            .uri("/stream-foo")
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
            .expectBody(Foo.class);

        sseStreamingCall.execute();
    }

}