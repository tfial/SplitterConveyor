public class CylinderStart implements Cylinder {//CylinderStart
    @Override 
    public void moveForward() {
        SplitterConveyor.cylinderStartMoveForward();
    }
    @Override 
    public void moveBackward() {
        SplitterConveyor.cylinderStartMoveBackward();
    }
    @Override
    public void stop() {
        SplitterConveyor.cylinderStartStop();
    }
    @Override
    public int getPosition() {
        return SplitterConveyor.cylinderStartGetPosition();
    }
  
    @Override
    public boolean boxDetected() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
