package co.edu.javeriana.libreria.entity;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "users")
// Class
public class User {

    @Id
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String role;
    @NotBlank
    private String activated;

    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() {return this.role;}
    public void setRole(String role) {this.role = role;}

    public String getActivated() { return this.activated;}
    public void setActivated(String activated) {this.activated = activated;}
}
