package alkemy.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table (name="professor")
public class Professor  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProfessor;

    private String name;

    private String lastName;

    @NotNull
    private Long active;

    @NotNull
    private Long dni;





}
