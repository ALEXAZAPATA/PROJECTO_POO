El proyecto Sistema de Ticketing LAB-LIS es una aplicación de consola desarrollada en Java, diseñada para gestionar eficientemente las incidencias técnicas (Hardware, Software, Red) de un laboratorio. La implementación se centra en aplicar de manera estricta los principios de la Programación Orientada a Objetos .

Explicación deetallada de Cada Clase Java
1. Incidencia (Clase Abstracta)
Esta clase es el núcleo del sistema y representa la Abstracción. Es una clase abstracta que define la estructura básica de toda incidencia (atributos protegidos como id, estado e historial). Implementa la interfaz Gestionable. Sus métodos clave, como cambiarEstado, encapsulan el comportamiento de negocio al garantizar que cada cambio de estado automáticamente llame a registrarEvento. También declara el método obtenerTipoEspecifico() como abstracto.

2. Gestionable (Interfaz)
Esta clase es una Interfaz y define el contrato de gestión del sistema. Obliga a cualquier clase que la implemente  a proporcionar la funcionalidad de asignarPrioridad y asignarTecnico. 

3. IncidenciaHardware, IncidenciaSoftware, IncidenciaRed (Clases concretas)
Estas clases representan la Herencia. Extienden de la clase abstracta Incidencia . Su función principal es la especialización, implementando el método abstracto obtenerTipoEspecifico() para devolver su tipo real ("HARDWARE", "SOFTWARE", o "RED"). 

4. Constantes
Esta clase representa una Dependencia. Su único propósito es almacenar los valores de texto fijos para los estados y prioridades del sistema . Todos sus miembros son public static final para garantizar que sean inmutables y accesibles globalmente sin necesidad de crear objetos. 

5. App(Clase Principal)
Esta clase actúa como el Controlador del sistema. Contiene el método main y gestiona la interacción con el usuario mediante el menú de opciones. Su elemento clave es la colección List<Incidencia>, donde demuestra el Polimorfismo al almacenar todas las incidencias juntas. Además, en el método de reporte  utiliza el operador instanceof para clasificar y contar las incidencias según su tipo real (Hardware, Software, Red).
