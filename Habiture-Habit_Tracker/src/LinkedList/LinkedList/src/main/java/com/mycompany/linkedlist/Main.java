package com.mycompany.linkedlist;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HabitTracker habitTracker = new HabitTracker();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Bienvenido al seguimiento de habitos");
            System.out.println("1. Agregar un habito");
            System.out.println("2. Marcar un habito como completado");
            System.out.println("3. Marcar un habito como no completado");
            System.out.println("4. Eliminar un habito");
            System.out.println("5. Mostrar estado de habitos");
            System.out.println("6. Salir");
            System.out.print("Por favor, seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del habito que desea agregar: ");
                    String nombreHabit = scanner.nextLine();
                    if (!habitTracker.habitExists(nombreHabit)) {
                        habitTracker.addHabit(nombreHabit);
                        System.out.println("Habito agregado correctamente.");
                    } else {
                        System.out.println("El habito ya ha sido agregado previamente.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del habito que desea marcar como completado: ");
                    String nombreCompletado = scanner.nextLine();
                    if (habitTracker.habitExists(nombreCompletado)) {
                        System.out.print("Ingrese la fecha de completado (formato YYYY-MM-DD): ");
                        String fechaCompletado = scanner.nextLine();
                        if (isValidDate(fechaCompletado)) {
                            habitTracker.markHabitCompleted(nombreCompletado, fechaCompletado);
                            System.out.println("Registro actualizado.");
                        } else {
                            System.out.println("La fecha ingresada no es valida.");
                        }
                    } else {
                        System.out.println("El habito no existe.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del habito que desea marcar como no completado: ");
                    String nombreNoCompletado = scanner.nextLine();
                    if (habitTracker.habitExists(nombreNoCompletado)) {
                        System.out.print("Ingrese la fecha de completado (formato YYYY-MM-DD): ");
                        String fechaNoCompletado = scanner.nextLine();
                        if (isValidDate(fechaNoCompletado)) {
                            habitTracker.markHabitNotCompleted(nombreNoCompletado, fechaNoCompletado);
                            System.out.println("Registro actualizado.");
                        } else {
                            System.out.println("La fecha ingresada no es valida.");
                        }
                    } else {
                        System.out.println("El habito no existe.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del habito que desea eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    habitTracker.removeHabit(nombreEliminar);
                    System.out.println("Habito eliminado correctamente.");
                    break;
                case 5:
                    System.out.println("Estado de habitos:");
                    habitTracker.printHabits(); // Imprimir lista de hábitos en diferentes líneas
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        }
        scanner.close();
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate fecha = LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
