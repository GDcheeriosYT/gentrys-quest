import java.io.*;
import java.util.ArrayList;

import InterfaceManager.Interface;
import Inventory.Inventory;
import Settings.*;
import ConsoleMethods.ConsoleMethods;
import InterfaceManager.GameInterfaces.*;

import User.User;
import org.fusesource.jansi.*;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color;

class Main{
  //initialize necessary variables
  static Data gameData = new Data();
  static User user;
  static Inventory inventory;
  static SettingManager settingManager = new SettingManager();

  //main menu initialization
  static MainMenuInterface mainMenu;

  //d

  public static void main(String[] args) throws IOException {
    //initialize AnsiConsole
    AnsiConsole.systemInstall();
    gameData.getSaveDataFromServer(args[0], args[1], args[2]);
    inventory = gameData.loadData();
    SettingManager.populateSettings(gameData.initializeSettings());
    user = new User(args[0], inventory);
    AnsiConsole.out().println( ansi().eraseScreen().a("welcome " + args[0]).reset() );
    ConsoleMethods.timeout(1000, true);
    mainMenu.display();
    mainMenu.handleInput(ConsoleMethods.getIntInput("enter an option", ConsoleMethods.rangeArrayListMaker(1, mainMenu.getOptions().getOptions().size())));
  }
}