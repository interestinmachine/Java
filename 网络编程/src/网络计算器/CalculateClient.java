package 网络计算器;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class CalculateClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public CalculateClient(String ip,int port) throws SocketException {
        this.serverIp = ip;
        this.serverPort = port;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("输入第一个操作数：");
            int num1 = scanner.nextInt();

            System.out.println("输入操作符号（+、-、*、/）");
            String operator = scanner.next();

            System.out.println("输入第二个操作数：");
            int num2 = scanner.nextInt();

            System.out.flush();

            String request = num1 + " " + operator + " " + num2;

            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0, responsePacket.getLength());

            String log = String.format("req: %s; resp: %s",request,response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        CalculateClient client = new CalculateClient("127.0.0.1",9090);
        client.start();
    }
}

