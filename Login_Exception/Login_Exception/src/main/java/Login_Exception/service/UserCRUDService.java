package Login_Exception.service;

import Login_Exception.core.exception.*;
import Login_Exception.dto.UserDTO;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCRUDService {

    private final UserRepository userRepository;

    public UserCRUDService(UserRepository userRepository) {
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

    public UserModel updateById(Long id, UserDTO userDTO)
    {
        //Procura de existência de ID
        Optional<UserModel> userID=this.userRepository.findById(id);
        if(userID.isEmpty())
        {
            throw new IdNotFoundException();
        }
        UserModel userSave=userID.get();
        userDTO.updateUser(userSave);
        this.userRepository.save(userSave);
        return userSave;
    }

    public UserModel getById(Long id)
    {
        //Utilização de Lambda para lançar exceção
        return this.userRepository.findById(id).orElseThrow(() -> new IdNotFoundException());
    }

    public List<UserModel> getAll()
    {
        List<UserModel> userList=this.userRepository.findAll();
        //Lançamento de exceção caso esteja vazio
        if(userList.isEmpty())
        {
            throw new EmptyListException();
        }

        return userList;
    }

    public boolean deleteById(Long id)
    {
        //Procura de existência de ID
        Optional<UserModel>userID=this.userRepository.findById(id);
        if(userID.isPresent())
        {
            UserModel userModel=userID.get();
            this.userRepository.delete(userModel);
            return true;
        }
        throw new IdNotFoundException();
    }
    public void deleteAll()
    {
        this.userRepository.deleteAll();
    }

}