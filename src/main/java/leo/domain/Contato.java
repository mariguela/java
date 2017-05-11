package leo.domain;

import lombok.*;

import javax.persistence.*;


/**
 * Created by netshoes on 10/05/17.
 */
@Data
@Table
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String email;
}
