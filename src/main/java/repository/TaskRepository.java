package repository;

import model.Task;

import java.io.*;
import java.util.List;

public class TaskRepository {
    public static void write(List<Task> tasks) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Tasks.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.close();
    }

    @SuppressWarnings("unchecked")
    public static List<Task> read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("Tasks.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (List<Task>) objectInputStream.readObject();
    }
}
