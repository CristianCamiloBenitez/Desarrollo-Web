package co.edu.javeriana.libreria.entity;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "users")
// Class
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    public Integer getId() {return this.id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
}
