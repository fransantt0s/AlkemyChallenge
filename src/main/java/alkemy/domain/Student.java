package alkemy.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name="student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idStudent;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    private Long fileNumber;
    private Long dni;




}
