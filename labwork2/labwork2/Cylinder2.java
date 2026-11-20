public class Cylinder2 implements Cylinder {
    @Override 
    public void moveForward() {
        SplitterConveyor.cylinder2MoveForward();
    }
    @Override 
    public void moveBackward() {
        SplitterConveyor.cylinder2MoveBackward();
    }
    @Override
    public void stop() {
        SplitterConveyor.cylinder2Stop();
    }
    @Override
    public int getPosition() {
        return SplitterConveyor.cylinder2GetPosition();
    }
    
    @Override
    public boolean boxDetected() {
        return SplitterConveyor.isBoxAtDock2();
    }
}
