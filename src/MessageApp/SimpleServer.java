package MessageApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    static int port = 9999;
    public static void main(String[] args) throws IOException { // throw all other exceptions away// regarding this no need catch
        System.out.println("\t\t Simple Server");
        System.out.println("\t\t ===============");

        var serverSocket = new ServerSocket(port);

        try {
            while (true){

                var socket = serverSocket.accept();
                System.out.println("\t\t Clinet is connected...\n\n");
                try {
                    var out = new PrintWriter(socket.getOutputStream(),true);
                    out.println("Welcome to socket programming");
                }
              finally {
                    socket.close();
                }
            }
        }
        finally {
            serverSocket.close();
        }



    }
}
