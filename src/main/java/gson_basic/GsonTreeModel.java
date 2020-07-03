package gson_basic;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import util.Constants;

import java.io.FileReader;

/**
 * prepares an in-memory tree representation of the JSON document.
 * It builds a tree of JsonObject nodes.
 */
public class GsonTreeModel {

    public static void main(String[] args) {

        try {
            JsonReader reader = new JsonReader(new FileReader(Constants.STUDENTS_FILE));

            /*
             * JsonParser provides a pointer to the root node of the tree after reading the JSON.
             * Root Node can be used to traverse the complete tree.
             */
            JsonParser jsonParser = new JsonParser();
            JsonElement tree = jsonParser.parse(reader);

            JsonArray jsonArray = tree.getAsJsonArray();
            System.out.println(jsonArray.toString());

            for (JsonElement element: jsonArray) {

                if (element.isJsonObject()) {
                    JsonObject jsonObject = element.getAsJsonObject();
                    System.out.println("******");
                    System.out.println(jsonObject.get("studentId").getAsLong());
                    System.out.println(jsonObject.get("studentName").getAsString());
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
