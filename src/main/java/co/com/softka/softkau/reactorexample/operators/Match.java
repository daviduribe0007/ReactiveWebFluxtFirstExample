package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Match {
    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public void average(){//this function show the prom of any attribute
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 27));
        personList.add(new Person(2, "perucho", 28));
        personList.add(new Person(3, "miguel", 29));
        personList.add(new Person(4, "maria", 27));
        personList.add(new Person(5, "ana ", 28));
        personList.add(new Person(6, "maria", 11));
        Flux.fromIterable(personList)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(x -> log.info("average ages: "+ x.toString()));
    }

    public void count(){// return the number of elements in the data flow
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 27));
        personList.add(new Person(2, "perucho", 28));
        personList.add(new Person(3, "miguel", 29));
        personList.add(new Person(4, "maria", 27));
        personList.add(new Person(5, "ana ", 28));
        personList.add(new Person(6, "maria", 11));
        Flux.fromIterable(personList)
                .count()
                .subscribe(x -> log.info("numbers of data flow: "+x.toString()));

    }

    public void min(){// return the min value  of the collection
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 27));
        personList.add(new Person(2, "perucho", 28));
        personList.add(new Person(3, "miguel", 29));
        personList.add(new Person(4, "maria", 27));
        personList.add(new Person(5, "ana ", 28));
        personList.add(new Person(6, "maria", 11));
        Flux.fromIterable(personList)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(p -> log.info("Minimum per age: "+p.get()));

    }

    public void sum(){// return the sum of the values age
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 27));
        personList.add(new Person(2, "perucho", 28));
        personList.add(new Person(3, "miguel", 29));
        personList.add(new Person(4, "maria", 27));
        personList.add(new Person(5, "ana ", 28));
        personList.add(new Person(6, "maria", 11));
        Flux.fromIterable(personList)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(p -> log.info("Sum age: "+p.toString()));

    }

    public void summarizing(){// return the resume of the values age
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 27));
        personList.add(new Person(2, "perucho", 28));
        personList.add(new Person(3, "miguel", 29));
        personList.add(new Person(4, "maria", 27));
        personList.add(new Person(5, "ana ", 28));
        personList.add(new Person(6, "maria", 11));
        Flux.fromIterable(personList)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(p -> log.info("Resumen: "+p));

    }


}
