package Login_Exception.service;

import Login_Exception.core.exception.IdNotFoundException;
import Login_Exception.dto.UserDTO;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;

import java.util.Optional;

public class UpdateByIdService {

    private final UserRepository userRepository;

    public UpdateByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel updateById(Long id, UserDTO userDTO)
    {
        Optional<UserModel>userID=this.userRepository.findById(id);
        if(userID.isEmpty())
        {
            throw new IdNotFoundException();
        }
        UserModel userSave=userID.get();
        userDTO.updateUser(userSave);
        return userSave;
    }
}
