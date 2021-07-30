package persistence;


import model.TodoList;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.io.*;


public class JsonWriter {
    //Represents a writer that writes JSON representation of TodoList to file
    private static final int TAB = 4;
    private PrintWriter writer;
    private String designated;

    //EFFECTS; constructs a writer to the destination file
    public JsonWriter(String designated) {
        this.designated = designated;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(designated));
    }

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

