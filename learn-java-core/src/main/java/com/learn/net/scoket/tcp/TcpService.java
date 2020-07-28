package com.learn.net.scoket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: yeguxin
 * @date: 2020/7/13
 * @description:
 */
public class TcpService {
    
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        int port = 8000;
        
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功,监听端口为: " + port + " 等待客户端进行连接");
            while(true){
                //等待客户端连接
                socket = serverSocket.accept();
                System.out.println("客户端连接成功,客户端信息为: "+socket.getRemoteSocketAddress());
                
                is = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                // 读取客户端的数据
                StringBuilder sb = new StringBuilder();
                while((len = is.read(buffer)) > 0){
                    String message = new String(buffer, 0, len);
                    sb.append(message);
                    System.out.println(message);
                }
                // 向客户端写数据
                os = socket.getOutputStream();
                String outPutMessage = "消息确认: "+ sb.toString()+"  已收到";
                os.write(outPutMessage.getBytes());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
