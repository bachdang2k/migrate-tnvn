package com.vivas.migratectxh.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@RequiredArgsConstructor
public class ThreadConfig {

    private final TaskExecutionProperties properties;

    private final int MAX_POOL = Runtime.getRuntime().availableProcessors() * 2;

    @Bean(name = "worker", destroyMethod = "shutdown")
    public Executor worker() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getPool().getCoreSize());
        executor.setMaxPoolSize(MAX_POOL);
        executor.setQueueCapacity(properties.getPool().getQueueCapacity());
        executor.setThreadNamePrefix(properties.getThreadNamePrefix());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return  executor;
    }

    @Bean(name = "worker_main", destroyMethod = "shutdown")
    public Executor workerMain() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(properties.getPool().getCoreSize());
        executor.setMaxPoolSize(MAX_POOL);
        executor.setQueueCapacity(properties.getPool().getQueueCapacity());
        executor.setThreadNamePrefix(properties.getThreadNamePrefix() + "main_");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
