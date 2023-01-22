package ar.servus.apiproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final String BACKEND_SERVICE_URI = "http://192.168.193.47:8080/ns/WebServer?wsdl";

    private final Logger logger = LoggerFactory.getLogger(GatewayApp.class);

    @GetMapping("/**")
    ResponseEntity<String> getController(HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(BACKEND_SERVICE_URI, HttpMethod.GET,httpEntity, String.class);
        String resultBody = result.getBody().replace("192.168.193.47:8080","127.0.0.1:9099");
        return ResponseEntity.ok().headers(result.getHeaders()).body(resultBody);
    }

    @PostMapping("/**")
    ResponseEntity<String> postController(HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(BACKEND_SERVICE_URI, HttpMethod.POST,httpEntity, String.class);
        String resultBody = result.getBody().replace("192.168.193.47:8080","127.0.0.1:9099");
        return ResponseEntity.ok().headers(result.getHeaders()).body(resultBody);
    }
}
