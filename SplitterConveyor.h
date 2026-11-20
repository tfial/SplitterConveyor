#pragma once

#include <interface.h>
#include <stdbool.h>

void initializeHardwarePorts();

void setBitValue(uInt8* variable, int n_bit, int new_value_bit);
void getBitValue(uInt8 value, uInt8 n_bit);

void cylinder1_moveForward();
void cylinder1_moveBackward();
void cylinder1_stop();
int cylinder1_getPosition();

void cylinder2_moveForward();
void cylinder2_moveBackward();
void cylinder2_stop();
int cylinder2_getPosition();
void conveyorMove();
void conveyorStop();
void ledSwitch(int on);
bool switchDock1Pressed();
bool switchDock2Pressed();
bool switchDockEndPressed();
bool isBoxAtDock1();
bool isBoxAtDock2();
int getIdentificationSensors();
