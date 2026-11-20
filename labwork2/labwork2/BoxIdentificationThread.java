public class BoxIdentificationThread extends Thread {
    private int boxType = -1;

    public int getBoxIdentification() {
        return boxType;
    }

    public void identifyBoxType() {
        boolean dot1 = false;
        boolean dot2 = false;

        // Corre enquanto a caixa não chegar ao sensor central P0.0 (Dock 1)
        while (!SplitterConveyor.isBoxAtDock1() && !Thread.currentThread().isInterrupted()) {
            int sensor = SplitterConveyor.getIdentificationSensors();
            if (sensor == 1) {
                dot1 = true; // Ativou P1.5
            } else if (sensor == 2) {
                dot2 = true; // Ativou P1.6
            }

            try {
                Thread.sleep(5); // Evita busy-waiting (NFR7) sem perder marcas rápidas
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Quando P0.0 deteta a marca central, determina o tipo da caixa
        if (dot1 && dot2) {
            boxType = 3; // Duas marcas laterais + marca central
        } else if (dot1 || dot2) {
            boxType = 2; // Uma marca lateral + marca central
        } else {
            boxType = 1; // Apenas marca central em P0.0
        }
    }

    @Override
    public void run() {
        this.identifyBoxType();
    }
}