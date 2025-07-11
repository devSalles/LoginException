package Login_Exception.service;

import Login_Exception.core.exception.IdNotFoundException;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteByIdService {

    private final UserRepository userRepository;

    public DeleteByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean deleteById(Long id)
    {
        Optional<UserModel>userID=this.userRepository.findById(id);
        if(userID.isPresent())
        {
            UserModel userModel=userID.get();
            this.userRepository.delete(userModel);
            return true;
        }
        throw new IdNotFoundException();
    }
}
