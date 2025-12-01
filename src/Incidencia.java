import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Incidencia implements Gestionable {
    
    private static int idContador = 100; // Reemplazo de AtomicInteger
    
    protected String id;
    protected String equipoAfectado;
    protected String descripcion;
    protected String estado;        
    protected String prioridad;     
    protected String tecnicoAsignado;
    protected List<String> historial; 

    public Incidencia(String equipoAfectado, String descripcion) {
        this.id= "INC-" + idContador++; 
        this.equipoAfectado = equipoAfectado;
        this.descripcion = descripcion;
        this.estado = Constantes.ESTADO_REGISTRADA; 
        this.historial = new ArrayList<>();
        this.registrarEvento("Creada y " + Constantes.ESTADO_REGISTRADA);
    }
    
    public abstract String obtenerTipoEspecifico();

    public void cambiarEstado(String nuevoEstado) {
        if (!this.estado.equals(nuevoEstado)) {
            this.estado= nuevoEstado;
            this.registrarEvento("Cambio de estado a: " + nuevoEstado);
            System.out.println("-> [HU-03] Incidencia " + id + " actualizada a: " + nuevoEstado);
        }
    }

    protected void registrarEvento(String evento) {
        this.historial.add(LocalDateTime.now().toString() + " - " + evento);
    }
    
    public void describir() {
        System.out.println("--- DETALLE INCIDENCIA (" + obtenerTipoEspecifico() + ") ---");
        System.out.println("ID: " + id);
        System.out.println("Equipo: " + equipoAfectado);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Estado: " + estado);
        System.out.println("Prioridad: " + (prioridad != null ? prioridad : "No asignada"));
        System.out.println("Técnico: " + (tecnicoAsignado != null ? tecnicoAsignado : "Sin asignar"));
    }
    @Override
    public void asignarPrioridad(String prioridad) {
        this.prioridad= prioridad;
        registrarEvento("Prioridad asignada a: " + prioridad);
        System.out.println("-> [HU-02] Prioridad de " + this.id + " asignada a " + prioridad);
    }


    @Override
    public void asignarTecnico(String tecnico) {
        this.tecnicoAsignado= tecnico;
        registrarEvento("Técnico asignado: " + tecnico);
        System.out.println("-> [HU-04] Técnico asignado a " + this.id + ": " + tecnico);
    }

    public List<String> getHistorial() { 
        return historial; 
    }
    

    public String getId() { return id; }
    public String getEstado() { return estado; }
    public String getPrioridad() { return prioridad; }
    public String getTecnicoAsignado() {
        return tecnicoAsignado;
    }
}
