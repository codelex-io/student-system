package io.codelex.studentsystem.authentication;

import io.codelex.studentsystem.api.requests.AddEmployer;
import io.codelex.studentsystem.api.requests.SignIn;
import io.codelex.studentsystem.repository.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public
class EmployerAuthenticationController {
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
    public ResponseEntity<String> register(@RequestBody AddEmployer request) {
        try {
            employerService.addEmployer(request);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>("Unable to register", HttpStatus.OK);
        }
        authService.authorise(request.getLogin());
        return new ResponseEntity<>(request.getLogin() + " is registered", HttpStatus.CREATED);
    }

    @PutMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody SignIn request) {
        if (employerService.isSignInIsValid(request)) {
            authService.authorise(request.getLogin());
            return new ResponseEntity<>(request.getLogin() + " signed in", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to sign in", HttpStatus.OK);
        }
    }


}
