import java.io.*;
import java.net.*;
public class SimpleHttpServer{
    public static void main(String[] args){
        int port = 8080;
        try{
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("服务器启动在127.0.0.1：" + port);

                while(true){
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("接受来自：" + clientSocket.getInetAddress() + "的连接");
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String line;
                    while((line = in.readLine()) != null && !line.isEmpty()){
                        System.out.println(line);
                    }

                    String response = "HTTP/1.1 200 OK\r\n"+
                                    "Content-Type:text/plain\r\n"+
                                    "\r\n"+
                                    "Hello, HTTP!";
                    out.write(response);
                    out.flush();

                    clientSocket.close();
                    
                }
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
