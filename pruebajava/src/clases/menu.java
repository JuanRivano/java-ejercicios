package clases;

import java.util.Scanner;


import static clases.validaciones.*;

public class menu {

    private static KiloCalorias kiloCalo = null;
    private static Scanner entradaEscaner = new Scanner(System.in);
    private static boolean KiloCreada = false;
    private static boolean actividadPesoDiario = false;
    private static String[] actividad = new String[5];
    private static double[] peso = new double[5];

    public static void menuPrincipal() {
        while (true) {
            int opcion;
            System.out.println("Ingrese una Opción");
            System.out.println("1.- Ingresar Persona");
            System.out.println("2.- Mostrar Informacion (nombre, edad, sexo y calorías)");
            System.out.println("3.- Ingresar Actividad diaria y Peso");
            System.out.println("4.- Mostrar el estado semanal (lunes a viernes) de la persona");
            System.out.println("5.- Salir");
            System.out.println("Opcion: ");
            opcion = validarOpcion(entradaEscaner.nextLine());
            switch (opcion) {
                case 1:
                    ingresarKiloCalorias();
                    break;
                case 2:
                    if (KiloCreada) {
                        kiloCalo.mostrarInformacion();
                    } else {
                        System.out.println("Ingrese información Persona");
                    }
                    break;
                case 3:
                    if (KiloCreada) {
                        ingresarActividadPeso();
                    } else {
                        System.out.println("Ingrese información Persona");
                    }
                    break;

                case 4:
                    if (KiloCreada && actividadPesoDiario) {
                        MostrarEstadoSemanal();
                    } else {
                        System.out.println("Ingrese información Persona y actividad pesos diarios para acceder a esta opción");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void ingresarKiloCalorias() {
        String nombre;
        String edad;
        String sexo;
        do {
            System.out.println("Ingrese Nombre (Primer Nombre): ");
            nombre = entradaEscaner.nextLine();
        }
        while (validarNombre(nombre));

        do {
            System.out.println("Ingrese Edad (1 a 100 años): ");
            edad = entradaEscaner.nextLine();
        }
        while (validadEdad(edad));

        do {
            System.out.println("Ingrese Sexo (hombre o mujer): ");
            sexo = entradaEscaner.nextLine();
        }
        while (validarSexo(sexo));

        kiloCalo = new KiloCalorias(nombre, Integer.parseInt(edad), sexo);
        KiloCreada = true;
    }

    private static void ingresarActividadPeso() {
        String actividadPesoString = "";
        for (int i = 0; i < actividad.length; i++) {
            do {
                System.out.println("Ingrese Actividad Fisica para el dia " + kiloCalo.diasDeLaSemana(i) + " Sedentaria - Moderada - Intensa :");
                actividadPesoString = entradaEscaner.nextLine();
            } while (validaActividad(actividadPesoString));
            actividad[i] = actividadPesoString;

            do {
                System.out.println("Ingrese Peso para el dia " + kiloCalo.diasDeLaSemana(i));
                actividadPesoString = entradaEscaner.nextLine();
            } while (validaPeso(actividadPesoString));
            peso[i] = Double.parseDouble(actividadPesoString);

        }
        actividadPesoDiario = true;
    }

    private static void MostrarEstadoSemanal() {
        String[] estado = kiloCalo.estado(actividad, peso);
        for (int i = 0; i < estado.length; i++) {
            System.out.println("Para el dia " + kiloCalo.diasDeLaSemana(i) + " usted " + estado[i]);
        }

    }

}



