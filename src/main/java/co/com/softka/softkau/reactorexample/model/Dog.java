package co.com.softka.softkau.reactorexample.model;

import java.util.Objects;

public class Dog {

    private Integer idDog;
    private String name;

    public Dog(Integer idDog, String name) {
        this.idDog = idDog;
        this.name = name;
    }

    public Integer getIdDog() {
        return idDog;
    }

    public void setIdDog(Integer idDog) {
        this.idDog = idDog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "idDog=" + idDog +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return idDog.equals(dog.idDog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDog);
    }
}
