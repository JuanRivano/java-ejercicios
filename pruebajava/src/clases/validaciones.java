package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validaciones {

    //Validaciones

    public static boolean validarNombre(String nombre) {
        boolean estado = false;
        Pattern pat = Pattern.compile("^[a-zA-Z]{3,10}$");
        Matcher mat = pat.matcher(nombre);
        if (!mat.matches()) {
            System.out.println("Error al ingresar Nombre (solo letras sin espacios largo minimo 3 maximo 10)");
            estado = true;
        }
        return estado;
    }

    public static boolean validarSexo(String sexo) {
        boolean estado = false;
        Pattern pat = Pattern.compile("^[a-zA-Z]{3,15}$");
        Matcher mat = pat.matcher(sexo);
        if (!mat.matches() || !(sexo.toLowerCase().equals("hombre") || sexo.toLowerCase().equals("mujer"))) {
            System.out.println("Error al ingresar Sexo (hombre 0 mujer)");
            estado = true;
        }
        return estado;
    }

    public static boolean validadEdad(String edad) {
        boolean estado = true;
        if (isNumeric(edad)) {
            if (Integer.parseInt(edad) > 0 && Integer.parseInt(edad) <= 100) {
                estado = false;
            } else {
                System.out.println("Edad fuera del rango 1 a 100");
            }
        }
        return estado;
    }

    public static boolean isNumeric(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("No numerico");
            return false;
        }
    }

    public static boolean isDecimal(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("No decimal");
            return false;
        }
    }

    public static boolean validaActividad(String actividad) {
        boolean estado = false;
        Pattern pat = Pattern.compile("^[a-zA-Z]{7,10}$");
        Matcher mat = pat.matcher(actividad);
        if (!mat.matches() || !(actividad.toLowerCase().equals("sedentaria") ||
                actividad.toLowerCase().equals("moderada") ||
                actividad.toLowerCase().equals("intensa"))) {
            System.out.println("Error al ingresar Actividad  Sedentaria - Moderada - Intensa");
            estado = true;
        }
        return estado;
    }

    public static boolean validaPeso(String peso) {
        boolean estado = true;
        if (isDecimal(peso)) {
            if (Double.parseDouble(peso) >= 3 && Double.parseDouble(peso) <= 150) {
                estado = false;
            } else {
                System.out.println("Peso fuera del rango 3 a 150");
            }
        }
        return estado;
    }

    public static int validarOpcion(String opcion) {
        return isNumeric(opcion) ? Integer.parseInt(opcion) : 100;
    }
}
