//package IO;
//
//import org.json.JSONObject;
//
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Write {
//    public static void writeTo(String fileName, String content) throws IOException {
//        FileWriter file = new FileWriter(fileName);
//        file.write(content);
//        file.flush();
//    }
//
//    public static void clearData() throws FileNotFoundException {
//
//        String jsonData = "{\n" +
//                "  \"startupamount\" : 0,\n" +
//                "  \"inventory\" : {\n" +
//                "    \"money\" : 0,\n" +
//                "    \"characters\" : [],\n" +
//                "    \"weapons\" : [],\n" +
//                "    \"artifacts\" : []\n" +
//                "  },\n" +
//                "  \"settings\" : {\n" +
//                "    \"debug\" : false,\n" +
//                "    \"no timeout\" : false\n" +
//                "  },\n" +
//                " \"server\" : {\n" +
//                "   \"ip\" : \"http://gdcheerios.com\",\n" +
//                "   \"port\" : 80\n" +
//                "  }\n" +
//                "}";
//
//        writeTo(gameDataFilePath, new JSONObject(jsonData).toString(4));
//        clearConsole();
//        System.out.println("cleared data");
//    }
//}