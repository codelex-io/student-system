package io.codelex.studentsystem.repository.securityAuthenticationTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpEntity.EMPTY;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SecurityTests {
    @Autowired
    TestRestTemplate restTemplate;

    static final String login = "dev@codelex.io";
    static final String password = "Password123";

    @Test
    public void customer_account_should_be_secured_by_default() {
        ResponseEntity<String> result = restTemplate.getForEntity("/api/account", String.class);
        assertEquals(FORBIDDEN, result.getStatusCode());
    }

    @Test
    public void customer_should_be_authorised_on_registration() {
        ResponseEntity<Void> result = register();
        assertEquals(OK, result.getStatusCode());

        String sessionId = sessionId(result);
        assertEquals(OK, accessAccount(sessionId).getStatusCode());
    }

    @Test
    public void customer_should_be_authorised_on_sign_in() {
        ResponseEntity<Void> result = register();
        assertEquals(OK, result.getStatusCode());

        result = signIn();
        assertEquals(OK, result.getStatusCode());

        String sessionId = sessionId(result);
        assertEquals(OK, accessAccount(sessionId).getStatusCode());
    }

    @Test
    public void customer_should_be_able_to_sign_out() {
        ResponseEntity<Void> result = register();
        assertEquals(OK, result.getStatusCode());

        String sessionId = sessionId(result);

        result = signOut(sessionId);
        assertEquals(OK, result.getStatusCode());

        assertEquals(FORBIDDEN, accessAccount(sessionId).getStatusCode());
    }

    @Test
    public void customer_should_be_able_to_get_account_details() {
        ResponseEntity<Void> result = register();
        assertEquals(OK, result.getStatusCode());

        String sessionId = sessionId(result);
        assertEquals(login, accessAccount(sessionId).getBody());
    }

    private ResponseEntity<Void> register() {
        URI uri = fromPath("/api/register")
                .queryParam("login", login)
                .queryParam("password", password)
                .build()
                .toUri();

        return restTemplate.postForEntity(uri, EMPTY, Void.class);
    }

    private ResponseEntity<Void> signIn() {
        URI uri = fromPath("/api/sign-in")
                .queryParam("login", login)
                .queryParam("password", password)
                .build()
                .toUri();

        return restTemplate.postForEntity(uri, EMPTY, Void.class);
    }

    private ResponseEntity<Void> signOut(String sessionId) {
        return restTemplate.exchange("/api/sign-out", POST, request(sessionId), Void.class);
    }

    private ResponseEntity<String> accessAccount(String sessionId) {
        return restTemplate.exchange("/api/account", GET, request(sessionId), String.class);
    }

    private String sessionId(ResponseEntity<?> result) {
        return result.getHeaders().getFirst("Set-Cookie");
    }

    private HttpEntity<?> request(String sessionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", sessionId);
        return new HttpEntity<>(headers);
    }
}