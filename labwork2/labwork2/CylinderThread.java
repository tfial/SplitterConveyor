public class CylinderThread extends Thread {
    private Cylinder cylinder;

    public CylinderThread(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    @Override
    public void run() {
        this.cylinder.gotoPosition(1);
        if (!Thread.currentThread().isInterrupted()) {
            this.cylinder.gotoPosition(0);
        }
    }
}