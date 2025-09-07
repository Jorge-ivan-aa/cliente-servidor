package co.edu.uniquindio.servidor.functions;

public class DecimalBinario {

    public static String decimalBinario(String StringDecimal, String StringLongitud){
        StringBuilder binario = new StringBuilder();
        int decimal = Integer.parseInt(StringDecimal);
        int longitud = Integer.parseInt(BinarioDecimal.binarioDecimal(StringLongitud));

        for (int i=0; i<longitud; i++){
            int residuo = decimal%2;
            binario.append(String.valueOf(residuo));
            decimal = decimal/2;
        }

        return binario.reverse().toString();
    }
}
