// Task.java
package com.example.dataprocessing.model;

public class Task {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                '}';
    }
}