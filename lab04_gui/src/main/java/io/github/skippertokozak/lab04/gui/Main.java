package io.github.skippertokozak.lab04.gui;
import io.github.skippertokozak.lab04.client.ClientRun;
import io.github.skippertokozak.lab04.gui.window.WindowManager;


public class Main {
    public static void main(String[] args) {

        ClientRun clientRun = new ClientRun();
        clientRun.run();
        WindowManager windowManager = new WindowManager(clientRun);

    }
}