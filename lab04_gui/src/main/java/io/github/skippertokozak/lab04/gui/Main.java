package io.github.skippertokozak.lab04.gui;
import io.github.skippertokozak.lab04.client.ClientRun;
import io.github.skippertokozak.lab04.gui.window.Window;


public class Main {
    public static void main(String[] args) {

        ClientRun clientRun = new ClientRun();
        clientRun.run();
        Window window = new Window();
        window.setVisible(true);


        System.out.println("Hello world!");
    }
}