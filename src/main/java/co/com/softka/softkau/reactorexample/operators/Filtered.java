package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Dog;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtered {

    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public  void filter() { //This is used to filter some flux
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));

        Flux.fromIterable( personList)
                .filter(p -> p.getAge() > 15)
                .subscribe(p -> log.info("Filter : "+p.toString()));
    }

    public  void distinct() { // this is used to remove the repeating elements
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(4, "carmen", 11));
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));
        personList.add(new Person(5, "maria", 20));


        Flux.fromIterable( personList)
                .distinct(p -> p.getIdPerson() )
                .distinct(p -> p.getName() )
                .subscribe(p -> log.info("Distinct : "+p.toString()));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "The pepe"));
        dogs.add(new Dog(1, "The pepe2"));
        dogs.add(new Dog(1, "The pepe3"));
        dogs.add(new Dog(2, "The mother in law killer"));
        Flux.fromIterable( dogs)
                .distinct()
                .subscribe(dog -> log.info("Distinct : "+dog.toString()));
    }

    public void take(int numbers){ //Take the first elements in the data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(4, "carmen", 11));
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));
        personList.add(new Person(5, "maria", 20));

        Flux.fromIterable(personList)
                .take(numbers)
                .subscribe(p -> log.info("Take : "+p.toString()));
    }

    public void takeLast(int numbers){ //Take the last elements in the data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(  4, "carmen", 11));
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));
        personList.add(new Person(5, "maria", 20));

        Flux.fromIterable(personList)
                .takeLast(numbers)
                .subscribe(p -> log.info("TakeLast : "+p.toString()));
    }

    public void skip(int numbers){ //jump the first elements in the data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(  4, "carmen", 11));
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));
        personList.add(new Person(5, "maria", 20));

        Flux.fromIterable(personList)
                .skip(numbers)
                .subscribe(p -> log.info("Skip : "+p.toString()));
    }

    public void skipLast(int numbers){ //jump the last elements in the data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(  4, "carmen", 11));
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));
        personList.add(new Person(5, "maria", 20));

        Flux.fromIterable(personList)
                .skipLast(numbers)
                .subscribe(p -> log.info("Skip Last : "+p.toString()));
    }



}
