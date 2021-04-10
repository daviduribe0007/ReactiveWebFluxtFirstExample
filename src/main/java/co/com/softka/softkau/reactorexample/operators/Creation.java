package co.com.softka.softkau.reactorexample.operators;

import co.com.softka.softkau.reactorexample.ReactorExampleApplication;
import co.com.softka.softkau.reactorexample.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creation {
    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public  void justFrom(){
        Mono.just(new Person(1,"David",28));
        //Flux.fromIterable(collection); with flux
        //Observable.just(item);// rx java
    }

    public void empty(){// this method is for data provider and that consult return something empty
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(int a, int b){//This methods is used to create a data flow from range of numbers
        Flux.range(a,b)
                .doOnNext(i->log.info("i : "+ i))
                .subscribe();
    }
     public void  repeat(int a){//This methods is used to repeat the data flow for x times
         List<Person> personList = new ArrayList<>();
         personList.add(new Person(1, "aaa", 1));
         personList.add(new Person(2, "bbb", 2));
         personList.add(new Person(3, "ccc ", 3));

         Flux.fromIterable(personList)
                 .repeat(a)
                 .subscribe(p -> log.info("Repeat "+p.toString()));

         Mono.just(new Person(11,"Mono aaa",1))
                 .repeat(a)
                 .subscribe(p -> log.info("Repeat Mono : "+ p.toString()));
     }


}
