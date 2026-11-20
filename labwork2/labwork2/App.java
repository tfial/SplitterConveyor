import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int t = -1;
        Scanner sc = new Scanner(System.in);
        SplitterConveyor.initializeHardarePorts(); // Usa o nome exato definido em SplitterConveyor.java

        Cylinder1 cylinder1 = new Cylinder1();
        Cylinder2 cylinder2 = new Cylinder2();
        CylinderStart cylinderStart = new CylinderStart();
        Mechanism mechanism = new Mechanism();

        while (t != 0) {
            System.out.println("\n--- Menu de Teste ---");
            System.out.println("1: Cilindro 1 - Avançar");
            System.out.println("2: Cilindro 1 - Recuar");
            System.out.println("3: Cilindro 1 - Parar");
            System.out.println("4: Tapete - Mover");
            System.out.println("5: Tapete - Parar");
            System.out.println("6: LED - Ligar");
            System.out.println("7: LED - Desligar");
            System.out.println("8: Ler estado dos Switches (Dock 1 e Dock 2)");
            System.out.println("9: CylinderStart - Avançar");
            System.out.println("10: CylinderStart - Recuar");
            System.out.println("11: CylinderStart - Parar");
            System.out.println("12: CylinderStart - Ler Posição");
            System.out.println("13: Ler Sensores de Caixa nas Docks (P0.0 e P1.7)");
            System.out.println("14: Ler Sensores de Identificação (P1.5 e P1.6)");
            System.out.println("0: Sair");
            System.out.print("Escolha uma opção: ");

            t = sc.nextInt();
            switch (t) {
                case 1:
                    cylinder1.moveForward();
                    break;
                case 2:
                    cylinder1.moveBackward();
                    break;
                case 3:
                    cylinder1.stop();
                    break;
                case 4:
                    mechanism.conveyorMove();
                    break;
                case 5:
                    mechanism.conveyorStop();
                    break;
                case 6:
                    mechanism.ledSwitch(1);
                    break;
                case 7:
                    mechanism.ledSwitch(0);
                    break;
                case 8:
                    System.out.println("Switch Dock 1: " + mechanism.switchDock1Pressed());
                    System.out.println("Switch Dock 2: " + mechanism.switchDock2Pressed());
                    break;
                case 9:
                    cylinderStart.moveForward();
                    break;
                case 10:
                    cylinderStart.moveBackward();
                    break;
                case 11:
                    cylinderStart.stop();
                    break;
                case 12:
                    System.out.println("Posição CylinderStart: " + cylinderStart.getPosition());
                    break;
                case 13:
                    System.out.println("Caixa na Dock 1 (P0.0): " + SplitterConveyor.isBoxAtDock1());
                    System.out.println("Caixa na Dock 2 (P1.7): " + SplitterConveyor.isBoxAtDock2());
                    break;
                case 14:
                    System.out.println("Sensor de Identificação (0=nenhum, 1=P1.5, 2=P1.6): " + SplitterConveyor.getIdentificationSensors());
                    break;
                case 15:
    try {
        mechanism.conveyorMove();

        CylinderThread clStartT = new CylinderThread(cylinderStart);
        BoxIdentificationThread boxIDT = new BoxIdentificationThread();

        System.out.println("A introduzir e identificar caixa...");
        boxIDT.start();
        clStartT.start();

        clStartT.join(); // Espera que o CylinderStart empurre e recolha
        boxIDT.join();   // Espera que a caixa chegue a P0.0 e termine a leitura

        mechanism.conveyorStop(); // Para o tapete na Dock 1 para poderes inspecionar!

        int boxID = boxIDT.getBoxIdentification();
        System.out.println("Caixa identificada: Tipo " + boxID);
        System.out.println("Confirmar sensor P0.0 (Dock 1): " + SplitterConveyor.isBoxAtDock1());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    break;
            }
        }
        sc.close();
    }
}