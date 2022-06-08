package com.scf.bankomat.service;

import com.scf.bankomat.model.Client;
import com.scf.bankomat.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public List<Client> listall() {
        return clientRepository.findAll();
    }

    public List<Client> list(String keyword){
        if (keyword !=null) {
            return clientRepository.findAll(keyword);
        }
        return clientRepository.findAll();
    }

//    public List<Client> pMoney(Integer amount, String lastname) {
//        Scanner scanner = new Scanner(System.in);
//        amount = scanner.nextInt();
//        return  clientRepository.putMoney(amount, lastname);
//    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client get(Integer id) throws ClientNotFoundException {
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ClientNotFoundException("Не найден клиент с таким ID" +id);
    }

    public void delete(Integer id) throws ClientNotFoundException {
        Long count = clientRepository.countById(id);
        if (count == null || count == 0){
            throw new ClientNotFoundException("Не найден клиент с таким ID" +id);
        }

        clientRepository.deleteById(id);
    }




    public Integer addMoney(Integer to, Integer amounts) {
        return null;
    }

    public Integer updateBalance (String lastname, Integer balance){
        return clientRepository.updateBalance(lastname, balance);
    }

    public int TransferDel (Integer id, Integer balance, Integer amounts){
        return clientRepository.TransferDel(id, balance, amounts);
    }

    public Integer TransferAdd (Integer id, Integer balance, Integer amounts){
        return clientRepository.TransferAdd(id, balance, amounts);
    }



}