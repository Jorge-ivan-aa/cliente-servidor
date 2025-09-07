package co.edu.uniquindio.servidor;

import co.edu.uniquindio.servidor.functions.*;

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

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("\n\nEscribe 'adios' para terminar (desde servidor o cliente)");

            Thread consoleSender = new Thread(() -> {
                try {
                    String outputLine;
                    while ((outputLine = consoleInput.readLine()) != null) {
                        out.println(outputLine);
                        if (outputLine.equalsIgnoreCase("adios")) break;
                    }
                } catch (Exception e) {
                }
            }, "ConsoleSender");
            consoleSender.setDaemon(true);
            consoleSender.start();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.print("Cliente (opción): " + inputLine);

                if (inputLine.equalsIgnoreCase("adios")) {
                    System.out.println("\n\n... El cliente se desconectó");
                    break;
                }

                try {
                    switch (inputLine) {
                        case "1": {
                            out.println("Ingresa el número decimal y longitud en bits (separar con ;)");
                            String dato = in.readLine();
                            String[] partes = dato.split(";");
                            String resultado = DecimalBinario.decimalBinario(partes[0].trim(), partes[1].trim());
                            out.println(resultado);
                            break;
                        }
                        case "2": {
                            out.println("Ingresa el número binario");
                            String dato = in.readLine();
                            String valor = dato.split(";")[0].trim();
                            String resultado = BinarioDecimal.binarioDecimal(valor);
                            out.println(resultado);
                            break;
                        }
                        case "3": {
                            out.println("Ingresa el número decimal y longitud en digitosHex (separar con ;)");
                            String dato = in.readLine();
                            String[] partes = dato.split(";");
                            if (partes.length < 2) {
                                out.println("ERROR: formato esperado -> numero;digitosHex");
                                break;
                            }
                            String resultado = DecimalHexadecimal.decimalHexadecimal(partes[0].trim(), partes[1].trim());
                            out.println(resultado);
                            break;
                        }
                        case "4": {
                            out.println("Ingresa el número hexadecimal");
                            String dato = in.readLine();
                            String valor = dato.split(";")[0].trim();
                            String resultado = HexadecimalDecimal.hexadecimalDecimal(valor);
                            out.println(resultado);
                            break;
                        }
                        case "5": {
                            out.println("Ingresa el número binario");
                            String dato = in.readLine();
                            String valor = dato.split(";")[0].trim();
                            String resultado = BinarioHexadecimal.binarioHexadecimal(valor);
                            out.println(resultado);
                            break;
                        }
                        case "6": {
                            out.println("Ingresa el número hexadecimal");
                            String dato = in.readLine();
                            String valor = dato.split(";")[0].trim();
                            String resultado = HexadecimalBinario.hexadecimalBinario(valor);
                            out.println(resultado);
                            break;
                        }

                        default: {
                            out.println("Opción no valida. Use 1-7.");
                        }
                    }
                } catch (Exception ex) {
                    out.println("ERROR: excepción al procesar la conversión -> " + ex.getMessage());
                }
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
