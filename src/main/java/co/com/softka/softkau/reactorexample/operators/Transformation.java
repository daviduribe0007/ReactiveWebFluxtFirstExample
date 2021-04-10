package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public void map(){//this method is for modify the content from flux or mono and return that flux or mono modified
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "aaa", 1));
        personList.add(new Person(2, "bbb", 2));
        personList.add(new Person(3, "ccc ", 3));

        Flux.fromIterable( personList)
                .map(p->{
                    p.setAge(8);
                        return  p;
                })
                .subscribe(p-> log.info(p.toString()));
    }

    public void mapRange(int init,int repetitions){ //This method is similar to map but apply the range and map in the same method
       Flux.range(init,repetitions)
       .map(i ->{
           i+= 10;
           return i;
       })
       .subscribe(i -> log.info("I : "+ i));
    }

    public  void flatMap(  ){// THis is similar to map but in this flatmap you need return a new flux or mono, not the object
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(2, "maria", 20));
        personList.add(new Person(3, "ana ", 30));

        Flux.fromIterable(personList)
                .flatMap(p->{
                    p.setAge(p.getAge() - 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info("flatMap : " + p.toString()));
    }

    public void groupBy(){//This method is used when you need group something for one attribute;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "carmen", 11));
        personList.add(new Person(1, "maria", 20));
        personList.add(new Person(3, "ana ", 30));

        Flux.fromIterable(personList)
                .groupBy(Person::getIdPerson)// similar to p-> p.getIdPersona();
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(p -> log.info( "Group : " + p.toString()));
    }
}
