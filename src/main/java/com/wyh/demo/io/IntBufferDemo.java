package com.wyh.demo.io;

import java.nio.IntBuffer;

/**
 * @author imai
 * @since 2021/2/2 12:39 上午
 */
public class IntBufferDemo {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);

        for(int i = 0; i<buffer.capacity();++i){
            int j = 2 * ( i+1) ;
            buffer.put(j);
        }
        buffer.flip();

        while(buffer.hasRemaining()){
            int j = buffer.get();
            System.out.println(j);
        }
    }
}
