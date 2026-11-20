public class Cylinder1 implements Cylinder {
    @Override 
    public void moveForward() {
        SplitterConveyor.cylinder1MoveForward();
    }
    @Override 
    public void moveBackward() {
        SplitterConveyor.cylinder1MoveBackward();
    }
    @Override
    public void stop() {
        SplitterConveyor.cylinder1Stop();
    }
    @Override
    public int getPosition() {
        return SplitterConveyor.cylinder1GetPosition();
    }
 
    @Override
    public boolean boxDetected() {
        return SplitterConveyor.isBoxAtDock1();
    }
}
