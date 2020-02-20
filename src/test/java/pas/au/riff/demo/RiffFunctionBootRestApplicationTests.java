package pas.au.riff.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Slf4j
class RiffFunctionBootRestApplicationTests {

    @Autowired
    private FunctionCatalog catalog;

    @Test
    public void test() throws Exception {

        Function<String, String> function = catalog.lookup(Function.class,
                "getCountryDetails");
        String response = function.apply("AU");
        log.info("Response : " + response.toString());
        assertNotNull(response);
    }
}
