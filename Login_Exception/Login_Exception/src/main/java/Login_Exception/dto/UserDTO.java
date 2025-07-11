package Login_Exception.dto;

import Login_Exception.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Senha obrigatório") @Size(min = 6, max = 18)
    private String senha;

    @CPF @NotBlank(message = "CPF obrigatório")
    private String cpf;


    public UserModel toUser()
    {
        UserModel userModel = new UserModel();

        userModel.setNome(this.nome);
        userModel.setEmail(this.email);
        userModel.setSenha(this.senha);
        userModel.setCpf(this.cpf);

        return userModel;
    }

    public UserModel updateUser(UserModel userModel)
    {
        userModel.setNome(this.getNome());
        userModel.setEmail(this.getEmail());
        userModel.setSenha(this.getSenha());
        userModel.setCpf(this.getCpf());

        return userModel;
    }
}
