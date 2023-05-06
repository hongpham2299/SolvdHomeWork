package homeWorkSeven;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*
        Read text from the file and calculate the numbers of the unique words. Write the result to the file.
        The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.
         */

        File file = new File("src/main/java/homeWorkSeven/LearningFileUtils.text");

        //Read text from the file
        String contents;
        try {
            contents = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(contents);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        //Calculate the numbers of the unique words
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(contents.toLowerCase());

        Set<String> set =  new HashSet<>();
        int i=0;
        while (m.find()) {
            i++;
            set.add(m.group());
        }

        System.out.println("Total words count are: " + i);
        System.out.println("Total unique words count are: " + set.size());

        //Write the result to the file
        String totalUniqueWordsCount = "\nWrite the result to the file - Total unique words count are: " + set.size();
        try {
            FileUtils.write(file, totalUniqueWordsCount, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
