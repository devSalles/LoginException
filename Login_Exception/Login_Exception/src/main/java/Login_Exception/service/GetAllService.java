package Login_Exception.service;

import Login_Exception.core.exception.EmptyListException;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllService {

    private final UserRepository userRepository;

    public GetAllService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
