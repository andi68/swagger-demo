package de.andi.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testHelloWorld() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/hello", String.class);
        assertEquals("hello world", entity.getBody());
    }

}