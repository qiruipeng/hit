package com.life.socketrpc.server;

import com.life.socketrpc.server.Impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务端实现
 * @author: qirp
 * @since: 2019/8/14 15:06
 **/
@Slf4j
public class RpcServer {
    //替换成zk等
    private static Map<String,Class<?>> registryMap = new HashMap<>();
    private int port;

    public RpcServer(int port) {
        this.port = port;
    }

    //注册
    public RpcServer registry(Class intface,Class impl){
        registryMap.put(intface.getName(),impl);
        return this;
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        log.info("socketrpc 已经启动...");

        while (true){
            Socket socket = server.accept();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            String serverName = input.readUTF();
            String methodName = input.readUTF();
            try {
                Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                Class serverClass = registryMap.get(serverName);
                Method method = serverClass.getMethod(methodName,parameterTypes);
                Object[] arguments = (Object[]) input.readObject();
                //invoke出结果
                Object result = method.invoke(serverClass.newInstance(),arguments);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(result);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new RpcServer(6666).registry(IHello.class, HelloServiceImpl.class).start();
    }
}
