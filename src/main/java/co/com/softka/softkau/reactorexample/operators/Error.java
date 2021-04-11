package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Dog;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Error {
    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public void retry(int retryTimes) { // THis error id from db or other consult
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "maria", 11));
        personList.add(new Person(2, "carmen", 11));
        personList.add(new Person(3, "ana", 11));

        Flux.fromIterable(personList)
                .concatWith(Flux.error(new RuntimeException("This is a Error RETRY !!")))
                .retry(retryTimes)
                .doOnNext(x -> log.info("Retry:" + x.toString()))
                .subscribe();
    }
    public void errorReturn(){//this error when some error active this class then return one object or something
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "pedro", 11));
        personList.add(new Person(2, "miguel", 11));
        personList.add(new Person(3, "carlos", 11));
        Flux.fromIterable(personList)
                .concatWith(Flux.error(new RuntimeException("This is a Error RETURN!!")))
                .onErrorReturn(new Person(0 ,"xxx",0))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume(){//This error are used the exception for example on ErrorResume e -> e.getMessage
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "aaa", 11));
        personList.add(new Person(2, "eee", 11));
        personList.add(new Person(3, "iii", 11));
        Flux.fromIterable(personList)
                .concatWith(Flux.error(new RuntimeException("This is a Error RESUME !!")))
                .onErrorResume(e-> Mono.just(new Person(0,"xxx",0)))
                .subscribe(x -> log.info(x.toString()));
    }
    public void errorMap(){// this method controller the exception and implement the exception personalized
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "caro", 11));
        personList.add(new Person(2, "vane", 11));
        personList.add(new Person(3, "nata", 11));
        Flux.fromIterable(personList)
                .concatWith(Flux.error(new RuntimeException("This is a Error MAP !!")))
                .onErrorMap(e->new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));

    }
}
