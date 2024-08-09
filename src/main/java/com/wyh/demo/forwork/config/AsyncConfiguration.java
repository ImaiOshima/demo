package com.wyh.demo.forwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
@EnableTransactionManagement
public class AsyncConfiguration {
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("MyThreadPool-");
        executor.setTaskDecorator(new TransactionalTaskDecorator()); // 添加事务装饰器
        executor.initialize();
        return executor;
    }

    // 事务装饰器，用于将事务上下文传递给线程池
    private static class TransactionalTaskDecorator implements TaskDecorator {
        @Override
        public Runnable decorate(Runnable runnable) {
            return new TransactionalRunnable(runnable);
        }
    }

    // 可以在 Runnable 中嵌入一个新的事务上下文，以保证任务运行时有事务上下文
    private static class TransactionalRunnable implements Runnable {
        private final Runnable runnable;

        public TransactionalRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        public void run() {
            runnable.run();
        }
    }
}
