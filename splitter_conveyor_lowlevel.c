#include <stdio.h>
#include <conio.h>
#include <stdbool.h>

#include <interface.h>

void initializeHardwarePorts()
{
    createDigitalInput(0);
    createDigitalInput(1);
    createDigitalOutput(2);
}

void setBitValue(uInt8* variable, int n_bit, int new_value_bit)
// given a byte value, set the n bit to value
{
    uInt8 mask_on = (uInt8)(1 << n_bit);
    uInt8 mask_off = ~mask_on;
    if (new_value_bit) *variable |= mask_on;
    else               *variable &= mask_off;
}

int getBitValue(uInt8 value, uInt8 n_bit)
// given a byte value, returns the value of bit n
{
    return(value & (1 << n_bit));
}

void cylinder1_moveForward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 4, 1);
    setBitValue(&p, 3, 0);
    writeDigitalU8(2, p);
}

void cylinder1_moveBackward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 4, 0);
    setBitValue(&p, 3, 1);
    writeDigitalU8(2, p);
}

void cylinder1_stop()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 4, 0);
    setBitValue(&p, 3, 0);
    writeDigitalU8(2, p);
}

int cylinder1_getPosition()
{
    int v = readDigitalU8(0);
    if (!getBitValue(v, 4))
        return 0;
    else if (!getBitValue(v, 3))
        return 1;
    return(-1);
}
void cylinder2_moveForward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 6, 1);
    setBitValue(&p, 5, 0);
    writeDigitalU8(2, p);
}

void cylinder2_moveBackward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 6, 0); 
    setBitValue(&p, 5, 1); 
    writeDigitalU8(2, p);
}

void cylinder2_stop()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 6, 0);
    setBitValue(&p, 5, 0);
    writeDigitalU8(2, p);
}

int cylinder2_getPosition()
{
    int v = readDigitalU8(0);
    if (!getBitValue(v, 2))     
        return 0;
    else if (!getBitValue(v, 1)) 
        return 1;
    return (-1);
}
void cylinderStart_moveForward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 1, 1);
    setBitValue(&p, 0, 0); 
    writeDigitalU8(2, p);
}

void cylinderStart_moveBackward()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 1, 0);
    setBitValue(&p, 0, 1);
    writeDigitalU8(2, p);
}

void cylinderStart_stop()
{
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 1, 0);
    setBitValue(&p, 0, 0);
    writeDigitalU8(2, p);
}

int cylinderStart_getPosition()
{
    int v = readDigitalU8(0);
    if (getBitValue(v, 6))     
        return 0;
    else if (getBitValue(v, 5))
        return 1;
    return (-1);
}
void conveyorMove() {
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 2, 1);
    writeDigitalU8(2, p);
}

void conveyorStop() {
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 2, 0);
    writeDigitalU8(2, p);
}


void ledSwitch(int on) {
    uInt8 p = readDigitalU8(2);
    setBitValue(&p, 7, on ? 1 : 0);
    writeDigitalU8(2, p);
}

bool switchDock1Pressed() {
    uInt8 v = readDigitalU8(1);
    return (getBitValue(v, 4) != 0);
}

bool switchDock2Pressed() {
    uInt8 v = readDigitalU8(1);
    return (getBitValue(v, 3) != 0);
}

bool switchDockEndPressed() {
    uInt8 v = readDigitalU8(1);
    return (getBitValue(v, 2) != 0);
}
bool isBoxAtDock1() {
    uInt8 v = readDigitalU8(0);
    return (getBitValue(v, 0) != 0); // P0.0 (active-high)
}

bool isBoxAtDock2() {
    uInt8 v = readDigitalU8(1);
    return (getBitValue(v, 7) != 0); // P1.7 (active-high)
}

int getIdentificationSensors() {
    uInt8 v = readDigitalU8(1);
    if (getBitValue(v, 5) != 0) {      // P1.5 ativo
        return 1;
    }
    else if (getBitValue(v, 6) != 0) { // P1.6 ativo
        return 2;
    }
    return 0;                            // Nenhum sensor ativo
}