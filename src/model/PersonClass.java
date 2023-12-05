package model;

/**
 * Anschliessend eine Klasse, um eine Person zu erfassen, grundsätzliche überlegung war es,
 * eine Klasse zu erstellen, die als Grundlage für andere anwendungen dienen kann, aber nicht muss.
 * gemäss Auftrag enthält die Klasse genügen, sinnvolle final Attribute so wie 2 Attribute die innerhalb
 * der Klasse errechnet werden: Alter und BMI.
 */

public class PersonClass {
    /**Attribute: Als final wurden die Werte deklariert, die sich Grundsätzlich nicht mehr ändern sollten.*/
    //region Attribute
    private final int personalID;
    private final String firstName;
    private String secondName;
    private final String lastName;
    private countryEnum country;
    private int postalAddress;
    private String town;
    private String street;
    private int houseNumber;
    private final int yearOfBirth;
    private int age;
    private float size;
    private float weight;
    private float bodyMassIndex;
    //endregion
    /**Der Constructor: Wurde auf die Pflichteingaben beschränkt, alles andere kann über setter definiert werden.*/
    //region Constructor
    public PersonClass(int personalID, String firstName, String lastName, int yearOfBirth,
                       float size, float weight) {
        /**Validierung von grössen und Gewichtseingaben*/
        if(validWeightAndSizeInput(weight, size)) {
            this.weight = weight;
            this.size = size;
        }
        else {
            throw new IllegalArgumentException("Ungültige Eingabe für Gewicht oder Grösse: " +
                    weight + ", " + size);
        }

        /**Validierung von geburtsjahr eingaben*/
        if (isValidYearOfBirth(yearOfBirth)) {
            this.yearOfBirth = yearOfBirth;
        } else {
            throw new IllegalArgumentException("Ungültiges Geburtsjahr: " + yearOfBirth);
        }

        this.personalID = personalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = calculateAge();
        this.bodyMassIndex = calculateBMI();
    }
    //endregion
    /**Getter und Setter: Final Attribute erhalten ausschliesslich eine getter funktion*/
    //region Getter/Setter
    public int getPersonalID() {
        return personalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public countryEnum getCountry() {
        return country;
    }

    public void setCountry(countryEnum country) {
        this.country = country;
    }

    public int getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(int postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    //endregion
    /**Berechnung und sicherheitsabfragen innerhalb der Klasse*/
    //region Klassen Funktionen und SSicherheitsabfragen
    private int calculateAge() {
            return java.time.Year.now().getValue() - this.yearOfBirth;
    }

    private float calculateBMI() {
            return weight / (size * size);
    }
    private boolean isValidYearOfBirth(int year) {
        int currentYear = java.time.Year.now().getValue();
        int maximumAllowedAge = currentYear - 130;

        return year >= maximumAllowedAge && year <= currentYear;
    }
    private boolean validWeightAndSizeInput(double weight, double size) {
        return weight>0 && size >0;
    }
    //endregion
}
