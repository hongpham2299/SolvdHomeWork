package hotelProject;

import java.io.*;

public class HouseKeeping {

    private String filePath = "src/main/java/hotelProject/RoomStatusDataFile.csv";

    protected File createRoomStatusDataFile() {
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
