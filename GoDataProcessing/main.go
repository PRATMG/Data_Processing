package main

import (
	"fmt"
	"sync"
	"time"
)

const (
	numWorkers = 4
	numTasks   = 10
)

func worker(id int, tasks <-chan Task, writer *ResultWriter, wg *sync.WaitGroup) {
	defer wg.Done()
	for task := range tasks {
		fmt.Printf("Worker %d processing %s\n", id, task)
		time.Sleep(1 * time.Second) // Simulate processing delay
		writer.Write(fmt.Sprintf("Worker %d completed %s", id, task))
	}
	fmt.Printf("👋 Worker %d is gracefully clocking out.\n", id)
}

func main() {
	taskQueue := NewTaskQueue(numTasks)
	writer, err := NewResultWriter("results.txt")
	if err != nil {
		panic(err)
	}
	defer writer.Close()

	// Add tasks
	for i := 1; i <= numTasks; i++ {
		taskQueue.AddTask(Task{ID: i})
	}
	taskQueue.Close() // important to close the channel

	// Start workers
	var wg sync.WaitGroup
	for i := 1; i <= numWorkers; i++ {
		wg.Add(1)
		go worker(i, taskQueue.GetTask(), writer, &wg)
	}

	wg.Wait()

	fmt.Println("Processing completed.")
	fmt.Println("All results have been saved to 'results.txt'.")
	fmt.Println("Worker goroutines terminated successfully. Go routines reallocated.")
	fmt.Println("Exiting hyperspace... until the next mission.")
}
