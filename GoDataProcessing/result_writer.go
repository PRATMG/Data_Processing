package main

import (
	"os"
	"sync"
)

type ResultWriter struct {
	file *os.File
	mu   sync.Mutex
}

func NewResultWriter(filename string) (*ResultWriter, error) {
	f, err := os.Create(filename)
	if err != nil {
		return nil, err
	}
	return &ResultWriter{file: f}, nil
}

func (w *ResultWriter) Write(result string) {
	w.mu.Lock()
	defer w.mu.Unlock()
	w.file.WriteString(result + "\n")
}

func (w *ResultWriter) Close() {
	w.file.Close()
}
