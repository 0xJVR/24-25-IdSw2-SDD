package implementacion.util;

import implementacion.modelo.Cliente;
import interfaces.modelo.ICliente;
import interfaces.util.IGeneradorClientes;

import java.util.Random;

public class GeneradorClientes implements IGeneradorClientes {
    private int contadorClientes;
    private double tasaLlegada;
    private final Random random;

    public GeneradorClientes() {
        this(new Random());
    }

    public GeneradorClientes(Random random) {
        this.contadorClientes = 0;
        this.tasaLlegada      = Constantes.Simulacion.TASA_LLEGADA_DEFAULT;
        this.random           = random;
    }

    @Override
    public ICliente generarNuevoCliente(long tiempoActual) {
        contadorClientes++;
        int cantidadItems = 1 + random.nextInt(50);
        return new Cliente(contadorClientes, tiempoActual, cantidadItems);
    }

    @Override
    public boolean debeGenerarClienteEnEstePaso(double probabilidad) {
        return random.nextDouble() < (probabilidad > 0 ? probabilidad : tasaLlegada);
    }

    @Override
    public void configurarTasaLlegada(double tasaLlegada) {
        if (tasaLlegada < 0 || tasaLlegada > 1) {
            throw new IllegalArgumentException("La tasa de llegada debe estar entre 0 y 1");
        }
        this.tasaLlegada = tasaLlegada;
    }
}
