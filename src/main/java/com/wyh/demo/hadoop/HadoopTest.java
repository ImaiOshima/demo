package com.wyh.demo.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

/**
 * @Classname HadoopTest
 * @Description TODO
 * @Date 2022/7/23 3:02
 * @Created by 61635
 */
public class HadoopTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.31.198:9000"), new Configuration());

        FileStatus[] files = fs.listStatus(new Path("/"));
        for (FileStatus f : files) {
            System.out.println(f);
        }
        System.out.println("Compile Over");
    }

    @Test
    public void uploadFile() throws URISyntaxException, IOException {
        FileSystem fs = getFileSystem();
        Path src = new Path("C:\\Users\\61635\\Downloads\\x.txt");
        Path dst = new Path("/");
        FileStatus[] files = fs.listStatus(dst);
        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
        fs.copyFromLocalFile(src,dst);
        files = fs.listStatus(dst);
        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
    }

    @Test
    public void createFile() throws URISyntaxException, IOException {
        byte[] buff = "Hello Hadoop\n".getBytes();
        FileSystem fs = getFileSystem();
        Path dfs = new Path("testcreate");
        FSDataOutputStream outputStream = fs.create(dfs);
        outputStream.write(buff,0,buff.length);
    }

    public FileSystem getFileSystem() throws URISyntaxException, IOException {
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.31.198:9000"), new Configuration());
        return fs;
    }
}
