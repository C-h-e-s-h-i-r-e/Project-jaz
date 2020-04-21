package pl.edu.pjwstk.jaz.user;

import pl.edu.pjwstk.jaz.auction.AuctionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "uzytkownik")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Id
    private String username;
    private String password;
    private String email;
    @Column(name="birthdate")
    private LocalDate birthDate;
    private Boolean isAdmin;

    User(){super();}

    public User(String firstName, String lastName, String username, String password, String email, LocalDate birthDate, Boolean isAdmin) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
    }

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<AuctionEntity> auctions;


    public Integer getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<AuctionEntity> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<AuctionEntity> auctions) {
        this.auctions = auctions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
