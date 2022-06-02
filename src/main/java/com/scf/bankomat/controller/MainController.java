package com.scf.bankomat.controller;

import com.scf.bankomat.model.Client;
import com.scf.bankomat.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("")
    public String showMainList(){
        System.out.println("main controller");
        return "index";
    }



//    @GetMapping("/clients")
//    public String showClients(Model model){
//        List<Client> listClients =
//    }

}
