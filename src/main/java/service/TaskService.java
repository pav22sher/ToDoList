package service;

import model.Task;
import repository.TaskRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Сервис работы с задачами.
 */
public class TaskService {

    /**
     * Показать все задачи файла.
     */
    public static void showTasks() throws IOException, ClassNotFoundException {
        List<Task> readTasks = TaskRepository.read();
        if (readTasks.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Список дел:");
            readTasks.forEach(System.out::println);
        }
    }

    /**
     * Добавление задачи в файл.
     * @param scanner сканер.
     */
    public static void addTask(Scanner scanner) throws IOException, ClassNotFoundException {
        Task newTask = createTask(scanner);
        List<Task> tasks = TaskRepository.read();
        boolean isExists = tasks.stream().anyMatch(task -> task.getTaskId() == newTask.getTaskId());
        if (isExists) {
            System.out.println("Задача с таким номером уже существует!");
        } else {
            tasks.add(newTask);
            TaskRepository.write(tasks);
            System.out.println("Задача успешно сохранена!");
        }
    }

    /**
     * Редактирование задачи в файле.
     * @param scanner сканер.
     */
    public static void editTask(Scanner scanner) throws IOException, ClassNotFoundException {
        Task newTask = createTask(scanner);
        List<Task> tasks = TaskRepository.read();
        boolean isExists = tasks.stream().anyMatch(task -> task.getTaskId() == newTask.getTaskId());
        if (isExists) {
            tasks.removeIf(task -> task.getTaskId() == newTask.getTaskId());
            tasks.add(newTask);
            TaskRepository.write(tasks);
            System.out.println("Задача успешно отредактирована!");
        } else {
            System.out.println("Задачи с таким номером не существует!");
        }
    }

    /**
     * Создание задачи.
     * @param scanner сканер.
     */
    private static Task createTask(Scanner scanner) {
        System.out.println("Введите номер задачи:");
        int taskId = scanner.nextInt();
        System.out.println("Введите описание задачи:");
        String taskDescription = scanner.next();
        return new Task(taskId, taskDescription);
    }

    /**
     * Удаление задачи из файла.
     * @param scanner сканер.
     */
    public static void deleteTask(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.println("Введите номер задачи:");
        int taskId = scanner.nextInt();
        List<Task> tasks = TaskRepository.read();
        boolean isExists = tasks.stream().anyMatch(task -> task.getTaskId() == taskId);
        if (isExists) {
            tasks.removeIf(task -> task.getTaskId() == taskId);
            TaskRepository.write(tasks);
            System.out.println("Задача успешно удалена!");
        } else {
            System.out.println("Задачи с таким номером не существует!");
        }
    }
}
