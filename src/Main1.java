// Суперклас Persona
class Persona {
    protected String name;
    protected int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Show() {
        System.out.println("Persona: " + name + ", Age: " + age);
    }
}

// Підклас Student
class Student extends Persona {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void Show() {
        System.out.println("Student: " + name + ", Age: " + age + ", Major: " + major);
    }
}

// Підклас Lecturer
class Lecturer extends Persona {
    protected String subject;  // Зробимо поле protected, щоб доступити його в підкласах

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void Show() {
        System.out.println("Lecturer: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

// Підклас HeadOfDepartment
class HeadOfDepartment extends Lecturer {
    private String department;

    public HeadOfDepartment(String name, int age, String subject, String department) {
        super(name, age, subject); // Передаємо subject до конструктора Lecturer
        this.department = department;
    }

    @Override
    public void Show() {
        System.out.println("Head of Department: " + name + ", Age: " + age + ", Subject: " + subject + ", Department: " + department);
    }
}

// Основний клас програми
public class Main1
 {
    public static void main(String[] args) {
        // Масив типу Persona
        Persona[] persons = new Persona[3];

        // Додавання об'єктів у масив
        persons[0] = new Student("Ivan", 20, "Computer Science");
        persons[1] = new Lecturer("Oleh", 45, "Mathematics");
        persons[2] = new HeadOfDepartment("Olga", 50, "Physics", "Physics Department");

        // Вивід масиву з використанням методу Show()
        for (Persona p : persons) {
            p.Show();
        }
    }
}
