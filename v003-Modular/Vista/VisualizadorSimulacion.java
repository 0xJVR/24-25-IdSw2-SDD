package Vista;
import Modelo.Cola; 
import Modelo.GestorCajas;
import Modelo.Caja;

public class VisualizadorSimulacion {
    private final VisualizadorCaja visualizadorCaja = new VisualizadorCaja();

    public void mostrarEstado(Cola cola, GestorCajas gestorCajas) {
        System.out.print("Cola: " + cola.cantidad() + " | ");
        Caja[] cajas = gestorCajas.getCajas();
        for (int i = 0; i < cajas.length; i++) {
            System.out.print(visualizadorCaja.getEstadoCaja(i + 1, cajas[i]) + " | ");
        }
        System.out.println();
    }
}
