package Login_Exception.service;

import Login_Exception.core.exception.IdNotFoundException;
import Login_Exception.model.UserModel;
import Login_Exception.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class GetByIdService {

    private final UserRepository userRepository;

    public GetByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getById(Long id)
    {
        return this.userRepository.findById(id).orElseThrow(() -> new IdNotFoundException());
    }
}
