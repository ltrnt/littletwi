package ru.ltrnt.littletwi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ltrnt.littletwi.config.jwt.JwtProvider;
import ru.ltrnt.littletwi.entity.UserEntity;
import ru.ltrnt.littletwi.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }

    @AllArgsConstructor
    @Data
    public class AuthResponse {
        private String token;
    }

    @Data
    public class AuthRequest {
        private String login;
        private String password;
    }

    @Data
    public class RegistrationRequest {

        @NotEmpty
        private String login;

        @NotEmpty
        private String password;
    }
}
