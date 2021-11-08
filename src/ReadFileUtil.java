import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: ReadFileUtil
 * @description: util class to read file
 * @author: Yan Tong
 **/
public class ReadFileUtil {
    public static List<String> readFile(String path) {
        List<String> res = new ArrayList<>();
        try {
            File file = new File(path);    //creates a new file instance
            BufferedReader br = new BufferedReader(new FileReader(file));  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
            br.close();    //closes the stream and release the resources
        } catch (IOException e) {
            System.out.println("read file error");
            e.printStackTrace();
        }
        return res;
    }

    public static List<String> splitString(String s, String regex) {
        List<String> res = new ArrayList<>();
        String[] splits = s.split(regex);
        for(String split : splits) {
            // discard all empty string in splits array
            if(split.length() != 0) {
                res.add(split);
            }
        }
        return res;
    }
}
