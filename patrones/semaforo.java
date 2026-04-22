public class Semaforo {

    // Estado guardado como String — nada nos impide poner "morado"
    private String estado = "rojo";

    public void siguiente() {
        if (estado.equals("rojo")) {
            System.out.println("Cambiando a verde...");
            estado = "verde";
        } else if (estado.equals("verde")) {
            System.out.println("Cambiando a amarillo...");
            estado = "amarillo";
        } else if (estado.equals("amarillo")) {
            System.out.println("Cambiando a rojo...");
            estado = "rojo";
        }
    }

    public void accionar() {
        if (estado.equals("rojo")) {
            System.out.println("Luz ROJA — Detenerse");
        } else if (estado.equals("verde")) {
            System.out.println("Luz VERDE — Avanzar");
        } else if (estado.equals("amarillo")) {
            System.out.println("Luz AMARILLA — Precaución");
        }
    }

    public void sonar() {
        if (estado.equals("rojo")) {
            System.out.println("Bip lento para peatones");
        } else if (estado.equals("verde")) {
            System.out.println("Bip rápido para peatones");
        } else if (estado.equals("amarillo")) {
            System.out.println("Sin sonido");
        }
    }
}
