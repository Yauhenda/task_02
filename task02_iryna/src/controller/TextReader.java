package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader implements ReaderInterface {
    public static final String PARAGRAPH_MATCH = "[A-Z].*[\\n\\r\\t\\.]";

    public String read(String string) throws IOException {
        List<String> lines;
        StringBuilder text = new StringBuilder();
        try{
            lines = Files.readAllLines(Paths.get(string), Charset.forName("UTF-8"));
        }
        catch (IOException e){
            throw new IOException("File doesn't exist");
        }
        for (String line: lines){
            if (line.matches(PARAGRAPH_MATCH)){
                text.append("\t");
            }
            text.append(line);
        }
        return text.toString();
    }
}
