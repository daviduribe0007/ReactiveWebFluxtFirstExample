package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Dog;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Combination {

    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public void merge() {//This is used to combine two or more data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "carmen", 11));
        personList.add(new Person(3, "carmen", 11));

        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person(4, "maria", 20));
        personList2.add(new Person(5, "ana ", 30));
        personList2.add(new Person(6, "maria", 20));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "The pepe"));
        dogs.add(new Dog(2, "The pepe2"));
        dogs.add(new Dog(3, "The pepe3"));
        dogs.add(new Dog(4, "The mother in law killer"));

        Flux<Person> flux1 = Flux.fromIterable(personList);
        Flux<Person> flux2 = Flux.fromIterable(personList2);
        Flux<Dog> flux3 = Flux.fromIterable(dogs);

        Flux.merge(flux1, flux2, flux3)
                .subscribe(p -> log.info("Merge" + p.toString()));

    }

    public void zip() {//This zip wait for at least one flow data from all flux

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "carmen", 11));
        personList.add(new Person(3, "carmen", 11));

        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person(4, "maria", 20));
        personList2.add(new Person(5, "ana ", 30));
        personList2.add(new Person(6, "maria", 20));
        personList2.add(new Person(7, "maria2", 20));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "The pepe"));
        dogs.add(new Dog(2, "The pepe2"));
        dogs.add(new Dog(3, "The pepe3"));
        dogs.add(new Dog(4, "The mother in law killer"));

        Flux<Person> flux1 = Flux.fromIterable(personList);
        Flux<Person> flux2 = Flux.fromIterable(personList2);
        Flux<Dog> flux3 = Flux.fromIterable(dogs);

        Flux.zip(flux1, flux2, (p1, p2) -> String.format("Flux1: id: %s name: %s age: %s," +
                        " Flux2: id: %s name: %s age: %s"
                ,p1.getIdPerson(),p1.getName().toLowerCase(Locale.ROOT),p1.getAge()
                ,p2.getIdPerson(),p2.getName().toUpperCase(),p2.getAge()))
                .subscribe(x -> log.info(x));

        Flux.zip(flux1, flux2, flux3)
                .subscribe(p -> log.info("Zip basic" + p.toString()));

    }

    public void zipWith() {//This zip with use one flux on particular  to concatenate with other flux

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "carmen", 11));
        personList.add(new Person(3, "carmen", 11));

        List<Person> personList2 = new ArrayList<>();
        personList2.add(new Person(4, "maria", 20));
        personList2.add(new Person(5, "ana ", 30));
        personList2.add(new Person(6, "maria", 20));
        personList2.add(new Person(7, "maria2", 20));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "The pepe"));
        dogs.add(new Dog(2, "The pepe2"));
        dogs.add(new Dog(3, "The pepe3"));
        dogs.add(new Dog(4, "The mother in law killer"));

        Flux<Person> flux1 = Flux.fromIterable(personList);
        Flux<Person> flux2 = Flux.fromIterable(personList2);
        Flux<Dog> flux3 = Flux.fromIterable(dogs);

        flux1.zipWith(flux2, (p1,p2) -> String.format("FluxWith1: id: %s name: %s," +
                        " FluxWith2: id: %s name: %s"
                ,p1.getIdPerson(),p1.getName().toLowerCase(Locale.ROOT)
                ,p2.getIdPerson(),p2.getName().toUpperCase()))
                .subscribe(x -> log.info(x));



    }

}

