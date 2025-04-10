// TaskQueue.java
package com.example.dataprocessing.service;

import com.example.dataprocessing.model.Task;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue {
    private final BlockingQueue<Task> queue = new LinkedBlockingQueue<>();

    public void addTask(Task task) throws InterruptedException {
        queue.put(task);
    }

    public Task getTask() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}