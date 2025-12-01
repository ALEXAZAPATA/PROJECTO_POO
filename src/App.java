import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // 1. [HU-01] Registrar Nueva Incidencia
    private static void registrarNuevaIncidencia(Scanner scanner, List<Incidencia> lista) {
        System.out.println("\n--- REGISTRAR INCIDENCIA (HU-01) ---");
        System.out.print("Equipo: ");
        String equipo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Tipo (HARDWARE, SOFTWARE, RED): ");
        String tipo = scanner.nextLine().toUpperCase();

        Incidencia nuevaIncidencia = null;


        if (tipo.equals("HARDWARE")) {
            nuevaIncidencia = new IncidenciaHardware(equipo, descripcion);
        } else if (tipo.equals("SOFTWARE")) {
            nuevaIncidencia = new IncidenciaSoftware(equipo, descripcion);
        } else if (tipo.equals("RED")) {
            nuevaIncidencia = new IncidenciaRed(equipo, descripcion);
        } else {
            System.out.println("Tipo no válido.");
            return;
        }

        lista.add(nuevaIncidencia);
        System.out.println("Incidencia registrada. ID: " + nuevaIncidencia.getId());
    }

    // 2. [HU-02] Asignar Prioridad
    private static void accionAsignarPrioridad(Scanner scanner, List<Incidencia> lista) {
        System.out.println("\n--- ASIGNAR PRIORIDAD (HU-02) ---");
        System.out.print("ID de la incidencia: ");
        String idBuscar = scanner.nextLine();


        for (Incidencia inc : lista) {
            if (inc.getId().equalsIgnoreCase(idBuscar)) {
                System.out.print("Nueva Prioridad: ");
                String prioridad = scanner.nextLine();
                inc.asignarPrioridad(prioridad); // Llama al método de la Interfaz
                System.out.println("Prioridad asignada a " + inc.getId());
                return; // Salir del método una vez encontrado y procesado
            }
        }

    }

    // 3. [HU-03] Cambiar Estado
    private static void accionCambiarEstado(Scanner scanner, List<Incidencia> lista) {
        System.out.println("\n--- CAMBIAR ESTADO (HU-03) ---");
        System.out.print("ID de la incidencia: ");
        String idBuscar = scanner.nextLine();

        for (Incidencia inc : lista) {
            if (inc.getId().equalsIgnoreCase(idBuscar)) {
                System.out.print("Nuevo Estado: ");
                String estado = scanner.nextLine();
                inc.cambiarEstado(estado); // Llama al método de la Clase Abstracta
                System.out.println("Estado cambiado para ID " + inc.getId());
                return;
            }
        }
    }

    // 4. [HU-04] Asignar Técnico
    private static void accionAsignarTecnico(Scanner scanner, List<Incidencia> lista) {
        System.out.println("\n--- ASIGNAR TÉCNICO (HU-04) ---");
        System.out.print("ID de la incidencia: ");
        String idBuscar = scanner.nextLine();

        for (Incidencia inc : lista) {
            if (inc.getId().equalsIgnoreCase(idBuscar)) {
                System.out.print("Nombre del Técnico: ");
                String tecnico = scanner.nextLine();
                inc.asignarTecnico(tecnico); // Llama al método de la Interfaz
                System.out.println("Técnico asignado a ID " + inc.getId());
                return;
            }
        }
    }

    // 5. [HU-05] Consultar Incidencias
    private static void consultarIncidencias(List<Incidencia> lista) {
        System.out.println("\n--- LISTA DE INCIDENCIAS (HU-05) ---");
        System.out.println("ID | TIPO | ESTADO | PRIORIDAD | TÉCNICO");
        System.out.println("----------------------------------------");

        for (Incidencia inc : lista) {
            // Se usa concatenación simple y Polimorfismo con obtenerTipoEspecifico()
            System.out.println(inc.getId() + " | " +
                    inc.obtenerTipoEspecifico() + " | " +
                    inc.getEstado() + " | " +
                    inc.getPrioridad() + " | " +
                    inc.getTecnicoAsignado());
        }
        System.out.println("----------------------------------------");
    }

    // 6. [HU-06] Generar Reporte
    private static void accionGenerarReporte(List<Incidencia> lista) {

        int activas = 0;
        int hardware = 0;
        int software = 0;
        int red = 0;

        for (Incidencia i : lista) {

            if (!i.getEstado().equals(Constantes.ESTADO_RESUELTA) &&
                    !i.getEstado().equals(Constantes.ESTADO_CERRADA)) {
                activas++;
            }


            if (i instanceof IncidenciaHardware) {
                hardware++;
            } else if (i instanceof IncidenciaSoftware) {
                software++;
            } else if (i instanceof IncidenciaRed) {
                red++;
            }
        }

        System.out.println("\n--- REPORTE GENERAL HU-06 ---");
        System.out.println("Total de Incidencias: " + lista.size());
        System.out.println("Activas/Pendientes: " + activas);

        System.out.println("Distribución por Tipo:");
        System.out.println("Hardware: " + hardware);
        System.out.println("Software: " + software);
        System.out.println("Red: " + red);
        System.out.println("-----------------------------");
    }



    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. [HU-01] Registrar Incidencia");
        System.out.println("2. [HU-02] Asignar Prioridad");
        System.out.println("3. [HU-03] Cambiar Estado");
        System.out.println("4. [HU-04] Asignar Técnico");
        System.out.println("5. [HU-05] Consultar Lista");
        System.out.println("6. [HU-06] Generar Reporte");
        System.out.println("0. Salir");
        System.out.print("-> Opción: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Incidencia> listaIncidencias = new ArrayList<>();
        int opcion = -1;

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE TICKETING SIMPLE (POO) ");
        System.out.println("=========================================");

        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: registrarNuevaIncidencia(scanner, listaIncidencias); break;
                    case 2: accionAsignarPrioridad(scanner, listaIncidencias); break;
                    case 3: accionCambiarEstado(scanner, listaIncidencias); break;
                    case 4: accionAsignarTecnico(scanner, listaIncidencias); break;
                    case 5: consultarIncidencias(listaIncidencias); break;
                    case 6: accionGenerarReporte(listaIncidencias); break;
                    case 0: System.out.println("Saliendo"); break;
                    default: System.out.println("Opción no válida");
                }
            } else {
                System.out.println("Entrada incorrecta, ingrese una opcion");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }
}