public interface Cylinder {
    public void moveForward();
    public void moveBackward();
    public void stop();
    public int getPosition();
    public boolean boxDetected();
    default public void gotoPosition(int position) {
        if (position != 0 && position != 1) {
            return;
        }
        if (getPosition() == position) {
            return;
        }

        try {
            if (position == 1) {
                moveForward();
            } else {
                moveBackward();
            }

            while (getPosition() != position) {
                Thread.sleep(10); // Evita busy-waiting (NFR7) e responde a interrupções
            }
        } catch (InterruptedException e) {
            // Repõe a flag de interrupção para a thread superior saber que foi interrompida
            Thread.currentThread().interrupt();
        } finally {
            stop(); // Garante que o cilindro para ao atingir o limite ou ao ser interrompido (NFR6)
        }
    }
}
