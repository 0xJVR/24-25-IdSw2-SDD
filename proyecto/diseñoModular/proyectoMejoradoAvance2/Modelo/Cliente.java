package proyecto.diseñoModular.proyectoMejoradoAvance2.Modelo;

public class Cliente {
    private final int items;
    
    public Cliente() {
        this.items = (int)(Math.random() * 11) + 5; // 5-15 items
    }
    
    public int getItems() {
        return items;
    }
}
