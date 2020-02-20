package pas.au.riff.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class RiffFunctionBootRestApplication {

    private RestTemplate restTemplate = new RestTemplate();

    private String url = "https://restcountries.eu/rest/v2/alpha/%s";

    public static void main(String[] args) {
        SpringApplication.run(RiffFunctionBootRestApplication.class, args);
    }

    @Bean
    public Function<String, String> getCountryDetails() {
        return code -> {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(String.format(url, code), String.class);
            return response.getBody();
        };
    }
}
