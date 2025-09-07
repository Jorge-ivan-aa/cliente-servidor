package co.edu.uniquindio.servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.print("""
                    ╔═════════════════════╗
                    ║  SERVIDOR INICIADO  ║
                    ║ Puerto: 5000        ║
                    ╚═════════════════════╝ \s
                   \s""");
            System.out.println("\n\n... Esperando cliente");


            Socket clientSocket = serverSocket.accept();
            System.out.println(" [✓] Cliente conectado: " + clientSocket.getInetAddress());

            // Input and output
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in));

            String inputLine;
            System.out.println("\n\nEscribe 'adios' para terminar");

            while (true) {
                // Leer del cliente
                if (in.ready()) {
                    inputLine = in.readLine();

                    switch (inputLine) {
                        case "1": // Decimal a binario
                            System.out.println("epa la arepa");
                        case "3": // Decimal a hexadecimal
                        case "2": // Binario a decimal
                        case "4": // Hexadecimal a decimal
                        case "6": // Hexadecimal a binario
                        case "5": // Binario a hexadecimal
                    }

                    System.out.println("Cliente: " + inputLine);

                    if (inputLine.equalsIgnoreCase("adios")) {

                        System.out.println("\n\n... El cliente se desconectó");
                        break;
                    }
                }

                // Leer de consola y enviar
                if (consoleInput.ready()) {
                    String outputLine = consoleInput.readLine();
                    out.println(outputLine);
                    if (outputLine.equalsIgnoreCase("adios")) break;
                }

                Thread.sleep(100); // Pequeña pausa
            }

            // Cerrar todo
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
