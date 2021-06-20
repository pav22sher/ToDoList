package view;

import service.TaskService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Входная точка в программу
 */
public class EntryPoint {

    static final String SHOW_TASKS_CHOICE = "\n1-Вывести список задач из файла";
    static final String ADD_TASK_CHOICE = "\n2-Добавить задачу";
    static final String EDIT_TASK_CHOICE = "\n3-Редактировать задачу";
    static final String DELETE_TASK_CHOICE = "\n4-Удалить задачу";
    static final String EXIT_CHOICE = "\n5-выход из программы";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRepeated = true;
        while (isRepeated) {
            System.out.println();
            System.out.println("Выберите действие:" +
                    SHOW_TASKS_CHOICE + ADD_TASK_CHOICE + EDIT_TASK_CHOICE +
                    DELETE_TASK_CHOICE + EXIT_CHOICE
            );
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    TaskService.showTasks();
                    break;
                case 2:
                    TaskService.addTask(scanner);
                    break;
                case 3:
                    TaskService.editTask(scanner);
                    break;
                case 4:
                    TaskService.deleteTask(scanner);
                    break;
                case 5:
                    isRepeated = false;
                    break;
                default:
                    System.out.println("Выбран не существующий вариант! Попробуйте еще раз!");
                    break;
            }
            System.out.println();
            System.out.println("Нажмите Enter, чтобы продолжить!");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}
