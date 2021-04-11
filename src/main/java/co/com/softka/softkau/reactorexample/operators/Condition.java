package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condition {

    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public void defaultIfEmpty() { // this method are used when the consult on db or anything consult return
        // something empty and you need return information per defect
        Mono.empty()
                .defaultIfEmpty(new Person(0, "xxx", 0))
                .subscribe(x -> log.info("DefaultEmptyMono" + x.toString()));

        Flux.empty()
                .defaultIfEmpty(new Person(0, "xxx", 0))
                .subscribe(x -> log.info("DefaultEmptyFlux" + x.toString()));

        Mono.just(new Person(1, "maria", 2))
                .defaultIfEmpty(new Person(0, "xxx", 0))
                .subscribe(x -> log.info("DefaultEmptyMono" + x.toString()));
    }

    public void takeUntil(String name) {//this transmit flow data until some condition is complete
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 11));
        personList.add(new Person(2, "perucho", 11));
        personList.add(new Person(3, "miguel", 11));
        personList.add(new Person(4, "maria", 20));
        personList.add(new Person(5, "ana ", 30));
        personList.add(new Person(6, "maria", 20));

        Flux.fromIterable(personList)
                .takeUntil(p -> p.getName().equals(name))
                .subscribe(p -> log.info("takeUntil" + p.toString()));
    }

    public void timeOut() throws InterruptedException {//in this method you use one thread for the live of the main program and other
        // execute the other asynchronous processors
        //The time out are used when you need some consult on db and that consult need time to execute
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Ruben", 11));
        personList.add(new Person(2, "perucho", 11));
        personList.add(new Person(3, "miguel", 11));
        personList.add(new Person(4, "maria", 20));
        personList.add(new Person(5, "ana ", 30));
        personList.add(new Person(6, "maria", 20));

        Flux.fromIterable(personList)
                .delayElements(Duration.ofSeconds(1))//This is used to say the read of the data wait 3 seconds
                // if for any reason the read no response you can send one error
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info("Time Out "+ x.toString()));

        Thread.sleep(14000); // the life of the project
    }
}
