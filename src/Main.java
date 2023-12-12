import model.PersonClass;

public class Main {

    public static void main(String[] args) {

        // Ein Objekt der PersonClass erstellen und initialisieren
        PersonClass person = new PersonClass("Beispiel", "Uelis", 1990, 1.75f,70.5f);

        // Attribute ausgeben
        System.out.println("Vorname: " + person.getFirstName());
        System.out.println("Nachname: " + person.getLastName());
        System.out.println("Geburtsjahr: " + person.getYearOfBirth());
        System.out.println("Grösse: " + person.getSize() + " Meter");
        System.out.println("Gewicht: " + person.getWeight() + " Kilogramm");
        System.out.println("Alter: " + person.getAge());
        System.out.println("Body Mass Index (BMI): " + person.getBodyMassIndex());
    }
}
