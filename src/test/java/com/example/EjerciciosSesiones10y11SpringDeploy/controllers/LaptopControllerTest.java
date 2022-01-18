package com.example.EjerciciosSesiones10y11SpringDeploy.controllers;

import com.example.EjerciciosSesiones10y11SpringDeploy.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    void setUp() {
        restTemplateBuilder=restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate=new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findLaptops() {
        ResponseEntity<Laptop[]> response=testRestTemplate.getForEntity("/api/laptops",Laptop[].class);

        assertEquals(200,response.getStatusCodeValue());
        assertEquals(HttpStatus.OK,response.getStatusCode());

        List<Laptop> laptops= Arrays.asList(response.getBody());
        System.out.println(laptops.size());//Da 0 porque no hemos hecho ninguna peticion y no hemos añadido laptops
    }

    @Test
    void findOneLaptopById_WithoutId() {

        //ResponseEntity<Laptop> response=testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
        //assertEquals(HttpStatus.OK,response.getStatusCode());
        //assertEquals(200,response.getStatusCodeValue());

        //ResponseEntity<Laptop> response1=testRestTemplate.getForEntity("/api/laptops/-1",Laptop.class);
       // assertEquals(HttpStatus.BAD_REQUEST,response1.getStatusCode());
        //assertEquals(400,response1.getStatusCodeValue());

        ResponseEntity<Laptop> response2=testRestTemplate.getForEntity("/api/laptops/1000",Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND,response2.getStatusCode());
        assertEquals(404,response2.getStatusCodeValue());

    }

    @Test
    void createLaptop() {

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                      {
                        "brand": "Asus",
                        "cpu": "i3",
                        "ram": 4,
                        "hardDisk": 256,
                        "screen": 15.6,
                        "price": 299.99,
                        "oled": false
                      }
                     """;
        HttpEntity<String> request=new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);

        Laptop laptopResult=response.getBody();

        assertEquals("Asus",laptopResult.getBrand());
        assertEquals("i3",laptopResult.getCpu());

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    void updateLaptop() {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        /*String json= """
                      {
                        "id":4,
                        "brand": "Asus",
                        "cpu": "i7",
                        "ram": 16,
                        "hardDisk": 256,
                        "screen": 15.6,
                        "price": 1299.99,
                        "oled": false
                      }
                     """;
        HttpEntity<String> request=new HttpEntity<>(json,headers);
        ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops",HttpMethod.PUT,request,Laptop.class);

        Laptop laptopResult=response.getBody();

        assertEquals("Asus",laptopResult.getBrand());
        assertEquals("i7",laptopResult.getCpu());

        assertEquals(200,response.getStatusCodeValue());
        assertEquals(HttpStatus.OK,response.getStatusCode());*/

        String json2= """
                      {
                        "id":4,,,,,,,,,,,,,,,,,,,,,,,
                        "brand": "Asus",
                        "cpu": "i7",
                        "ram": 16,
                        "hardDisk": 256,
                        "screen": 15.6,
                        "price": 1299.99,
                        "oled": false
                      }
                     """;
        HttpEntity<String> request2=new HttpEntity<>(json2,headers);
        ResponseEntity<Laptop> response2=testRestTemplate.exchange("/api/laptops",HttpMethod.PUT,request2,Laptop.class);

        assertEquals(HttpStatus.BAD_REQUEST,response2.getStatusCode());

    }

    @Test
    void deleteLaptop() {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json= """
                      {
                        "id":4,
                        "brand": "Asus",
                        "cpu": "i7",
                        "ram": 16,
                        "hardDisk": 256,
                        "screen": 15.6,
                        "price": 1299.99,
                        "oled": false
                      }
                     """;
        HttpEntity<String> request=new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops/5",HttpMethod.DELETE,request,Laptop.class);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());


    }

    @Test
    void deleteAll() {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> request=new HttpEntity<>(headers);

        ResponseEntity<Laptop[]> response=testRestTemplate.exchange("/api/laptops",HttpMethod.DELETE,request,Laptop[].class);

        assertEquals(204,response.getStatusCodeValue());
        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());

        testRestTemplate.delete("/api/laptops");

    }
}