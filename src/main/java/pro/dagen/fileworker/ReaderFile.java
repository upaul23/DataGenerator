package pro.dagen.fileworker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFile {

    static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("dictionary").getPath();

    public static List<String> readByLine(String path){
        String fullPath = rootPath + path;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fullPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader reader = new BufferedReader(fileReader);
        return reader.lines().collect(Collectors.toList());
    }

    public static List<String[]> parseCsv(String path){
        List<String> list = readByLine(path);
        return list.stream().map(i -> i.split(",")).collect(Collectors.toList());
    }

}
