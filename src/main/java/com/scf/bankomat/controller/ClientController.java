package com.scf.bankomat.controller;

import com.scf.bankomat.model.Client;
import com.scf.bankomat.service.ClientNotFoundException;
import com.scf.bankomat.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/index")
    public String mainList() {
        return "index";
    }

    @GetMapping("/clients")
    public String showClientsList(Model model) {
        List<Client> listClients = clientService.listall();
        model.addAttribute("listClients", listClients);

        return "clients";
    }



    @GetMapping("/allclients")
    public String showAllClients(Model model) {
        List<Client> listClients = clientService.listall();
        model.addAttribute("listClients", listClients);

        return "allclients";
    }

    @GetMapping("/getbalance")
    public String getMainBalance() {
        return "getbalance";
    }

    @PutMapping("/get_balance")
    public  String getBalance(Model model, @Param("keyword") String keyword){
        List<Client> listClients = clientService.list(keyword);
        model.addAttribute("listClients", listClients);
        return "get_balance";
    }


//    @GetMapping("/moneyput")
//    public String moneyPuts() {
//        return "moneyput";
//    }
//
//    @RequestMapping("/money_put")
//    public String addMoney(Model model, @Param("amount") Integer amount, @Param("lastname") String lastname) {
//        List<Client> moneyPut = clientService.pMoney(amount, lastname);
//        model.addAttribute("moneyPut", moneyPut);
//        return "money_put";
//    }


    @GetMapping("/clients/new")
    public String showNewForm(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("pageTitle","Добавить нового клиента");
        return "client_form";
    }

@PostMapping("/clients/save")
    public String saveClient(Client client, RedirectAttributes ra){
        clientService.save(client);
        ra.addFlashAttribute("message", "Операция прошла успешно!");
        return "redirect:/index";
}

@GetMapping("/clients/edit/{id}")
public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
    try {
        Client client = clientService.get(id);
        model.addAttribute("client", client);
        model.addAttribute("pageTitle","Edit Client (ID: " + id  + ")");
        return "client_form";
    } catch (ClientNotFoundException e) {
        ra.addFlashAttribute("message", e.getMessage());
        return "redirect:/clients";
    }
}

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            clientService.delete(id);
           ra.addFlashAttribute("message", "ID клиента " + id + " был удален");
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
            return "redirect:/clients";
        }


    @GetMapping("/putmoney")
    public String mainPutMoney() {
        return "putmoney";
    }

    @GetMapping("/put_money")
    public  String put_money(Model model, @Param("keyword") String keyword){
        List<Client> listClients = clientService.list(keyword);
        model.addAttribute("listClients", listClients);
        return "put_money";
    }

    @GetMapping("/clients/putmoney/{id}")
    public String putMoneyForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Client client = clientService.get(id);
            model.addAttribute("client", client);
            model.addAttribute("pageTitle", "Положить деньги (ID: " + id + ")");
            return "client_form";
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/index";
        }
    }

    @GetMapping("/getmoney")
    public String mainGetMoney() {
        return "getmoney";
    }

    @GetMapping("/get_money")
    public  String get_money(Model model, @Param("keyword") String keyword){
        List<Client> listClients = clientService.list(keyword);
        model.addAttribute("listClients", listClients);
        return "get_money";
    }

    @GetMapping("/clients/getmoney/{id}")
    public String getMoneyForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Client client = clientService.get(id);
            model.addAttribute("client", client);
            model.addAttribute("pageTitle", "Снять деньги (ID: " + id + ")");
            return "client_form";
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/index";
        }
    }

    //через постман
    @PutMapping("updateBalance/{lastname}/{balance}")
    public String updateBalance (@PathVariable String lastname, @PathVariable Integer balance){
    return clientService.updateBalance(lastname, balance) + "allclients";
}

//перевод денег
//вычитание заданного баланса amount у донора клиента по id
    @PutMapping("transferDel/{id}/{balance}/{amounts}")
    public Integer transferDel (@PathVariable Integer id, @PathVariable Integer balance, @PathVariable Integer amounts){
        return clientService.TransferDel(id, balance, amounts);
    }
//добавление задаеннного баланса amount рецептиенту клиенту по id
    @PutMapping("transferAdd/{id}/{balance}/{amounts}")
    public Integer transferAdd (@PathVariable Integer id, @PathVariable Integer balance, @PathVariable Integer amounts){
        return clientService.TransferAdd(id, balance, amounts);
    }

}
