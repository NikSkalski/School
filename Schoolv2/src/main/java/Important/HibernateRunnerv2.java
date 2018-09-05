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
        Tutorv2 newTutor = new Tutorv2("Tut-23", "Tutus Tutowski", 20000);
        Set<Studentv2> Supervisiongroup=new HashSet<Studentv2>();
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Supervisiongroup.add(student1);
        Supervisiongroup.add(student2);
        Supervisiongroup.add(student3);
        newTutor.setSupervisionGroup(Supervisiongroup);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);
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