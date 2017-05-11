package leoTestes;

import leo.domain.Contato;
import leo.repository.ContatoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by netshoes on 11/05/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApplicationTests.class)
@SpringBootApplication
@ComponentScan("leo")
//@EntityScan("leo.domain")
//@EnableJpaRepositories("leo.repository")
public class MyApplicationTests {


    @Autowired
    ContatoRepository contatoRepository;

    @Test
    public void testLoadContato() {
        List<Contato> contatos = (ArrayList<Contato>) contatoRepository.findAll();
        assertEquals("Load", 1, contatos.size());
    }

    @Test
    public void testGetContato() {
        List<Contato> contatos = (ArrayList<Contato>) contatoRepository.findAll();
        Contato contato = contatoRepository.findOne(contatos.get(0).getId());
        assertNotNull("GET", contato);
    }
}
