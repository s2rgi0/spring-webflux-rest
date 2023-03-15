package guru.springframework.spring5webfluxrest.controller;

import guru.springframework.spring5webfluxrest.domian.Category;
import guru.springframework.spring5webfluxrest.domian.Vendor;
import guru.springframework.spring5webfluxrest.repository.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

public class VendorControllerTest {

    WebTestClient webTestClient;
    VendorRepository vendorRepository;
    VendorController vendorController;

    @Before
    public void setUp() throws Exception {

        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();

    }

    @Test
    public void list() {

        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(Vendor.builder().firstName("fred").lastName("flinstone").build(),
                        Vendor.builder().firstName("Barney").lastName("Rubble").build()));

        webTestClient.get()
                .uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getById() {

        BDDMockito.given(vendorRepository.findById("someId"))
                .willReturn(Mono.just(Vendor.builder().firstName("Jimmy").lastName("Johs").build()));

        webTestClient.get()
                .uri("/api/v1/vendors/someId")
                .exchange()
                .expectBody(Category.class);

    }
}