package Tcp翻译;

import Tcp回显多线程版.TcpThreadPoolEchoServer;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadPoolEchoServer {
    private HashMap<String,String> dict = new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);

        dict.put("hello","你好");
        dict.put("cat","猫");
        dict.put("dog","狗");
    }

    // start 方法不变
    // processConnection 方法也不变
    // 只要修改 process 即可！

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"[没有这个单词]");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}

