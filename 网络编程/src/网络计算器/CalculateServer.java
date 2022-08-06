package 网络计算器;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class CalculateServer {
    private DatagramSocket socket = null;

    public CalculateServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            String response = process(request);

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            String log = String.format("[%s:%d] req: %s; resp: %s",
                    requestPacket.getAddress().toString(),requestPacket.getPort(),request,response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        String[] res = request.split(" ");
        double num1 = Double.parseDouble(res[0]);
        String operator = res[1];
        double num2 = Double.parseDouble(res[2]);
        double result = 0;
        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            if (num2 == 0.0) {
                return "除数不能为0";
            }
            result = num1 / num2;
        }
        return result + "";
    }

    public static void main(String[] args) throws IOException {
        CalculateServer server = new CalculateServer(9090);
        server.start();
    }
}

