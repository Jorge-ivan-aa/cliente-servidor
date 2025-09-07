package co.edu.uniquindio.servidor.functions;

public class DecimalHexadecimal {

    public static String decimalHexadecimal(String strDecimal, String strLongitud){
        StringBuilder hexadecimal = new StringBuilder();
        int decimal = Integer.parseInt(strDecimal);
        int longitud = Integer.parseInt(HexadecimalDecimal.hexadecimalDecimal(strLongitud));

        for(int i = 0; i < longitud; i++){
            int residuo = decimal%16;
            decimal = (int) decimal/16;
            switch (residuo) {
                case 10:
                    hexadecimal.append('A');
                    break;
                case 11:
                    hexadecimal.append('B');
                    break;
                case 12:
                    hexadecimal.append('C');
                    break;
                case 13:
                    hexadecimal.append('D');
                    break;
                case 14:
                    hexadecimal.append('E');
                    break;
                case 15:
                    hexadecimal.append('F');
                    break;
                default:
                    hexadecimal.append(String.valueOf(residuo));
            }
        }
        return hexadecimal.toString();
    }
}
