package InterfaceManager.GameInterfaces;

import InterfaceManager.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenuInterface {
    private Interface mainMenu;

    public MainMenuInterface(){

    }

    public void show(){
        OptionGroup options = new OptionGroup(new ArrayList<>(List.of(
                new Option("play"),
                new Option("settings", new SettingsInterface().show()),
                new Option("quit", new Runnable() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                })
        )));
        this.mainMenu = new Interface("Gentry's Quest");
    }
}
