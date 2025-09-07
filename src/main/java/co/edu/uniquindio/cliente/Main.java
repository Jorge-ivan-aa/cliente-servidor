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

                String inputLine;

                System.out.println("""
                                \n\nCONVERSIONES DISPONIBLES:
                                1. Dec → Bin     4. Hex → Dec
                                2. Bin → Dec     5. Bin → Hex \s
                                3. Dec → Hex     6. Hex → Bin
                                7. Salir
                                
                                Opción:\s
                                """);

                while (true) {
                    // Leer de consola y enviar
                    if (consoleInput.ready()) {
                        String outputLine = consoleInput.readLine().trim();

                        if (outputLine.equals("7")) {
                            out.println(outputLine);
                            System.out.println("Saliendo...");
                            break;
                        }

                        // Validar opciones del menú
                        if (outputLine.split(";")[0].matches("[1-6]")) {
                            out.println(outputLine);

                        } else if (!outputLine.isEmpty()) {
                            System.out.println("Opción no válida. Por favor ingrese 1-7");
                        }
                    }

                    // Leer del servidor
                    if (in.ready()) {
                        inputLine = in.readLine();
                        if (inputLine.equalsIgnoreCase("adios")) {
                            System.out.println("Servidor se desconectó");
                            break;
                        }

                        System.out.println("Servidor: " + inputLine);
                    }

                    Thread.sleep(100);
                }

                // Cerrar conexión
                in.close();
                out.close();
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
