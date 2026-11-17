package soa.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GatewayService {

    DiscoveryClient DC;
    RestTemplate RT;

    public GatewayService(DiscoveryClient DC) {
        this.DC = DC;
        this.RT = new RestTemplate();
    }

    private String getBookServiceUrl() {

        List<ServiceInstance> instance = DC.getInstances("library");

        if (instance.isEmpty()) {
            throw new RuntimeException("library-Service is not available");
        }

        return instance.get(0).getUri().toString();
    }

    public ResponseEntity<String> addBook(String requestBody) {

        String url = getBookServiceUrl() + "/api/books";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<>(requestBody, headers);

        return RT.exchange(
                url,
                HttpMethod.POST,
                request,
                String.class
        );
    }

    public ResponseEntity<String> deleteBook(Long id) {

        String url = getBookServiceUrl() + "/api/books/" + id;

        return RT.exchange(
                url,
                HttpMethod.DELETE,
                null,
                String.class
        );
    }

   
    public ResponseEntity<String> updateBook(Long id, String requestBody) {

        String url = getBookServiceUrl() + "/api/books/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<>(requestBody, headers);

        return RT.exchange(
                url,
                HttpMethod.PUT,
                request,
                String.class
        );
    }

   
    public ResponseEntity<String> getAllBooks() {

        String url = getBookServiceUrl() + "/api/books";

        return RT.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
    }

  
    public ResponseEntity<String> getBookById(Long id) {

        String url = getBookServiceUrl() + "/api/books/" + id;

        return RT.exchange(
                url,
                HttpMethod.GET,
                null,
                String.class
        );
    }
}