package Api.NoAbras.Controller;
import Api.NoAbras.Config.JwtTokenProvider;
import Api.NoAbras.Dto.LoginRequest;
import Api.NoAbras.Model.JwtAuthenticationResponse;
import Api.NoAbras.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.*;




@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class CControllerUser {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLoginUsername(),
                        loginRequest.getLoginPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }


}
