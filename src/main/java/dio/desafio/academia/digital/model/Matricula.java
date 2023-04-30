package dio.desafio.academia.digital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
