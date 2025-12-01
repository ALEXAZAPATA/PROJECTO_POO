public class IncidenciaSoftware extends Incidencia {
    public IncidenciaSoftware(String equipoAfectado, String descripcion) {
        super(equipoAfectado, descripcion);
    }
    @Override
    public String obtenerTipoEspecifico() {
        return "SOFTWARE";
    }

}