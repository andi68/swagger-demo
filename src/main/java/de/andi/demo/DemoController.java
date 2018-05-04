package de.andi.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping(value = "/hello/{name}")
    public ResponseEntity<HelloDto> createOrUpdateHelloWorld(
        @PathVariable(value = "name") String name
    ) {
        //return ResponseEntity.ok("hello world " + name);

        HelloDto helloDto = new HelloDto();
        helloDto.name = "hello " + name;
        return ResponseEntity.ok(helloDto);
    }

    public class HelloDto {

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
