import java.io.*;

import Settings.*;
import org.fusesource.jansi.*;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color;

class Main{

  public static void main(String[] args) throws IOException {
    AnsiConsole.systemInstall();
    AnsiConsole.out().println( ansi().eraseScreen().render("@|red Hello|@ @|green World of black men|@") );
  }
}