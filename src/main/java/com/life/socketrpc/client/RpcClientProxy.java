package com.life.socketrpc.client;

import com.life.socketrpc.server.IHello;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/** 客户端代理实现
 * @author: qirp
 * @since: 2019/8/14 15:36
 **/
@Slf4j
public class RpcClientProxy implements InvocationHandler{

    private Class<?> serviceIntface;
    private InetSocketAddress address;

    public RpcClientProxy(Class<?> serviceIntface, String ip, int port) {
        this.serviceIntface = serviceIntface;
        this.address = new InetSocketAddress(ip,port);
    }

    public Object getClientIntance(){
        return Proxy.newProxyInstance (serviceIntface.getClassLoader(),new Class<?>[]{serviceIntface},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket socket = new Socket();
        socket.connect(address);


        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(serviceIntface.getName());
        output.writeUTF(method.getName());
        output.writeObject(method.getParameterTypes());
        output.writeObject(args);

        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        return input.readObject();
    }

    public static void main(String[] args) {
        RpcClientProxy clientProxy = new RpcClientProxy(IHello.class,"127.0.0.1",6666);
        IHello hello = (IHello)clientProxy.getClientIntance();
        log.info("客户端：{}",hello.sayHello("张三 "));
    }
}
