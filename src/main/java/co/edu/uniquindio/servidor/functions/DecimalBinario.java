package co.edu.uniquindio.servidor.functions;

public class DecimalBinario {
    /*
    Para convertir de decimal a binario, en el mensaje de
    solicitud se DEBE especificar la longitud de la respuesta en bits.
     */
    public static String DecimalBinario(String StringDecimal, String StringLongitud){
        StringBuilder binario = new StringBuilder();
        int decimal = Integer.parseInt(StringDecimal);
        int longitud = Integer.parseInt(BinarioDecimal.BinarioDecimal(StringLongitud));

        for (int i=0; i<longitud; i++){
            int residuo = decimal%2;
            binario.append(String.valueOf(residuo));
            decimal = decimal/2;
        }

        return binario.reverse().toString();
    }
}
