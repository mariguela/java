package leo.repository;

import leo.domain.Contato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mariguela on 10/05/17.
 */
@Repository
public interface ContatoRepository extends CrudRepository<Contato, Integer> {

    List<Contato> findByNome(String nome);
}