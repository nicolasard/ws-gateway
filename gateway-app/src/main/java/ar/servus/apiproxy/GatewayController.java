package ar.servus.apiproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final Logger logger = LoggerFactory.getLogger(GatewayApp.class);

    @GetMapping("/**")
    String getController() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://192.168.193.47:8080/ns/WebServer?wsdl", String.class);
        return result;
    }

    @PostMapping("/**")
    String postController(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        logger.info(json);
        return "Test";
    }
}
