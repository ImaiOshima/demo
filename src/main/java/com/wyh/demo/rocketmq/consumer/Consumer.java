package com.wyh.demo.rocketmq.consumer;

/**
 * @author imai
 * @since 2021/5/16 3:13 下午
 */
//@Component
//@Slf4j
//@RocketMQMessageListener(topic= Constant.topic,consumerGroup = Constant.group)
//public class Consumer implements RocketMQListener<MessageExt> {
//
//    @Override public void onMessage(MessageExt message) {
//        String msg = null;
//        try {
//            msg = new String(message.getBody(),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println("MsgConsumer >>> " + msg + ",msgId = " + message.getMsgId());
//    }
//}
