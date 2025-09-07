package co.edu.uniquindio.cliente;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.print("""
                ╔═════════════════════╗
                ║  CONEXIÓN CORRECTA  ║
                ║ Puerto: 5000        ║
                ╚═════════════════════╝ \s
               \s""");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in));

            Thread serverReader = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.equalsIgnoreCase("adios")) {
                            System.out.println("Servidor se desconectó");
                            break;
                        }
                        System.out.println("Servidor: " + inputLine);
                    }
                } catch (Exception e) {
                }
            }, "ServerReader");
            serverReader.setDaemon(true);
            serverReader.start();

            System.out.println("""
                            \n\nCONVERSIONES DISPONIBLES:
                            1. Dec → Bin     4. Hex → Dec
                            2. Bin → Dec     5. Bin → Hex \s
                            3. Dec → Hex     6. Hex → Bin
                            7. Salir

                            Opción:\s
                            """);

            String outputLine;
            while ((outputLine = consoleInput.readLine()) != null) {
                outputLine = outputLine.trim();

                if (outputLine.isEmpty()) {
                    continue;
                }

                if (outputLine.equals("7")) {
                    out.println(outputLine);
                    System.out.println("Saliendo...");
                    break;
                }

                if (outputLine.matches("[1-6]")) {
                    out.println(outputLine);
                } else if (!outputLine.isEmpty()) {
                    out.println(outputLine);
                }
            }

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
