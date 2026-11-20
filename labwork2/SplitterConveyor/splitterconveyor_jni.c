#include <jni.h>
#include <SplitterConveyor.h>

JNIEXPORT void JNICALL Java_SplitterConveyor_initializeHardarePorts(JNIEnv* jniEnv, jclass jclass) {
    initializeHardwarePorts();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1MoveForward(JNIEnv* jniEnv, jclass jclass) {
    cylinder1_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1MoveBackward(JNIEnv* jniEnv, jclass jclass) {
    cylinder1_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder1Stop(JNIEnv* jniEnv, jclass jclass) {
    cylinder1_stop();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinder1GetPosition(JNIEnv* jniEnv, jclass jclass) {
    return cylinder1_getPosition();
}
JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2MoveForward(JNIEnv* jniEnv, jclass jclass) {
    cylinder2_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2MoveBackward(JNIEnv* jniEnv, jclass jclass) {
    cylinder2_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinder2Stop(JNIEnv* jniEnv, jclass jclass) {
    cylinder2_stop();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinder2GetPosition(JNIEnv* jniEnv, jclass jclass) {
    return cylinder2_getPosition();
}
JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartMoveForward(JNIEnv* jniEnv, jclass jclass) {
    cylinderStart_moveForward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartMoveBackward(JNIEnv* jniEnv, jclass jclass) {
    cylinderStart_moveBackward();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_cylinderStartStop(JNIEnv* jniEnv, jclass jclass) {
    cylinderStart_stop();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_cylinderStartGetPosition(JNIEnv* jniEnv, jclass jclass) {
    return cylinderStart_getPosition();
}
JNIEXPORT void JNICALL Java_SplitterConveyor_conveyorMove(JNIEnv* jniEnv, jclass jclass) {
    conveyorMove();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_conveyorStop(JNIEnv* jniEnv, jclass jclass) {
    conveyorStop();
}

JNIEXPORT void JNICALL Java_SplitterConveyor_ledSwitch(JNIEnv* jniEnv, jclass jclass, jint on) {
    ledSwitch(on);
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_switchDock1Pressed(JNIEnv* jniEnv, jclass jclass) {
    return switchDock1Pressed();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_switchDock2Pressed(JNIEnv* jniEnv, jclass jclass) {
    return switchDock2Pressed();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_switchDockEndPressed(JNIEnv* jniEnv, jclass jclass) {
    return switchDockEndPressed();
}
JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isBoxAtDock1(JNIEnv* jniEnv, jclass jclass) {
    return isBoxAtDock1();
}

JNIEXPORT jboolean JNICALL Java_SplitterConveyor_isBoxAtDock2(JNIEnv* jniEnv, jclass jclass) {
    return isBoxAtDock2();
}

JNIEXPORT jint JNICALL Java_SplitterConveyor_getIdentificationSensors(JNIEnv* jniEnv, jclass jclass) {
    return getIdentificationSensors();
}