import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        /*for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }*/
       Person p1 = new Person("Petr", "Petrov", 15, Sex.MAN, Education.ELEMENTARY);
       Person p2 = new Person("Ivan", "Ivanov", 27, Sex.MAN, Education.FURTHER);
       Person p3 = new Person("Lada", "Petrova", 17, Sex.WOMEN, Education.ELEMENTARY);
       Person p4 = new Person("Anna", "Zalova", 59, Sex.WOMEN, Education.HIGHER);
       Person p5 = new Person("Ganna", "Gnova", 61, Sex.WOMEN, Education.HIGHER);
       Person p6 = new Person("Alex", "Volkanovski", 63, Sex.MAN, Education.HIGHER);
       Person p7 = new Person("Stas", "Stasovski", 67, Sex.MAN, Education.HIGHER);
       Person p8 = new Person("Petras", "Peskov", 17, Sex.MAN, Education.SECONDARY);
       Person p9 = new Person("Sava", "Milosevic", 24, Sex.MAN, Education.ELEMENTARY);
       Person p10 = new Person("Klara", "Spenser", 22, Sex.WOMEN, Education.HIGHER);
       persons.add(p1);
       persons.add(p2);
       persons.add(p3);
       persons.add(p4);
       persons.add(p5);
       persons.add(p6);
       persons.add(p7);
       persons.add(p8);
       persons.add(p9);
       persons.add(p10);
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("количество несовершеннолетних: " + count);
        List<String> list = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN & x.getAge() >= 18 & x.getAge() <= 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println("список фамилий призывников: " + list);
        List<Person> list1 = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER && x.getAge() >= 18 && x.getAge() <= 65)
                .filter(x -> (x.getSex() == Sex.WOMEN && x.getAge() <= 60) | x.getSex() == Sex.MAN)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("список потенциально работоспособных людей:" +"\n" + list1);

    }
}
