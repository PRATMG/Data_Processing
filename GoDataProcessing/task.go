package main

import "fmt"

type Task struct {
	ID int
}

func (t Task) String() string {
	return fmt.Sprintf("Task{ID=%d}", t.ID)
}
