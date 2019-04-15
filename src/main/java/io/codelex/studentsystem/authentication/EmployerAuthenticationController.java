package io.codelex.studentsystem.authentication;

import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.api.requests.SignIn;
import io.codelex.studentsystem.service.EmployerService;
import org.json.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class EmployerAuthenticationController {
    private final AuthenticationService authService;
    private final EmployerService employerService;

    public EmployerAuthenticationController(AuthenticationService authService, EmployerService employerService) {
        this.authService = authService;
        this.employerService = employerService;
    }

    @PostMapping("/sign-out")
    public void signOut() {
        authService.clearAuthentication();
    }

    @GetMapping("/account")
    public String account(Principal principal) {
        return principal.getName();
    }

    @PutMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AddEmployer request) throws JSONException {
        try {
            employerService.addEmployer(request);
        } catch (IllegalStateException e) {
            if (e.getMessage().equals("this email already exists")) {
                return jsonResponse(e.getMessage(), HttpStatus.OK);
            } else if (e.getMessage().equals("this login already exists")) {
                return jsonResponse(e.getMessage(), HttpStatus.OK);
            }
            return getResponse("unable to register", HttpStatus.OK);
        }
        authService.authorise(request.getLogin());
        return jsonResponse(request.getLogin() + " is registered", HttpStatus.CREATED);
    }

    @PutMapping("/sign-in")
    public ResponseEntity<String> signIn(@Valid @RequestBody SignIn request) throws JSONException {
        if (employerService.isSignInIsValid(request)) {
            authService.authorise(request.getLogin());
            return jsonResponse(request.getLogin() + " signed in", HttpStatus.OK);
        } else {
            return jsonResponse("Unable to sign in. Check you login or password", HttpStatus.OK);
        }
    }

    private ResponseEntity<String> jsonResponse(String message, HttpStatus ok) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("message", message);
        return new ResponseEntity<>(obj.toString(), ok);
    }

    private ResponseEntity<String> getResponse(String s, HttpStatus ok) throws JSONException {
        return jsonResponse(s, ok);
    }
}
