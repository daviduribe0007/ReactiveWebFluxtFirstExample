package co.com.softka.softkau.reactorexample;

import co.com.softka.softkau.reactorexample.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import io.reactivex.Observable;

@SpringBootApplication
public class ReactorExampleApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ReactorExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactorExampleApplication.class, args);
    }

    public void reactor() {
        Mono.just(new Person(1, "David", 28))
                .subscribe(p -> log.info("[Rezactor] person: " + p));

    }

    public void rxJava2() {
        Observable.just(new Person(2, "Mariela", 73))
                .subscribe(p -> log.info("[RxJava2] person: " + p));
    }
        @Override
        public void run (String...args) throws Exception {
            reactor();
            rxJava2();

        }
    }
