package Login_Exception.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String nome;

    @Email @NotBlank(message = "Email obrigatório")
    private String email;

    @NotNull(message = "Senha obrigatório") @Size(min = 6, max = 18)
    private String senha;

    @CPF @NotNull(message = "Senha obrigatório")
    private String cpf;
}
