import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hoang", "Ha Nam"));
        students.add(new Student(2, "Trang", "Ha Nam"));
        students.add(new Student(3, "Chuc", "Ha Nam"));
        students.add(new Student(4, "Mai", "Ha Nam"));
        students.add(new Student(5, "Quang", "Ha Nam"));
        writeToFile("student.txt",students);
        List<Student> readStudentFromFile = readDataFromFile("student.txt");
        for (Student student: readStudentFromFile
             ) {
            System.out.println(student);
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
