package Important;


import javax.persistence.*;

@Entity
@Table(name="tbl_studentv2")
public class Studentv2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbID;
    private String enrollmentID;
    private String name;
    private String tutorName;
    @Column(name="NUM_COURSES")
    private Integer NumberOfCourses;
    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutorv2 tutor;


    public void setTutor(Tutorv2 tutor) {
        this.tutor = tutor;
        this.tutor.getSupervisionGroup().add(this);
    }

    public Tutorv2 getTutor() {
        return tutor;
    }

    public Integer getNumberOfCourses() {
        return NumberOfCourses;
    }


    public void setTutorName() {
        this.tutorName = tutor.getName();
    }

    // public String getTutorName(){
    //    return tutor.getName();
    //}

    public void setNumberOfCourses(Integer numberOfCourses) {
        NumberOfCourses = numberOfCourses;
    }
    public Studentv2(String name)
    {
        this.name=name;
    }
    public Studentv2(String enrollmentID, String name, String tutorName,Integer NumberOfCourses) {
        this.enrollmentID = enrollmentID;
        this.name=name;
        this.tutorName=tutorName;
        this.NumberOfCourses=NumberOfCourses;
    }

    @Override
    public String toString() {
        System.out.println( "Student" + "dbID=" + dbID + ", enrollmentID='" + enrollmentID + '\'' + ", name='" + name + '\'' + ", tutorName='" + tutorName+" ,Number of courses ="+NumberOfCourses);
        return "Student" + "dbID=" + dbID + ", enrollmentID='" + enrollmentID + '\'' + ", name='" + name + '\'' + ", tutorName='" + tutorName+" ,Number of courses"+NumberOfCourses;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollmentID() {

        return enrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getDbID() {

        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public Studentv2(){}
    public Studentv2(String name,String tutorName)
    {
        this.name=name;
        this.tutorName=tutorName;


    }


}
