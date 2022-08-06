package Tcp回显程序;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;
    private String serverIp;
    private int serverPort;

    public TcpEchoClient(String ip,int port) throws IOException {
        this.serverIp = ip;
        this.serverPort = port;
        this.socket = new Socket(serverIp,serverPort);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                // 1、从键盘上，读取用户输入的内容
                System.out.println("-> ");
                String request = scanner.next();

                // DEBUG
                System.out.println("[" + request + "]");

                if (request.equals("exit")) {
                    System.out.println("退出");
                    break;
                }

                // 2、把这个读取的内容构造成请求，发送给服务器
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(request);
                writer.flush();

                // 3、从服务器读取响应并解析
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();

                // 4、把结果显示到界面上
                String log = String.format("req: %s; resp: %s",request,response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}

