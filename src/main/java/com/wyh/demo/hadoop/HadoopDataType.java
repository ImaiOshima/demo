package com.wyh.demo.hadoop;

import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 * @Classname HadoopDataType
 * @Description TODO
 * @Date 2022/7/24 19:09
 * @Created by 61635
 */
public class HadoopDataType {
    public static void main(String[] args) {
        testText();
        testArrayWriteable();
    }

    public static void testText() {
        System.out.println("testText");
        Text text = new Text("hello hadoop");
        System.out.println(text.getLength());
        System.out.println(text.find("a"));
        System.out.println(text.toString());
    }

    public static void testArrayWriteable(){
        System.out.println("testArrayWriteable");
        ArrayWritable arr = new ArrayWritable(IntWritable.class);
        IntWritable year = new IntWritable(2017);
        IntWritable month = new IntWritable(07);
        IntWritable date = new IntWritable(01);
        arr.set(new IntWritable[]{year,month,date});
        System.out.println(String.format("year=%d,month=%d,date=%d",((IntWritable)arr.get()[0]).get(),((IntWritable)arr.get()[1]).get(),((IntWritable)arr.get()[2]).get()));
    }
}
