package implementacion.modelo;

import interfaces.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class GestorCajas implements IGestorCajas {

    private final List<ICaja> cajas = new ArrayList<>();
    private final int porcentajeRapidas;

    public GestorCajas() {
        this.porcentajeRapidas = implementacion.util.Constantes.Config.PORCENTAJE_CAJAS_RAPIDAS;
    }

    public GestorCajas(int porcentajeRapidas) {
        if (porcentajeRapidas < 0 || porcentajeRapidas > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }
        this.porcentajeRapidas = porcentajeRapidas;
    }

    @Override
    public void inicializarCajas(int numCajas) {
        cajas.clear();
        int numRapidas = (int) Math.ceil(numCajas * porcentajeRapidas / 100.0);
        int id = 1;
        for (int i = 0; i < numRapidas; i++) {
            cajas.add(new CajaRapida(id++));
        }
        for (int i = numRapidas; i < numCajas; i++) {
            cajas.add(new Caja(id++));
        }
    }

    @Override
    public boolean hayCajasDisponibles() {
        return cajas.stream().anyMatch(ICaja::estaDisponible);
    }

    @Override
    public ICaja obtenerCajaDisponible(ICliente cliente) {
        for (ICaja caja : cajas) {
            if (caja.estaDisponible()) {
                if (caja.esRapida()) {
                    // Solo elegir si puede atender
                    if (((CajaRapida) caja).puedeAtender(cliente)) {
                        return caja;
                    }
                } else {
                    return caja;
                }
            }
        }
        return null;
    }

    @Override
    public List<ICaja> obtenerTodasLasCajas() {
        return cajas;
    }

    @Override
    public void actualizarCajas(long tiempoActual) {
    }
}
