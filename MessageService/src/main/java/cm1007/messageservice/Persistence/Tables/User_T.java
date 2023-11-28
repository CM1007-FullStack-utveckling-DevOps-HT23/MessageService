package cm1007.messageservice.Persistence.Tables;

import fs.cm1007.patientspring.enumerations.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User_T") //Used if the class name is changed
public class User_T {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter @Setter
    @Column(name = "u_name")
    private String uName;

    @Getter @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Role role;

    @Getter @Setter
    @Column(name = "full_name")
    private String fullName;

    @OneToMany
    @JoinColumn(name = "id")
    @Getter @Setter
    private List<Message_T> messagesSource = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id")
    @Getter @Setter
    private List<Message_T> messagesTarget = new ArrayList<>();

    //Necessary when using JPA
    public User_T() {
    }

    //Constructor that is used. ID is a generated value.
    public User_T(String uName, String password, Role role, String fullName) {
        this.uName = uName;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }

}
