package homeWorkEight;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        Logger logger = LogManager.getLogger(Main.class.getName());

        File file = new File("src/main/java/homeWorkEight/LearningFileUtils.text");

        //Read text from the file
        String contents = " ";
        try {
            contents = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            logger.info(contents);
        } catch (IOException e) {
            logger.error("Exception: Reading file error - " + e.getMessage());
        }

        String lowerCaseContents = StringUtils.lowerCase(contents);

        //Calculate the numbers of the unique words
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(lowerCaseContents);

        Set<String> set =  new HashSet<>();
        int i=0;
        while (m.find()) {
            i++;
            set.add(m.group());
        }

        logger.info("Total words count are: " + i);
        logger.info("Total unique words count are: " + set.size());

        //Write the result to the file
        String totalUniqueWordsCount = "\nWrite the result to the file - Total unique words count are: " + set.size();
        try {
            FileUtils.writeStringToFile(file, totalUniqueWordsCount, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            logger.error("Exception: Writing file error - " + e.getMessage());
        }
    }
}
