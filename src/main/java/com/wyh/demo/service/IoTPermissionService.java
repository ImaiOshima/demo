package com.wyh.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2024/11/28
 * Description: [这里写该文件的简要描述]
 */
@Service
public class IoTPermissionService {
    // 假设有一个 repository 进行数据库操作

    @Async
    public CompletableFuture<DeleteResult> deletePermissions(List<Long> permissionIds) throws InterruptedException {
        int successCount = 0;
        int failureCount = 0;

        for (Long permissionId : permissionIds) {
            try {
                // 删除单条权限记录
                boolean deleted = deletePermission(permissionId);
                if (deleted) {
                    successCount++;
                } else {
                    failureCount++;
                }
            } catch (Exception e) {
                failureCount++;  // 记录失败
                System.out.println("删除权限失败，ID: " + permissionId + " 错误信息: " + e.getMessage());
            }
        }

        Thread.sleep(1000 * 5);

        // 返回删除结果
        return CompletableFuture.completedFuture(new DeleteResult(successCount, failureCount));
    }

    // 模拟删除权限记录的方法
    private boolean deletePermission(Long permissionId) {
        // 假设我们从数据库中删除权限
        // 在实际中，你可以使用 permissionRepository.deleteById(permissionId);
//        int n = new Random().nextInt(10);
        if(permissionId % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    // 删除结果类，用于保存成功和失败数量
    public static class DeleteResult {
        private int successCount;
        private int failureCount;

        public DeleteResult(int successCount, int failureCount) {
            this.successCount = successCount;
            this.failureCount = failureCount;
        }

        public int getSuccessCount() {
            return successCount;
        }

        public int getFailureCount() {
            return failureCount;
        }
    }
}

