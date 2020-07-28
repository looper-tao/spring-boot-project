package com.learn.net.scoket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: yeguxin
 * @date: 2020/7/13
 * @description:
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 8000;
        
        //创建套接字对象socket并封装ip与port
        Socket socket = new Socket(ip,port);
        //根据创建的socket对象获得一个输出流
        OutputStream os = socket.getOutputStream();
        //控制台输入以IO的形式发送到服务器
        System.out.println("TCP连接成功 \n请输入发送信息：");
        while(true){
            byte[] bytes = new Scanner(System.in).nextLine().getBytes();
            os.write(bytes);
            System.out.println("Socket发送成功");
            //刷新缓冲区
            os.flush();
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            // 读取客户端的数据
            while((len = is.read(buffer)) > 0){
                String message = new String(buffer, 0, len);
                System.out.println(message);
            }
        }
    
    }
}
