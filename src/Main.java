public class Main {
    public static void main(String[] args) throws Exception {

        Person person = new Person("Adam", "00301412345", "Warszawa", 1.75);
        Person person2 = new Person("Jarek", "97101412345", "Lodz", 1.90);
        Person person3 = new Person("Ania", "03312512345", "Warszawa", 1.50);
        Person person4 = new Person("Kasia", "87113012345", "Lodz", 1.86);

        //Zostawione celowo, zeby sie latwiej sprawdzalo
        //Person.showPersons();
        //System.out.println();

        System.out.println("Exercise 1");
        System.out.println("The oldest person is " + Person.theOldestPerson());
        System.out.println();

        System.out.println("Exercise 2");
        System.out.println("There are " + Person.peopleFromCity("Lodz") + " person/s in your chosen city");
        System.out.println();

        System.out.println("Exercise 3");
        System.out.println("The average age in the selected city is: " + Person.averageCityAge("Warszawa"));
        System.out.println();

        System.out.println("Exercise 4");
        System.out.println("The oldest person in selected city is: " + Person.theOldestInCity("Warszawa"));
    }
}