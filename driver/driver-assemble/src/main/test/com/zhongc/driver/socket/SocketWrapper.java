package com.zhongc.driver.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by cst on 2016/4/14 0014.
 */
public class SocketWrapper {
    private static final String CHART = "UTF-8";

    private InputStream inputStream;
    private OutputStream outputStream;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public SocketWrapper(Socket socket) throws IOException {
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream, CHART));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.outputStream, CHART));
    }

    public void write(String obj) throws IOException {
        outputStream.write(obj.getBytes("utf-8"));
//        bufferedWriter.write(obj);
        outputStream.flush();
    }

    public String realLine() throws IOException {
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
//            inputStream.re
        }
        String line = bufferedReader.readLine();
        return line;
    }

    public SocketWrapper socketWrapper() {
        return this;
    }

}
