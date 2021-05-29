import java.time.LocalDate;

public class Human{
    private int  age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age){
        this.age = age;
    }

    public Human(String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = (int)((float)(LocalDate.now().toEpochDay() - birthDate.toEpochDay())/365.25);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }
}
