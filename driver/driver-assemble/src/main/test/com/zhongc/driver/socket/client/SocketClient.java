package com.zhongc.driver.socket.client;

import com.zhongc.driver.socket.SocketWrapper;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Created by cst on 2016/4/14 0014.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket(InetAddress.getLocalHost(), 5678);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());
        OutputStreamWriter writer = new OutputStreamWriter(server.getOutputStream(), "UTF-8");
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while (!"".equals(s = wt.readLine())) {
            String str ="1";
            out.println(str);
            out.flush();
//            System.out.println(str);
            if (str.equals("end")) {
                break;
            }
            System.out.println(s);
        }
        server.close();
        ByteBuffer.allocate(1);
    }
}
