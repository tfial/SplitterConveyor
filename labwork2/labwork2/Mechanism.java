public class Mechanism {

    public void conveyorMove() {
        SplitterConveyor.conveyorMove();
    }

    public void conveyorStop() {
        SplitterConveyor.conveyorStop();
    }

    public boolean switchDock1Pressed() {
        return SplitterConveyor.switchDock1Pressed();
    }

    public boolean switchDock2Pressed() {
        return SplitterConveyor.switchDock2Pressed();
    }

    public void ledSwitch(int on) {
        SplitterConveyor.ledSwitch(on);
    }
}