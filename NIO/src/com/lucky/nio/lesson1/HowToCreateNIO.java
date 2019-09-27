package com.lucky.nio.lesson1;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class HowToCreateNIO {
    public static void main(String[] args) throws IOException {
        File file = new File("file"+File.separator+"myText.txt");

        //创建一个channel
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        //获取到文件读写通道
        FileChannel fileChannel = randomAccessFile.getChannel();
        //获取一个字符缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int length = fileChannel.read(byteBuffer);

        while (length != -1){
            //让buffer处于读模式
            byteBuffer.flip();
            System.out.print(new String(byteBuffer.array(),0,length));
            byteBuffer.clear();
            length = fileChannel.read(byteBuffer);
        }

        randomAccessFile.close();
        fileChannel.close();
    }
}
