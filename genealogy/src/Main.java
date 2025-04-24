import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantUMLRunner.setJarPath("/home/student/Pobrane/plantuml-1.2025.2.jar");
        try {
            List<Person> personList = Person.fromCsv("family.csv");

            Person.toBinaryFile(personList, "family.bin");
            List<Person> family = Person.fromBinaryFile("family.bin");
            System.out.println(family.size());
            System.out.println("family.bin");
            for (Person p: family){
                System.out.println(p);
                for (Person child : p.getChildren()) {
                    System.out.println("\t"+child.getFullName());
                }
            }

            String umlData = Person.umlFromList(family,
                    uml -> uml.replaceFirst("\\{", "#yellow {"),
                    p -> Person.selectDeceased(family).contains(p) || Person.selectOldestAlive(family) == p);

            System.out.println(umlData);
            PlantUMLRunner.generateDiagram(umlData,
                    "/home/student/Pobrane/", "diagram.png");

            System.out.println(Person.selectName(family, "anna"));
            System.out.println(Person.sortedByBirth(family));
            System.out.println(Person.selectDeceased(family));
            System.out.println(Person.selectOldestAlive(family));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}