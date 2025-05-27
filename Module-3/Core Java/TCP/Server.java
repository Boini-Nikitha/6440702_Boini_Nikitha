package TCP;

import java.io.*;
import java.net.*;

public class Server {
public static void main(String[] args) throws Exception {
ServerSocket serverSocket = new ServerSocket(12345);
System.out.println("Server started. Waiting for client...");

    Socket socket = serverSocket.accept();
    System.out.println("Client connected!");

    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    String clientMsg, serverMsg;

    while (true) {
        clientMsg = inFromClient.readLine();
        if (clientMsg.equalsIgnoreCase("exit")) {
            System.out.println("Client disconnected.");
            break;
        }
        System.out.println("Client: " + clientMsg);

        System.out.print("Server: ");
        serverMsg = keyboard.readLine();
        outToClient.println(serverMsg);
    }

    socket.close();
    serverSocket.close();
}
}
