package leo.controller;

import leo.domain.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import leo.repository.ContatoRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by netshoes on 10/05/17.
 */
@RestController
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;

// Com o uso do actuator (dependencia do Maven), ele ja cria o /helth e verifica tanto o serviço qto suas dependencias (MySQL, Mongo, Rabbit, etc.)
// @RequestMapping("/helth")
//    public String helth(){
//        return "OK \n" + LocalDateTime.now();
//    }

    @RequestMapping("/contato/list")
    public List<Contato> list(){
         List<Contato> contatos = (ArrayList<Contato>) contatoRepository.findAll();
         return contatos;
    }

    @RequestMapping(value = "/contato/{contatoId}", method = RequestMethod.GET)
    public Contato read(@PathVariable Integer contatoId){
        return contatoRepository.findOne(contatoId);

    }

    @RequestMapping(value = "/contato/cadastrar", method = RequestMethod.POST)
    public void cadastrar(@RequestBody Contato input){
        contatoRepository.save(input);
    }

}
