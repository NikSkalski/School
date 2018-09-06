package Important;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subjectv2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subjectName;
    private int numbOfsemester;
    private String TutorName;

    public Set<Tutorv2> getSpecializedTutors() {
        return specializedTutors;
    }

    public void setSpecializedTutors(Set<Tutorv2> specializedTutors) {
        this.specializedTutors = specializedTutors;
    }

    public String getTutorName() {

        return TutorName;
    }

    public void setTutorName(String tutorName) {
        TutorName = tutorName;
    }

    @ManyToMany
    private Set<Tutorv2> specializedTutors;

    public Subjectv2() {
    }


    public Subjectv2(String subjectName,int numbOfsemester){
        this.subjectName=subjectName;
        this.numbOfsemester=numbOfsemester;
}


    public int getNumbOfsemester() {
        return numbOfsemester;
    }

    public void setNumbOfsemester(int numbOfsemester) {
        this.numbOfsemester = numbOfsemester;
    }

    public String getSubjectName() {

        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
