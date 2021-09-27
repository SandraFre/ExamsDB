package lt.codeacademy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    String adminName;
    String adminPassword;

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
}
