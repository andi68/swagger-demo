package de.andi.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import de.andi.demo.model.Hello;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetHelloWorld() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/hello", String.class);
        assertEquals("hello world", entity.getBody());
    }

    @Test
    public void testPostHelloWorld() {
        URI uri = URI.create("/hello/andi");
        HttpEntity<Hello> entity = restTemplate.postForEntity(uri, new Hello(), Hello.class);
        assertEquals(HttpStatus.OK, ((ResponseEntity<Hello>) entity).getStatusCode());
        assertEquals("application/json;charset=UTF-8", entity.getHeaders().get("Content-Type").get(0));
        assertTrue(Hello.class.isInstance(entity.getBody()));
        assertEquals("hello andi", entity.getBody().getName());
    }

    @Test
    public void testPostHelloWorldJson() {
        URI uri = URI.create("/hello/andi");
        HttpEntity<String> entity = restTemplate.postForEntity(uri, new Hello(), String.class);
        assertEquals(HttpStatus.OK, ((ResponseEntity<String>) entity).getStatusCode());
        assertEquals("application/json;charset=UTF-8", entity.getHeaders().get("Content-Type").get(0));
        assertTrue(String.class.isInstance(entity.getBody()));
        assertEquals("{\"name\":\"hello andi\"}", entity.getBody());
    }

}