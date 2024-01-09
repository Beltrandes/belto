package com.beltrandes.belto.domain;

import com.beltrandes.belto.domain.enums.TaskCategory;
import com.beltrandes.belto.domain.enums.TaskPriority;
import com.beltrandes.belto.domain.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_task")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private UUID id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String body;
    private Integer taskStatus;
    private Integer taskCategory;
    private Integer taskPriority;
    @Getter
    @Setter
    @ManyToOne
    private User user;
    @Getter
    @Setter
    private LocalDateTime dueDate;
    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Task(UUID id, String title, String body, TaskStatus taskStatus, TaskCategory taskCategory, TaskPriority taskPriority, User user, LocalDateTime dueDate, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        setTaskStatus(taskStatus);
        setTaskCategory(taskCategory);
        setTaskPriority(taskPriority);
        this.user = user;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    public TaskStatus getTaskStatus() {
        return TaskStatus.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        }
    }

    public TaskCategory getTaskCategory() {
        return TaskCategory.valueOf(taskCategory);
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        if (taskCategory != null) {
            this.taskCategory = taskCategory.getCode();
        }
    }

    public TaskPriority getTaskPriority() {
        return TaskPriority.valueOf(taskPriority);
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        if (taskCategory != null) {
            this.taskPriority = taskPriority.getCode();
        }
    }
}
