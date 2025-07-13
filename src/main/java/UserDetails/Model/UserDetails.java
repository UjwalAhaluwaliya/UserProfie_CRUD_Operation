package UserDetails.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
public class UserDetails {
    @Id
    private int uid;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String confirmpassword;
    public UserDetails(){}
    public UserDetails(int uid,String name,String city,String username,String email,String password,String confirmpassword){
        this.uid= uid;
        this.name=name;
        this.city=city;
        this.username=username;
        this.email=email;
        this.password=password;
        this.confirmpassword=confirmpassword;

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
