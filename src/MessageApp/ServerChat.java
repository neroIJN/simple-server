package MessageApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                var out = new PrintWriter(socket.getOutputStream(),true);
                var in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));

                try {
                    out.println("Welcome to Chat Application");
                    while (true){
                        input = in.readLine();
                        System.out.println("Client says "+ input);

                        System.out.println("Client: ");
                        output = scannerInput.nextLine();
                        out.println(output);
                    }
                }
                finally {
                    socket.close();
                    out.close();
                    in.close();
                }
            }
        }
        finally {
            serverSocket.close();
        }

    }
}
