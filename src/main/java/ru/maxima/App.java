package ru.maxima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxima.model.Person;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 3);

            session.delete(person);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sessionFactory.close();
        }
    }
}


//            Person person = session.get(Person.class, 1);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());

//            Person person1 = new Person("Test1", 1);
//            Person person2 = new Person("Test2", 2);
//            Person person3 = new Person("Test3", 3);
//
//            session.save(person1);
//            session.save(person2);
//            session.save(person3);

