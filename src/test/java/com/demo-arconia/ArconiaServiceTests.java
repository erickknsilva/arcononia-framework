package com.teste.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ArconiaServiceTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createBook(){
        webTestClient
                .post()
                .uri("/books")
                .bodyValue(new com.teste.demo.Book(null, "The decameron"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(com.teste.demo.Book.class)
                .value(book -> {
                    assertThat(book.id()).isNotNull();
                    assertThat(book.title()).isEqualTo("The decameron");
                });

    }
}

