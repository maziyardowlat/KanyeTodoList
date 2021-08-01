package persistence;


import model.TodoList;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.io.*;

//Represents a writer that writes JSON representation of TodoList to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String designated;

    //EFFECTS; constructs a writer to the destination file
    public JsonWriter(String designated) {
        this.designated = designated;
    }

    // MODIFIES: this
    // EFFECTS: opens writer, and throws a file exception if the destination file cannot be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(designated));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of TodoList to file
    public void write(TodoList tl) {
        JSONObject json = tl.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}

