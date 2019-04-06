package io.codelex.studentsystem.authentication;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
class EmployerController {
    private final AuthenticationService authService;

    EmployerController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public void signIn(@RequestParam("email") String email) {
        authService.authorise(email);
    }

    @PostMapping("/register")
    public void register(@RequestParam("email") String email) {
        authService.authorise(email);
    }

    @PostMapping("/sign-out")
    public void signOut() {
        authService.clearAuthentication();
    }

    @GetMapping("/account")
    public String account(Principal principal) {
        return principal.getName();
    }

}
