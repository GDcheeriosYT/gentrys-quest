import java.io.*;

import Settings.*;

import org.fusesource.jansi.*;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color;
import okhttp3.*;

class Main{
  OkHttpClient client = new OkHttpClient();
  public static void main(String[] args) throws IOException {
    AnsiConsole.systemInstall();
    AnsiConsole.out().println( ansi().eraseScreen().render("@|green args[0]|@ @|red args[1]|@ @|blue args[2]|@") );
  }

  public String run(String url) throws IOException {
    Request request = new Request.Builder()
            .url(url)
            .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }
}