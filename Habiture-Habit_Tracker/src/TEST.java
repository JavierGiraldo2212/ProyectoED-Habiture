import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


import DataStructures.LinkedList;
import DataStructures.NodeStack;

public class TEST {
    public Actividad generador(int No){
        Random random = new Random();
        String nombre = "Actividad " + No;
        LocalDate fecha = LocalDate.now().plusDays(random.nextInt(30)); // Generar una fecha aleatoria en los próximos 30 días
        
        int nivelImportancia = random.nextInt(10) + 1; // Generar un nivel de importancia aleatorio entre 1 y 10
        
        LocalTime hora = LocalTime.of(23,59);;
        if (random.nextBoolean()) { // Hay un 50% de probabilidad de tener una hora
            hora = LocalTime.of(random.nextInt(24), random.nextInt(60)); // Generar una hora aleatoria
        }
        String descripcion = "";
        if (random.nextBoolean()) { // Hay un 50% de probabilidad de tener una descripción
            descripcion = "Descripción de la actividad"; // Una descripción aleatoria
        }
        Actividad actividad = new Actividad(nombre, fecha, nivelImportancia, hora, descripcion);
        return actividad;
    }
    
    public void testDo_undo( NodeStack<Actividad> Historial,
            LinkedList<Actividad> actividades, Funcion fn) {

        // Generar actividades
        Actividad[] actividadesGeneradas = new Actividad[100000];
        for (int num = 1; num <= 100000; num++) {
            actividadesGeneradas[num - 1] = generador(num);
        }

        for(int No = 10; No<=1000000; No*=10){
            System.out.print("#"+No + ",");
            long t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                actividades.add(actividadesGeneradas[num]);
            }
            System.out.print((System.nanoTime() - t1)+",");

            t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                fn.Done(Historial, actividades);
            }
            System.out.print((System.nanoTime() - t1) + ",");

            t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                fn.UnDone(Historial, actividades);
            }
            System.out.println((System.nanoTime() - t1));
            Historial.clear();
            actividades.clear();
        }

        
    }


    public void testUpdtDlt(LinkedList<Actividad> actividades, Funcion fn) {

        // Generar actividades
        Actividad[] actividadesGeneradas = new Actividad[100000];
        for (int num = 1; num <= 100000; num++) {
            actividadesGeneradas[num - 1] = generador(num);
        }

        for(int No = 10; No<=1000000; No*=10){
            System.out.print("#"+No + ",");
            long t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                actividades.add(actividadesGeneradas[num]);
            }
            System.out.print((System.nanoTime() - t1)+",");

            t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, No);
                String actividadName = "Actividad " + randomNum;

                int newRandomNum = ThreadLocalRandom.current().nextInt(1, No);
                String newActividadName = "Actividad " + randomNum;
                String newDescription = "nueva descripcion " + newRandomNum;
                fn.updateActividad(actividadName, newActividadName, newDescription, actividades);
            }
            System.out.print((System.nanoTime() - t1) + ",");

            t1 = System.nanoTime();
            for (int num = 0; num < No; num++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, No);
                String actividadName = "Actividad " + randomNum;
                fn.removeActividad(actividadName, actividades);
            }
            System.out.println((System.nanoTime() - t1));
            actividades.clear();
        }

        
    }


    public static void TestComparadores() {
        Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad4 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad5 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(15, 0), "Repasar Estructuras de datos");

        System.out.println(actividad1.compareTo(actividad2));
        System.out.println(actividad2.compareTo(actividad1));
        System.out.println(actividad1.compareTo(actividad3));

        System.out.println();

        System.out.println(actividad4.compararPorImportancia(actividad5));
        System.out.println(actividad5.compararPorImportancia(actividad4));
        System.out.println(actividad5.compararPorImportancia(actividad5));
    }

    public static void TestStack() {

        Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad4 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad5 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
                LocalTime.of(15, 0), "Repasar Estructuras de datos");

        NodeStack<Actividad> stackActividades = new NodeStack<>();
        stackActividades.push(actividad1);
        stackActividades.push(actividad2);
        stackActividades.push(actividad3);
        stackActividades.push(actividad4);
        stackActividades.push(actividad5);

        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());

        System.out.println();
    }

}
