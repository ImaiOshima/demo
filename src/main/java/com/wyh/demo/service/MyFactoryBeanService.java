//package com.wyh.demo.service;
//
//import com.wyh.demo.websocket.handler.MyWebSocketHandler;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class MyFactoryBeanService {
//    private final MyWebSocketHandler myWebSocketHandler;
//
//    public MyFactoryBeanService(MyWebSocketHandler myWebSocketHandler) {
//        this.myWebSocketHandler = myWebSocketHandler;
//    }
//
//    @Async
//    @Transactional
//    public void deleteEntity(Long id) {
//        try {
//            // 执行删除操作
//            // 如果删除失败会抛出异常
//            // repository.deleteById(id);
//
//            // 模拟异常
//            throw new RuntimeException("Delete operation failed");
//        } catch (Exception e) {
//            // 捕获异常并通过WebSocket发送失败消息
//            try {
//                myWebSocketHandler.sendMessage("Transaction failed: " + e.getMessage());
//            } catch (Exception websocketException) {
//                websocketException.printStackTrace();
//            }
//            // 继续抛出异常以触发事务回滚
//            throw e;
//        }
//    }
//}
