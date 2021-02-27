package alkemy.domain;

import java.io.Serializable;
import java.util.TimeZone;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class Subject implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idSubject;

    private String name;
    
    @NotEmpty
    private String time;
    
    @NotEmpty
    private String professor;

    @NotNull
    private Long max_Quota;


}
