package co.edu.uniquindio.servidor.functions;

public class BinarioDecimal {

    public static String binarioDecimal(String stringBinario){
        StringBuilder binario = new StringBuilder();
        binario.append(stringBinario);
        binario.reverse();
        int suma = 0;

        for (int i = 0; i<binario.length(); i++){
            if (binario.charAt(i) == '1' ){
                suma = suma + (int) Math.pow(2,i);
            }
        }
        return String.valueOf(suma);
    }
}
