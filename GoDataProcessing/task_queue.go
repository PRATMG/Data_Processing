package main

type TaskQueue struct {
	tasks chan Task
}

func NewTaskQueue(size int) *TaskQueue {
	return &TaskQueue{tasks: make(chan Task, size)}
}

func (q *TaskQueue) AddTask(task Task) {
	q.tasks <- task
}

func (q *TaskQueue) GetTask() <-chan Task {
	return q.tasks
}

func (q *TaskQueue) Close() {
	close(q.tasks)
}
