/**
 * Die Klasse PersonClass repräsentiert eine Person mit verschiedenen Attributen
 * wie persönlichen Informationen, Adressdetails und physischen Merkmalen.
 * Diese Klasse dient als Grundlage für andere Anwendungen, kann aber auch unabhängig verwendet werden.
 * Sie enthält endgültige Attribute und zwei berechnete Attribute: Alter und Body-Mass-Index (BMI).
 *
 * @author Thomas Erny
 * @version 1.0
 */
package model;

/**
 * Repräsentiert eine Person mit persönlichen Informationen, Adressdetails und physischen Merkmalen.
 */
public class PersonClass {


    /**Attribute: Als final wurden die Werte deklariert, die sich Grundsätzlich nicht mehr ändern sollten.*/
    //region Attribute
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

    /**Der Konstruktor: Wurde auf die Pflichteingaben beschränkt, alles andere kann über setter definiert werden.
     * @param firstName  Der Vorname der Person.
     * @param lastName   Der Nachname der Person.
     *
     * @param yearOfBirth Das Geburtsjahr der Person.
     * @param size       Die Größe der Person in Metern.
     * @param weight     Das Gewicht der Person in Kilogramm.
     * @throws IllegalArgumentException Wenn ungültige Eingaben für Gewicht, Größe oder Geburtsjahr vorliegen.
     */
    //region Constructor
    public PersonClass(String firstName, String lastName, int yearOfBirth,
                       float size, float weight) {
        /**Validierung von grössen und Gewichtseingaben*/
        if(validWeightAndSizeInput(weight, size)) {
            this.weight = weight;
            this.size = size;
        }
        else {
            exceptionBMI();
        }

        /**Validierung von geburtsjahr eingaben*/
        if (isValidYearOfBirth(yearOfBirth)) {
            this.yearOfBirth = yearOfBirth;
        } else {
            throw new IllegalArgumentException("Ungültiges Geburtsjahr: " + yearOfBirth);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = calculateAge();
        this.bodyMassIndex = calculateBMI();
    }
    //endregion


    /**Getter und Setter: Final Attribute erhalten ausschliesslich eine getter funktion*/
    //region Getter/Setter

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
        if (!validWeightAndSizeInput(weight,size)) {
            exceptionBMI();
        }
        else{
            this.size = size;
            this.bodyMassIndex = calculateBMI();
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (!validWeightAndSizeInput(weight,size)) {
            exceptionBMI();
        }
        else{
            this.weight = weight;
            this.bodyMassIndex = calculateBMI();
        }
    }

    public int getAge() {
        calculateAge();
        return age;
    }

    public float getBodyMassIndex() {
        calculateBMI();
        return bodyMassIndex;
    }
    //endregion


    /**Berechnung und sicherheitsabfragen innerhalb der Klasse*/
    //region Klassen Funktionen und SSicherheitsabfragen

    /**
     * @return gibt das errechnete Alter zurück
     * */
    private int calculateAge() {
            return java.time.Year.now().getValue() - this.yearOfBirth;
    }

    /**@return Gibt den errechneten BMI auf 2 stellen gerundet zurück*/
    private float calculateBMI() {
        float bmi = weight / (size * size);
        return (float) (Math.round(bmi * 100.0) / 100.0);
    }

    /**
     * @return Prüft die
     * @param yearOfBirth eingabe auf Plausibilität
     */
    private boolean isValidYearOfBirth(int yearOfBirth) {
        int currentYear = java.time.Year.now().getValue();
        int maximumAllowedAge = currentYear - 130;

        return yearOfBirth >= maximumAllowedAge && yearOfBirth <= currentYear;
    }

    /** @return gibt einen Boolean zurück, welcher bestätigt, ob die eingaben grösser als 0 sind*/
    private boolean validWeightAndSizeInput(double weight, double size) {
        return weight>0 && size>0;
    }

    /**einfache funktion um von verschiedenen Quellen dieselbe Fehlerausgabe zu erzeugen*/
    private void exceptionBMI(){
        throw new IllegalArgumentException("Ungültige Eingabe für Gewicht: " + weight + "oder Grösse: " + size);
    }
    //endregion
}
