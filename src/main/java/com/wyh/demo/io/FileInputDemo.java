package com.wyh.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author imai
 * @since 2021/2/3 8:37 下午
 */
public class FileInputDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("/Users/imai/123/imai.txt");

        FileChannel fc = fin.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        fc.read(buffer);

        buffer.flip();

        while(buffer.remaining() > 0){
            byte b = buffer.get();
            System.out.println((char)b);
        }

        fc.close();

        SelectorProvider.provider().openSelector();
    }
}
