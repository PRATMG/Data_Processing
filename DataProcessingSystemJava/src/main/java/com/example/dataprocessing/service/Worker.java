package com.example.dataprocessing.service;

import com.example.dataprocessing.model.Task;

import jdk.internal.org.jline.terminal.TerminalBuilder;

public class Worker implements Runnable {
    private final TaskQueue queue;
    private final ResultWriter writer;
    private final int workerId;

    public Worker(int workerId, TaskQueue queue, ResultWriter writer) {
        this.workerId = workerId;
        this.queue = queue;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = queue.getTask();
                System.out.println("Worker " + workerId + " processing " + task);
                Thread.sleep(1000); // Simulate processing
                writer.writeResult("Worker " + workerId + " completed " + task);
            }
        } catch (InterruptedException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Worker " + workerId + " is clocking out. Task queue may be empty or shutdown requested.");
            }            
        } catch (Exception e) {
            System.err.println("Worker " + workerId + " encountered an error: " + e.getMessage());
        } finally {
            System.out.println("Worker " + workerId +" is shutting down.");
        }
    }
}
