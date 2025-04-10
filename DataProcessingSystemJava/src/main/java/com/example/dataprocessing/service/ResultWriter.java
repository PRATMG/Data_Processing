// ResultWriter.java
package com.example.dataprocessing.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResultWriter {
    private final PrintWriter writer;
    private final Lock lock = new ReentrantLock();

    public ResultWriter(String filename) throws IOException {
        this.writer = new PrintWriter(new FileWriter(filename, true));
    }

    public void writeResult(String result) {
        lock.lock();
        try {
            writer.println(result);
            writer.flush();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        writer.close();
    }
}