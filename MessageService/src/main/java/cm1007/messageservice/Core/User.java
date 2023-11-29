package cm1007.messageservice.Core;

import cm1007.messageservice.enumerations.Role;
import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    public Long id;

    @Getter @Setter
    public String uName;

    @Getter @Setter
    public String password;

    @Getter @Setter
    public Role role;

    @Getter @Setter
    public String fullName;

    public User(){
    }

    //For getting a user
    public User(long id, Role role, String fullName){
        this.id = id;
        this.role = role;
        this.fullName = fullName;
    }

    //For creating a user
    public User(String uName, String password, Role role, String fullName){
        this.uName = uName;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }
}
