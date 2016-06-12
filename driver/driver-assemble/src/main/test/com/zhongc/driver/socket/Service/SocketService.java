package com.zhongc.driver.socket.Service;

import com.zhongc.driver.socket.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by cst on 2016/4/14 0014.
 */
public class SocketService {
    public static void main(String[] args) {
        new SocketService().socket();
    }

    public void socket() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端开启 端口: 8888");
            SocketWrapper socket = new SocketWrapper(serverSocket.accept());
            while (true) {
                System.out.println("客户端连接........");
                System.out.print("客户端:");
                System.out.println(socket.realLine());
                System.out.println("服务端返回:");
                socket.write("你好");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
