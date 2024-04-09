/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author gouto
 */
public class User {
    private String email;
    private String password;
    private LocalDate dateofjoin;
    private String gender;
    private String role;
    private LocalDate passwordChangeDate;

   public User(String email, LocalDate dateofjoin, String gender, String role) {
        this.email = email;
        this.dateofjoin = dateofjoin;
        this.gender = gender;
        this.role = role;
    }
    
   public User(String email, String password, LocalDate dateofjoin, String gender, String role, LocalDate passwordChangeDate) {
        this.email = email;
        this.password = password;
        this.dateofjoin = dateofjoin;
        this.gender = gender;
        this.role = role;
        this.passwordChangeDate = passwordChangeDate;
    }

    public LocalDate getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(LocalDate passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(LocalDate dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    
}
