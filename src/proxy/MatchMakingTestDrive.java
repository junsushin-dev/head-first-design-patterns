package proxy;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

//    public MatchMakingTestDrive() {
//        initializeDatabase();
//    }

    public void drive() {
        Person joe = getPersonFromDatabase("joe");
        Person ownerProxy = getOwnerProxy(joe);
        System.out.println("Name: " + ownerProxy.getName());
        System.out.println("Register interests for yourself");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Cannot rate geek rating for yourself");
        }
        System.out.println("Geek Rating: " + ownerProxy.getGeekRating());

        Person nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name: " + ownerProxy.getName());
        try {
            nonOwnerProxy.setInterests("Surfing");
        } catch (Exception e) {
            System.out.println("Cannot set interests for other people");
        }
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Set geek rating on other people");
        System.out.println("Geek Rating: " + nonOwnerProxy.getGeekRating());
    }

    Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person)
        );
    }

    Person getPersonFromDatabase(String name) {
        Person person = new PersonImpl();
        person.setName(name);
        person.setGender("male");
        person.setInterests("nothing");
        return person;
    }
}
