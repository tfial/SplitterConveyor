public class SplitterConveyor {
    static {
    System.load("C:\\str\\labwork2\\SplitterConveyor\\x64\\Debug\\SplitterConveyor.dll");
}

    static synchronized native public void initializeHardarePorts();

    static synchronized native public void cylinder1MoveForward();
    static synchronized native public void cylinder1MoveBackward();
    static synchronized native public void cylinder1Stop();

    static synchronized native public int cylinder1GetPosition();
    static synchronized native public int getIdenticationSensors();
    static synchronized native public boolean isBoxAtDock1();

    static synchronized native public void cylinder2MoveForward();
    static synchronized native public void cylinder2MoveBackward();
    static synchronized native public void cylinder2Stop();

    static synchronized native public int cylinder2GetPosition();
    static synchronized native public boolean isBoxAtDock2();

static synchronized native public void cylinderStartMoveForward();
static synchronized native public void cylinderStartMoveBackward();
static synchronized native public void cylinderStartStop();
static synchronized native public int cylinderStartGetPosition();

static synchronized native public void conveyorMove();
static synchronized native public void conveyorStop();
static synchronized native public void ledSwitch(int on);
static synchronized native public boolean switchDock1Pressed();
static synchronized native public boolean switchDock2Pressed();
    
static synchronized native public int getIdentificationSensors();
}
