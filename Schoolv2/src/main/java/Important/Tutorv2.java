package Important;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tutorv2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String staffID;
    private String name;
    private int salary;
    @OneToMany
    @JoinColumn(name="TUTOR_FK")
    private Set<Studentv2> supervisionGroup;
    public Tutorv2() {
    }

    public int getSalary() {
        return salary;
    }

    public Set<Studentv2> getSupervisionGroup() {
        return supervisionGroup;
    }

    public void setSupervisionGroup(Set<Studentv2> supervisionGroup) {
        this.supervisionGroup = supervisionGroup;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffID() {

        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tutorv2(String staffID, String name, int salary) {
        this.staffID = staffID;
        this.name = name;
        this.salary = salary;
    }
}