package Login_Exception.controller;

import Login_Exception.service.AddNewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddNewController {

    private final AddNewService addNewService;

    public AddNewController(AddNewService addNewService) {
        this.addNewService = addNewService;
    }
}
