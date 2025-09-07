package co.edu.uniquindio.servidor.functions;

public class HexadecimalBinario {

    public static String hexadecimalBinario(String strHexadecimal){
        StringBuilder hexa = new StringBuilder();
        hexa.append(strHexadecimal);
        hexa.reverse();

        int decimal = 0;
        for (int i = 0; i < hexa.length(); i++) {
            switch (hexa.charAt(i)) {
                case 'A': decimal = decimal + (int) Math.pow(16,i) * 10; break;
                case 'B': decimal = decimal + (int) Math.pow(16,i) * 11; break;
                case 'C': decimal = decimal + (int) Math.pow(16,i) * 12; break;
                case 'D': decimal = decimal + (int) Math.pow(16,i) * 13; break;
                case 'E': decimal = decimal + (int) Math.pow(16,i) * 14; break;
                case 'F': decimal = decimal + (int) Math.pow(16,i) * 15; break;
                default:
                    int valor = hexa.charAt(i) - '0';
                    decimal = decimal + (int) Math.pow(16,i) * valor;
            }
        }

        StringBuilder binario = new StringBuilder();
        while (decimal > 0) {
            int residuo = decimal % 2;
            binario.append(residuo);
            decimal = decimal / 2;
        }
        return binario.reverse().toString();
    }
}
