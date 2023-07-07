package ru.maxima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxima.model.Item;
import ru.maxima.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 4);

            Item item = new Item("new Item from App.class", person);

            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            Long save = (Long) session.save(person);

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

//            List people = session.createQuery("from Person where age > 7").getResultList();
//
//            people.forEach(System.out::println);
//
//            session.getTransaction().commit();

