import java.io.*;
import java.net.*;

public class SimpleHttpClient {
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8080;

        try{
            Socket socket = new Socket(host, port);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request = "GET / HTTP/1.1\r\n"+
                            "Host: 127.0.0.1\r\n"+
                            "\r\n";
            out.write(request);
            out.flush();

            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
