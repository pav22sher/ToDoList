package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Задача
 */
@AllArgsConstructor
@Data
public class Task implements Serializable {
    /**
     * Номер задачи
     */
    private int taskId;
    /**
     * Описание задачи
     */
    private String taskDescription;
}
