public class IncidenciaHardware extends Incidencia {

    public IncidenciaHardware(String equipoAfectado, String descripcion) {
        super(equipoAfectado, descripcion);
    }

    @Override
    public String obtenerTipoEspecifico() {
        return "HARDWARE"; // RFO6
    }

    // HU-02:
    @Override
    public void asignarPrioridad(String prioridad) {
        this.prioridad = prioridad;
        registrarEvento("Prioridad asignada a: " + prioridad);
        System.out.println("-> [HU-02] Prioridad de " + this.id + " asignada a " + prioridad);
    }

    // HU-04:
    @Override
    public void asignarTecnico(String tecnico) {
        this.tecnicoAsignado = tecnico;
        registrarEvento("Técnico asignado: " + tecnico);
        System.out.println("-> [HU-04] Técnico asignado a " + this.id + ": " + tecnico);
    }
}