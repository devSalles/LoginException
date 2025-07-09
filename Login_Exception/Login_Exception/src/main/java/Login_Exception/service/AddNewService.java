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
        if(userDTO.getEmail() == null || userDTO.getEmail().isBlank() && !userDTO.getEmail().contains("@"))
        {
            throw new EmailArgumentException();
        }

        if(userDTO.getSenha() == null || userDTO.getSenha().isBlank())
        {
            throw new SenhaArgumentException();
        }

        if(userDTO.getCpf() == null || userDTO.getCpf().isBlank())
        {
            throw new CpfArgumentException();
        }

        UserModel userSave=userDTO.toUser();
        this.userRepository.save(userSave);
        return userSave;
    }
}