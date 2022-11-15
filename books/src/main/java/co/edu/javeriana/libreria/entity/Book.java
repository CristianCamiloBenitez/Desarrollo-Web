// Java Program to Demonstrate Department File

// Importing package module to this code fragment
package co.edu.javeriana.libreria.entity;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "books")
// Class
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotBlank
    private String Name;
    @NotBlank
    private String Description;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String author;

    public String getName() { return this.Name;}
    public void setName(String name) { this.Name = name;}

    public String getDescription() { return this.Description;}
    public void setDescription(String description) { this.Description = description;}

    public String getImageUrl() { return this.imageUrl;}
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}

    public String getAuthor() { return this.author;}
    public void setAuthor(String author) { this.author = author;}

    public Integer getId() { return  this.Id;}
    public void setId(Integer Id) { this.Id = Id;}
}
