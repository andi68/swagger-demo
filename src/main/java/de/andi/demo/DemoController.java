package de.andi.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import de.andi.demo.model.Hello;

@RestController
public class DemoController {

    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping(value = "/hello/{name}")
    public ResponseEntity<Hello> createOrUpdateHelloWorld(
        @PathVariable(value = "name") String name
    ) {
        Hello hello = new Hello("hello " + name);
        return ResponseEntity.ok(hello);
    }

}
