package client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    static String address = "127.0.0.1";
    static int port = 23456;


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getByName(address), port);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        System.out.println("Client started!");
        output.writeUTF("Give me a record # 12");
        System.out.println("Sent: Give me a record # 12");
        System.out.println("Received: " + input.readUTF());


    }

}
