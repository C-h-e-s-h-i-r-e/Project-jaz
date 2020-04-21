package pl.edu.pjwstk.jaz.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.*;

@Named
@RequestScoped
public class RegisterRequest {
    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp="^[a-zA-Z0-9\\s]*$")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50, message = "Last Name must be between 3 and 50 characters")
    @Pattern(regexp="^[a-zA-Z0-9\\s]*$")
    private String lastName;
    @NotNull
    @Pattern(regexp="^[a-z0-9\\s]*$")
    private String username;
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(.{5,30})")
    private String password;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
