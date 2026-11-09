import java.io.*;

class StudentData implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int roll;
    transient String password;

    StudentData(String name, int roll, String password) {
        this.name = name;
        this.roll = roll;
        this.password = password;
    }

    public String toString() {
        return name + " " + roll + " password=" + password;
    }
}

public class SaveLoad {
    public static void main(String[] args) throws Exception {
        StudentData[] students = {
            new StudentData("Asha", 1, "abc"),
            new StudentData("Ravi", 2, "xyz")
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            StudentData[] loaded = (StudentData[]) in.readObject();
            for (StudentData student : loaded) System.out.println(student);
        }
    }
}
