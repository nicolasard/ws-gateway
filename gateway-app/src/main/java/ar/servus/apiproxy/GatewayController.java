package ar.servus.apiproxy;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/**")
    String getController() {
        return "Test";
    }

    @PostMapping("/**")
    String postController(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        System.out.println(json);
        return "Test";
    }
}
