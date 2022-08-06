package UDP回显程序;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    // port 表示端口号
    // 服务器在启动的时候，需要关联（绑定）一个端口号
    // 收到数据的时候，就会根据这个端口号来决定把数据交给哪个进程
    // 虽然此处 port 的类型是 int，但实际上端口号是一个 2 个字节的无符号整数
    // 范围 0~65535
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            // 1、读取请求，当前服务器不知道客户端啥时候发来请求，receive 方法也会阻塞
            // 如果真的有请求过来，此时 receive 就会返回
            // 参数 DatagramPacket 是一个输出型参数，socket 中读到的数据会设置到这个参数的对象中。
            // DatagramPacket 在构造的时候，需要指定一个缓冲区（就是一段内存空间，通常使用 byte[]）
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            // 把 requestPacket 对象里面的内容取出来，作为一个字符串
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 2、根据请求来计算响应
            String response = process(request);
            // 3、把响应写回到客户端，也需要构造一个 DatagramPacket
            // 此处直接取 responsePacket 中设置的长度，必须是“字节个数”
            // 如果直接取 response.length()，此处得到的是，字符串的长度，也就是“字符的个数”
            // 当前的 responsePacket 在构造的时候，还需要指定这个包要发送给谁
            // 其实发送给的目标，就是发送请求的那一方
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length
                    ,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            // 4、加上日志打印 [ip:端口号]
            String log = String.format("[%s:%d] req: %s; resp: %s",
                    requestPacket.getAddress().toString(),
                    requestPacket.getPort(),
                    request,response);
            System.out.println(log);
        }
    }

    // 此处 process 方法负责的功能，就是根据请求来计算响应
    // 由于当前是一个 回显服务器，就把客户端的请求直接返回即可
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();

    }
}

