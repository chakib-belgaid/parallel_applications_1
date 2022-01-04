package part_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class exercice2_board {

    static int port = 1234;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(port);

            Socket player1 = server.accept();
            Socket player2 = server.accept();
            System.out.println("Player 1 connected");
            System.out.println("Player 2 connected");
            OutputStream out1 = player1.getOutputStream();
            PrintWriter printer1 = new PrintWriter(out1, true);
            InputStream in1 = player1.getInputStream();
            InputStreamReader isr1 = new InputStreamReader(in1);
            BufferedReader reader1 = new BufferedReader(isr1);
            OutputStream out2 = player2.getOutputStream();
            PrintWriter printer2 = new PrintWriter(out2, true);
            InputStream in2 = player2.getInputStream();
            InputStreamReader isr2 = new InputStreamReader(in2);
            BufferedReader reader2 = new BufferedReader(isr2);
            printer1.println("white");
            printer2.println("black");
            printer1.println("pass");
            String move = reader1.readLine();
            System.out.println(move);
            printer2.println(move);
            move = reader2.readLine();
            System.out.println(move);
            player1.close();
            player2.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
