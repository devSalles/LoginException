package Login_Exception.controller;

import Login_Exception.model.UserModel;
import Login_Exception.service.GetByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class GetByIdController {

    private final GetByIdService getByIdService;

    public GetByIdController(GetByIdService getByIdService) {
        this.getByIdService = getByIdService;
    }

    @GetMapping("/destaque/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id)
    {
        UserModel userModel = this.getByIdService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }
}
