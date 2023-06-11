package pro.dagen.fileworker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFile {

    public static List<String> readByLine(String path){
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        List<String> data = reader.lines().collect(Collectors.toList());
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static List<String[]> parseCsv(String path){
        List<String> list = readByLine(path);
        return list.stream().map(i -> i.split(",")).collect(Collectors.toList());
    }

}
