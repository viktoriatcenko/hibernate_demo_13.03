package ru.maxima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.maxima.model.*;

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
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 4);
            System.out.println("We have the person here");

            System.out.println(person.getItems());


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
//            Person person = session.get(Person.class,2);
//
//            Passport passport = new Passport(person, 12332231);
//
//            person.setPassport(passport);
//
//            session.save(person);
//            Movie movie = new Movie("Pulp Fiction", 1996);
//
//            Actor actor1 = new Actor("Samuel L. Jackson", 70);
//            Actor actor2 = new Actor("Bruce Willis", 68);
//            Actor actor3 = new Actor("Uma Turman", 50);
//
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2, actor3)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor3.setMovies(new ArrayList<>(Collections.singletonList(movie)));