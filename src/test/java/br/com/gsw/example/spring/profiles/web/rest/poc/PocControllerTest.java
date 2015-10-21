package br.com.gsw.example.spring.profiles.web.rest.poc;

import br.com.gsw.example.spring.profiles.poc.domain.Poc;
import br.com.gsw.example.spring.profiles.web.config.WebApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("integration-test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PocControllerTest {

    private RestTemplate rest;

    @Value("${local.server.port}")
    private int port;

    private static String URL;
    private static Long POC_ID;

    @Before
    public void setUp() throws Exception {
        URL = new URL("http://localhost:" + port + "/poc/").toString();
        rest = new TestRestTemplate();
    }

    @Test
    public void test01_postTest() {
        Poc poc = new Poc("Post Test");

        ResponseEntity<Long> response = rest.postForEntity(URL, poc, Long.class);
        POC_ID = response.getBody();

        assertNotNull(POC_ID);
    }

    @Test
    public void test02_getIdTest() {
        ResponseEntity<Poc> response = rest.getForEntity(URL+POC_ID, Poc.class);
        HttpStatus status = response.getStatusCode();
        Poc poc = response.getBody();

        assertEquals(HttpStatus.OK, status);
        assertEquals(POC_ID, poc.getId());
    }

    @Test
    public void test03_getAllTest() {
        ResponseEntity<Poc[]> response = rest.getForEntity(URL, Poc[].class);
        HttpStatus status = response.getStatusCode();
        List<Poc> pocs = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.OK, status);
        assertEquals(1, pocs.size());
    }

}