package com.scf.bankomat;

import com.scf.bankomat.model.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.scf.bankomat.repository.ClientRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class ClientRepositoryTests {
@Autowired  ClientRepository  repo  ;
@Test
public void testAddNew(){
    Client client = new Client();
    client.setFirstname("Bereke");
    client.setLastname("May");
    client.setBalance(100);

    Client savedClient = repo.save(client);

    Assertions.assertThat(savedClient).isNotNull();
    Assertions.assertThat(savedClient.getId()).isGreaterThan(0);


}
}
