package cm1007.messageservice.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient_T {

    //Instead of autogenerated it's set when a new patient user is set
    @Id
    @Getter @Setter
    private long id;

    @Getter @Setter
    @Column(name = "full_name")
    private String fullName;

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Note_T> notes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Encounter_T> encounters = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Condition_T> conditions = new ArrayList<>();

    public Patient_T() {
    }

    public Patient_T(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
