package com.lucky.nio.lesson1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        copyMethod1();
        copyMethod2();
    }

    public static void copyMethod1() throws IOException {
        //获取文件路径
        File srcfile = new File("file"+File.separator+"myText.txt");
        File descfile = new File("copy"+File.separator+srcfile.getName());
        //获取到通道
        RandomAccessFile srcfileAccess= new RandomAccessFile(srcfile,"rw");
        RandomAccessFile descfileAccess= new RandomAccessFile(descfile,"rw");
        FileChannel srcChannel = srcfileAccess.getChannel();
        FileChannel descChannel = descfileAccess.getChannel();
        //创建Buffer缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int length = srcChannel.read(buffer);
        while(length != -1){
            //将缓冲区切换到读模式
            buffer.flip();
            System.out.println(new String(buffer.array(),0,length));
            //将文件从缓冲区写入到目标文件通道中
            descChannel.write(buffer);
            //将之前通道中的内容清空，避免重复读取
            buffer.clear();
            length = srcChannel.read(buffer);
        }
        srcChannel.close();
        descChannel.close();
        srcfileAccess.close();
        descfileAccess.close();
    }

    public static void copyMethod2() throws IOException {
        //获取到文件对象
        File srcFile = new File("file"+File.separator+"myText,txt");
        File descFile = new File("copy"+File.separator+"myText,txt");
        //获取到通道
        RandomAccessFile srcFileAccess = new RandomAccessFile(srcFile,"rw");
        RandomAccessFile descFileAccess = new RandomAccessFile(descFile,"rw");
        FileChannel srcChannel = srcFileAccess.getChannel();
        FileChannel descChannel = descFileAccess.getChannel();
        //直接将原通道中的内容转换到目标通道中
        srcChannel.transferTo(0,srcChannel.size(),descChannel);

        srcChannel.close();
        descChannel.close();
        srcFileAccess.close();
        descFileAccess.close();
    }
}
