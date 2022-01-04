package part_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class exercice2_player {
    static String host = "localhost";
    static int port = 1234;

    public static void main(String[] args) {
        Socket server;
        try {
            // 1. se connecte au serveur
            server = new Socket(host, port);

            OutputStream out = server.getOutputStream();
            PrintWriter printer = new PrintWriter(out, true);
            InputStream in = server.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);

            // 2. est notifié de la couleur qui lui est assigné (blanc ou noir)
            String color = reader.readLine();
            System.out.println("You are playing as " + color);
            // 3. "attend" son tour pour jouer
            String turn = reader.readLine();
            System.out.println(turn);
            // 4. déplace un pion quelconque en diagonale
            printer.println("c4 to d5");

            server.close();

        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
