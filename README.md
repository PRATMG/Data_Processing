# Assignment 6: Data Processing System (Java & Go)

This repository contains a multi-threaded Data Processing System implemented in both **Java** and **Go**, simulating worker threads (or goroutines) that process tasks from a shared queue and write results to an output file.

## 🧠 Assignment Overview

The goal is to design and implement a system where multiple worker threads:
- Retrieve tasks from a shared queue
- Simulate processing each task
- Log the result to a shared output (file)
- Handle concurrency safely
- Gracefully shut down after processing all tasks

This system is implemented using:
- 🟦 Java (with ExecutorService, ReentrantLock, BlockingQueue)
- 🟨 Go (with Goroutines, Channels, sync.Mutex)

---

## 📁 Project Structure

```
assignment-6/
├── DataProcessingSystemJava/
│   ├── pom.xml
│   ├── src/
│   ├── results.txt
│   └── run.sh
├── GoDataProcessing/
│   ├── main.go
│   ├── task.go
│   ├── task_queue.go
│   ├── result_writer.go
│   ├── results.txt
│   └── go.mod
└── README.md
```

---

## 🚀 How to Run

### ▶️ Java Version

**Requirements**: Java 11+ and Maven

```bash
cd JavaVersion
mvn compile
mvn exec:java -Dexec.mainClass="com.example.dataprocessing.Main"
```

You will see worker threads processing tasks and a `results.txt` file created in the folder.

---

### ▶️ Go Version

**Requirements**: Go 1.20+ installed

```bash
cd GoVersion
go run .
```

Goroutines will process tasks and output will be written to `results.txt`.

---

## 📝 Report Highlights

- The Java version uses `ExecutorService` for thread pools, `ReentrantLock` for file safety, and `BlockingQueue` for task sharing.
- The Go version uses idiomatic concurrency primitives like channels and goroutines for communication and synchronization.
- Both systems simulate delay and handle errors gracefully, logging and shutting down with friendly messages.

---

## 📅 Submission Info

**Student**: Prakash  
**Course**: Advanced Programming Languages  
**Assignment**: 6 - Data Processing System  
**Date**: April 10, 2025

---

## 📜 License

This project is for academic demonstration purposes.
