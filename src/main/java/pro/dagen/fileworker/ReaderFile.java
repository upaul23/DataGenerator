package pro.dagen.fileworker;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFile {

    public static List<String> readByLine(String path){
        InputStream inputStream = null;
        inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().collect(Collectors.toList());
    }

    public static List<String[]> parseCsv(String path){
        List<String> list = readByLine(path);
        return list.stream().map(i -> i.split(",")).collect(Collectors.toList());
    }

}
