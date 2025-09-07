package co.edu.uniquindio.servidor.functions;

public class HexadecimalDecimal {

    public static String hexadecimalDecimal(String strHexadecimal){
        StringBuilder hexa = new StringBuilder();
        hexa.append(strHexadecimal);
        hexa.reverse();
        int suma = 0;

        for (int i = 0; i < hexa.length(); i++) {
            switch (hexa.charAt(i)) {
                case 'A':
                    suma = suma + ((int) Math.pow(16,i)*10);
                    break;
                case 'B':
                    suma = suma + ((int) Math.pow(16,i)*11);
                    break;
                case 'C':
                    suma = suma + ((int) Math.pow(16,i)*12);
                    break;
                case 'D':
                    suma = suma + ((int) Math.pow(16,i)*13);
                    break;
                case 'E':
                    suma = suma + ((int) Math.pow(16,i)*14);
                    break;
                case 'F':
                    suma = suma + ((int) Math.pow(16,i)*15);
                    break;
                default:
                    int valor = hexa.charAt(i) - '0';
                    suma = suma + ((int) Math.pow(16,i)*valor);
            }
        }
        return Integer.toString(suma);
    }
}
