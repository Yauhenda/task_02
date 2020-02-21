import model.Counter;
import model.Text;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) throws IOException {
        String text1 = new String(Files.readAllBytes(Paths.get("src\\text.txt"))).replace("\r", " ");
        Text text = new Text(text1);
        System.out.println(text.writeText(text));
        Counter counter = new Counter();
        System.out.println(counter.toString());
    }
}



