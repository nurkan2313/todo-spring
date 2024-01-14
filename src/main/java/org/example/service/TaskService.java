package org.example.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.example.exception.TaskNotFoundException;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        LOGGER.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    public Task getTaskById(String taskId) {
        LOGGER.info("Fetching task with id: {}", taskId);
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task addTask(@Valid Task task) {
        LOGGER.info("Adding a new task: {}", task.getDescription());
        return taskRepository.save(task);
    }

    public Task updateTask(@NotBlank String taskId, @Valid Task updatedTask) {
        LOGGER.info("Updating task with id: {}", taskId);
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(String taskId) {
        LOGGER.info("Deleting task with id: {}", taskId);
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found");
        }
    }
}
