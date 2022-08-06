package UDP翻译程序;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpDictClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpDictClient(String ip,int port) throws SocketException {
        this.serverIp = ip;
        this.serverPort = port;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("-> ");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                System.out.println("给爷爬");
                return;
            }

            // 2、构造请求并发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);

            // 3、从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());

            // 4、把数据显示给用户
            String log = String.format("req: %s; resp: %s",request,response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpDictClient client = new UdpDictClient("127.0.0.1",9090);
        client.start();
    }
}

