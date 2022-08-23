import java.io.*;

import Inventory.Inventory;
import Settings.*;
import ConsoleMethods.ConsoleMethods;
import InterfaceManager.GameInterfaces.*;

import User.User;
import org.fusesource.jansi.*;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color;


class Main{
  static Data gameData = new Data();
  static User user;
  static Inventory inventory;

  public static void main(String[] args) throws IOException {
    AnsiConsole.systemInstall();
    AnsiConsole.out().println( ansi().eraseScreen().fg(Color.RED).a(args[0]).fg(Color.GREEN).a(" " + args[1]).fg(Color.BLUE).a(" " + args[2]).reset() );
    gameData.getSaveDataFromServer(args[0], args[1], args[2]);
    inventory = gameData.loadData();
    user = new User(args[0], inventory);
    ConsoleMethods.clearConsole();
    AnsiConsole.out().println( ansi().eraseScreen().a("welcome " + args[0]).reset() );
    ConsoleMethods.timeout(1000, false);
    MainMenuInterface.show();
  }
}