package com.wyh.demo.controller;

import com.wyh.demo.service.IoTPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2024/11/28
 * Description: [这里写该文件的简要描述]
 */
@RestController
@RequestMapping("/iot/permissions")
public class IoTPermissionController {

    @Autowired
    private IoTPermissionService permissionService;

    @PostMapping("/delete")
    public CompletableFuture<String> deletePermissions(@RequestBody List<Long> permissionIds) throws InterruptedException {

        // 调用异步删除方法
        CompletableFuture<IoTPermissionService.DeleteResult> resultFuture = permissionService.deletePermissions(permissionIds);

        // 获取异步结果
        return resultFuture.thenApply(result ->
                String.format("删除成功 %d 条，删除失败 %d 条", result.getSuccessCount(), result.getFailureCount())
        ).exceptionally(ex -> "删除过程中发生错误: " + ex.getMessage());

    }

    @PostMapping("/delete2")
    public String deletePermissions2(@RequestBody List<Long> permissionIds) {

        try {
            // 调用异步删除方法
            CompletableFuture<IoTPermissionService.DeleteResult> resultFuture = permissionService.deletePermissions(permissionIds);

            // 获取异步结果
            IoTPermissionService.DeleteResult result = resultFuture.get();

            return String.format("删除成功 %d 条，删除失败 %d 条", result.getSuccessCount(), result.getFailureCount());
        } catch (InterruptedException | ExecutionException e) {
            return "删除过程中发生错误: " + e.getMessage();
        }
    }
}
