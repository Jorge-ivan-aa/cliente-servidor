package co.edu.uniquindio.servidor.functions;

public class BinarioHexadecimal {

    public static String binarioHexadecimal(String strBinario){
        StringBuilder binario = new StringBuilder();
        binario.append(strBinario);
        binario.reverse();

        int decimal = 0;
        for (int i = 0; i < binario.length(); i++) {
            if (binario.charAt(i) == '1') {
                decimal = decimal + (int) Math.pow(2, i);
            }
        }

        StringBuilder hexa = new StringBuilder();
        while (decimal > 0) {
            int residuo = decimal % 16;
            switch (residuo) {
                case 10: hexa.append("A"); break;
                case 11: hexa.append("B"); break;
                case 12: hexa.append("C"); break;
                case 13: hexa.append("D"); break;
                case 14: hexa.append("E"); break;
                case 15: hexa.append("F"); break;
                default: hexa.append(residuo);
            }
            decimal = decimal / 16;
        }
        return hexa.reverse().toString();
    }
}
