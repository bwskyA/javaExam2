import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name, pesel, city;
    private int age;
    private double height;
    private Pattern pattern = Pattern.compile("(?<year>[0-9]{2})(?<month>[02468]1|[13579][012])(?<day>0[1-9]|1[0-9]|2[0-9]|3[01])[0-9]{5}");
    private static List<Person> personList = new ArrayList<>();

    public Person(String name, String pesel, String city, double height) throws Exception {
        this.name = name;
        this.city = city;
        this.height = height;
        setPesel(pesel);
        countAge(pesel);

        personList.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) throws Exception {
        if (checkPesel(pesel)) {
            this.pesel = pesel;
        } else {
            throw new Exception("Invalid Pesel!!");
        }
    }

    public static Person theOldestPerson() {
        int age = 0;
        Person theOldest = null;

        for (Person p : personList) {
            if (p.getAge() > age) {
                age = p.getAge();
                theOldest = p;
            }
        }
        return theOldest;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void showPersons() {
        for (Person p : personList) {
            System.out.println(p);
        }
    }

    public boolean checkPesel(String pesel) {
        Matcher matcher = pattern.matcher(pesel);
        return matcher.matches();
    }

    public void countAge(String pesel) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Matcher matcher = pattern.matcher(pesel);
        matcher.matches();
        String bornYear = matcher.group("year");
        String bornXX = "19";
        String bornXXI = "20";

        if (Integer.parseInt(matcher.group("month")) > 12) {
            bornXXI = new StringBuilder(bornXXI).append(bornYear).toString();
            setAge(year - Integer.parseInt(bornXXI));
        } else {
            bornXX = new StringBuilder(bornXX).append(bornYear).toString();
            setAge(year - Integer.parseInt(bornXX));
        }
    }

    public static Integer peopleFromCity(String city) {
        List<Person> peopleFromCity = new ArrayList<>();
        for (Person p : personList) {
            if (p.getCity().equals(city)) {
                peopleFromCity.add(p);
            }
        }
        return peopleFromCity.size();
    }

    public static double averageCityAge(String city) {
        List<Person> cityPeople = new ArrayList<>();
        double sumPeopleAge = 0;

        for (Person p : personList) {
            if (p.getCity().equals(city)) {
                cityPeople.add(p);
            }
        }
        for (Person p : cityPeople) {
            sumPeopleAge += p.getAge();
        }
        return sumPeopleAge / cityPeople.size();
    }

    public static Person theOldestInCity(String city){
        Person theOldest = null;
        int age = 0;

        for (Person p: personList){
            if (p.getCity().equals(city)){
                if (p.getAge() > age){
                    age = p.getAge();
                    theOldest = p;
                }
            }
        }
        return theOldest;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'' +
                ", height='" + height + '\'' +
                ", age='" + age + "\'";
    }
}
