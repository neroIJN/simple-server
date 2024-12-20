package MessageApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class ServerChat {
    static int port = 9999;
    public static void main(String[] args) throws IOException { // throw all other exceptions away// regarding this no need catch
        System.out.println("\t\t Simple Server");
        System.out.println("\t\t ===============");

        var serverSocket = new ServerSocket(port);
        var scannerInput = new Scanner(System.in);
        String input,output;


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
