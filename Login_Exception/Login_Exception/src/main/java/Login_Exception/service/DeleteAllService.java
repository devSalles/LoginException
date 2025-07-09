package Login_Exception.service;

import Login_Exception.repository.UserRepository;
import org.springframework.http.ResponseEntity;

public class DeleteAllService {

    private final UserRepository userRepository;

    public DeleteAllService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteAll()
    {
        this.userRepository.deleteAll();
    }
}
