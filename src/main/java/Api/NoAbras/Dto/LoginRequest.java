package Api.NoAbras.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class LoginRequest {

    @NotBlank
    private String loginUsername;
    @NotBlank
    private String loginPassword;
}

