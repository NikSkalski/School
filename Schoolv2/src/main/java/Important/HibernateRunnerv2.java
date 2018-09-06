package Important;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateRunnerv2 {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        Studentv2 student1 = new Studentv2("Studus Studowski");
        Studentv2 student2 = new Studentv2("Jacek Placek");
        Studentv2 student3 = new Studentv2("Michaił Baryshnikov");
        Subjectv2 subject1 = new Subjectv2("Math",2);
        Subjectv2 subject2 = new Subjectv2("Physic",3);
        Tutorv2 newTutor = new Tutorv2("Tut-23", "Tutus Tutowski", 20000);
        Set<Studentv2> Supervisiongroup=new HashSet<Studentv2>();
        Set<Subjectv2> subjectv2Set=new HashSet<Subjectv2>();
        Set<Tutorv2> tutorv2s=new HashSet<Tutorv2>();
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Supervisiongroup.add(student1);
        Supervisiongroup.add(student2);
        Supervisiongroup.add(student3);
        subjectv2Set.add(subject1);
        subjectv2Set.add(subject2);
        tutorv2s.add(newTutor);
        subject1.setSpecializedTutors(tutorv2s);
        subject2.setSpecializedTutors(tutorv2s);
        newTutor.setTaughtsubjects(subjectv2Set);
        newTutor.setSupervisionGroup(Supervisiongroup);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);
        session.save(subject1);
        session.save(subject2);
        student1.setTutor(newTutor);
        student2.setTutor(newTutor);
        student3.setTutor(newTutor);
        tx.commit();
        session.close();
    }
    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}