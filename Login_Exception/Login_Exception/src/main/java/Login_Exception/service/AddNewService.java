package Login_Exception.service;

import Login_Exception.core.exception.CpfArgumentException;
import Login_Exception.core.exception.EmailArgumentException;
import Login_Exception.core.exception.SenhaArgumentException;
import Login_Exception.dto.UserDTO;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddNewService {

    private final UserRepository userRepository;

    public AddNewService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel addNew(UserDTO userDTO)
    {
        //Utilização de REGEX para verificar email
        if(userDTO.getEmail() == null || userDTO.getEmail().isBlank() || !userDTO.getEmail().matches(".*@.*\\..*"))
        {
            //Usado para DEBUG
            System.out.println("Email inválido");
            throw new EmailArgumentException();
        }

        if(userDTO.getSenha() == null || userDTO.getSenha().isBlank())
        {
            //Usado para DEBUG
            System.out.println("Senha inválida");
            throw new SenhaArgumentException();
        }

        //Utilização de REGEX para verificar CPF
        if(userDTO.getCpf() == null || userDTO.getCpf().isBlank() || !userDTO.getCpf().matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"))
        {
            //Usado para DEBUG
            System.out.println("CPF inválido");
            throw new CpfArgumentException();
        }

        UserModel userSave=userDTO.toUser();
        this.userRepository.save(userSave);
        return userSave;
    }
}