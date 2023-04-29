package hotelProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

public class HouseKeeping {

    private String filePath = "src/main/java/hotelProject/RoomStatusDataFile.csv";
    private final Logger logger = LogManager.getLogger(HouseKeeping.class.getName());

    protected File createRoomStatusDataFile() {
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new IllegalArgumentException(e);
        }
    }

    protected void addRoomStatusToFile(File file, boolean append){
        try (
                FileWriter fileWriter = new FileWriter(file, append);
                PrintWriter writer = new PrintWriter(fileWriter);
        ) {
            writer.write("\n1716, KING_WATERVIEW_BALCONY, READY");
        } catch (IOException e) {
            //System.out.println(e.getMessage());
            logger.error(e.getMessage(), e);
        }
    }

    public void displayRoomStatusData()  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = reader.readLine()) !=null){
                System.out.println(line);
            }
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
