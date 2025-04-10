package com.example.dataprocessing;

import com.example.dataprocessing.model.Task;
import com.example.dataprocessing.service.ResultWriter;
import com.example.dataprocessing.service.TaskQueue;
import com.example.dataprocessing.service.Worker;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int NUM_WORKERS = 4;
        final int NUM_TASKS = 10;

        TaskQueue queue = new TaskQueue();
        ResultWriter writer = null;

        try {
            writer = new ResultWriter("results.txt");

            // Load tasks into queue
            for (int i = 1; i <= NUM_TASKS; i++) {
                queue.addTask(new Task(i));
            }

            // Start worker threads
            ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);
            for (int i = 1; i <= NUM_WORKERS; i++) {
                executor.submit(new Worker(i, queue, writer));
            }

            Thread.sleep(12000); // Let them process
            executor.shutdownNow(); // Stop all workers after timeout
            writer.close();
            System.out.println("Processing completed.");
            System.out.println("All results have been saved to 'results.txt'.");
            System.out.println("Worker threads terminated successfully. CPU cycles reallocated.");
            System.out.println("Exiting hyperspace... until the next mission.");


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}