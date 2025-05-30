package implementacion.util;
public final class Constantes {

    private Constantes() {}

    public static final class Simulacion {
        public static final int    TIEMPO_PASO_DEFAULT     = 100;
        public static final int    MAX_PASOS_SIMULACION    = 1000;
        public static final double TASA_LLEGADA_DEFAULT    = 0.3;
    }

    public static final class Interfaz {
        public static final String TITULO_APLICACION       = "Simulador de Colas";
        public static final int    ANCHO_VENTANA           = 800;
        public static final int    ALTO_VENTANA            = 600;
    }

    public static final class Config {
        public static final int NUM_CAJAS_DEFAULT         = 3;
        public static final int MAX_CLIENTES_DEFAULT       = 50;
        public static final int PORCENTAJE_CAJAS_RAPIDAS   = 25;
    }
}
