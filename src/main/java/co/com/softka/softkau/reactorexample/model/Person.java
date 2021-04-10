package co.com.softka.softkau.reactorexample.model;

public class Person {

    private Integer idPerson;
    private String name;
    private Integer age;

    public Person(Integer idPerson, String name, Integer age) {
        this.idPerson = idPerson;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
