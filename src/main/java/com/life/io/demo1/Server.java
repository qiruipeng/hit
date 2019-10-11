package com.life.io.demo1;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author: qirp
 * @since: 2019/10/9 17:18
 **/
@Data
public class Server {
    //端口号
    private static int port = 8888;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            //拿到socket
            Socket socket = serverSocket.accept();
            //开启一个线程处理
            new Thread(new Serverhandle(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Serverhandle implements Runnable{
        private Socket socket;

        public Serverhandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                out = new PrintWriter(this.socket.getOutputStream(), true);
                String body = null;
                while (true) {
                    body = in.readLine();
                    if (body == null) break;
                    System.out.println("Server :" + body);
                    out.println("服务器端回送响的应数据.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                socket = null;
            }
        }
    }
}
