package com.beltrandes.belto.config;

import com.beltrandes.belto.domain.Task;
import com.beltrandes.belto.domain.User;
import com.beltrandes.belto.domain.enums.TaskCategory;
import com.beltrandes.belto.domain.enums.TaskPriority;
import com.beltrandes.belto.domain.enums.TaskStatus;
import com.beltrandes.belto.repositories.TaskRepository;
import com.beltrandes.belto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DBInstantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();



        var user1 = new User(null, "Beltrandes Marques", "beta0k", "46310045415dD@", null, null);
        userRepository.save(user1);
        var task1 = new Task(null, "Estudar Spring Boot", "Entender mais as camadas de segurança com Spring Security", TaskStatus.PENDING, TaskCategory.EDUCATION, TaskPriority.MEDIUM, user1, null, null);
        var task2 = new Task(null, "Entregar atividade Estrutura de Dados", "Finalizar os exercícios 6, 7, 8 e etregar a atividade", TaskStatus.IN_PROGRESS, TaskCategory.EDUCATION, TaskPriority.HIGH, user1, LocalDateTime.of(2024, 04, 22, 23, 59), null);
        var task3 = new Task(null, "Entregar atividade Estrutura de Dados", "Finalizar os exercícios 6, 7, 8 e etregar a atividade", TaskStatus.IN_PROGRESS, TaskCategory.EDUCATION, TaskPriority.HIGH, user1, LocalDateTime.of(2024, 04, 22, 23, 59), null);

        taskRepository.saveAll(Arrays.asList(task1, task2));
    }
}
