public class IncidenciaRed extends Incidencia {


    public IncidenciaRed(String equipoAfectado, String descripcion) {
        super(equipoAfectado, descripcion);
    }


    @Override
    public String obtenerTipoEspecifico() {
        return "RED";
    }
}