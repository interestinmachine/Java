package http发送请求;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class httpClient {
    private Socket socket;
    private String ip;
    private int port;

    public httpClient(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip,port);
    }

    public String get(String url) throws IOException {
        StringBuilder request = new StringBuilder();
        request.append("GET " + url + " HTTP/1.1\n");
        // 构造 header
        request.append("Host: " + ip + ":" + port + "\n");
        //构造空行
        request.append("\n");

        //写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(request.toString().getBytes());

        //存放响应数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        int n = inputStream.read(buffer);

        return new String(buffer,0,n,"utf-8");
    }
}

