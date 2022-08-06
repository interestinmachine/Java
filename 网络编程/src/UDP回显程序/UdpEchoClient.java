package UDP回显程序;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    // 参数的 ip 和 port 指的是，服务器的 ip 和 端口
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1、从标准输入读入一个数据
            System.out.println("-> ");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                System.out.println("exit!");
                return;
            }
            // 2、把字符串构造成一个 UDP 请求
            // 这个 DatagramPacket 中，既要包含具体的数据，又要包含这个数据发给谁？
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            // 3、尝试从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            // 4、显示结果
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            String log = String.format("req: %s; resp: %s",request,response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}

