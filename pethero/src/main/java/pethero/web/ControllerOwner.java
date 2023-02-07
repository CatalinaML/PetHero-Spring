package pethero.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pethero.domain.Owner;
import pethero.service.OwnerService;

@Controller
public class ControllerOwner {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/newOwner")
    public String newOwner(Owner owner){
        return "owner/newOwner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(Owner owner){
        ownerService.save(owner);
        return "owner/indexOwner";
    }
}
