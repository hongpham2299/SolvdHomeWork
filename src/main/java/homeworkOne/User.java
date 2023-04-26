package homeworkOne;

public class User {
    public static void main(String[] args) {
    /*
    Create a simple system.out app. Print info about the user that should be passed to the main
    function as a parameter. Compile and run the program from the command line using javac and java from JDK.
     */

        User userOne = new User();
        String userOneInfo = userOne.getUserInfo("Hong Diaz", 25);
        System.out.println(userOneInfo);
    }

    private String getUserInfo(String name, int age){
        String userInfo = "Info - " + "User Name: " + name + " , " + "User Age: " + age;
        return userInfo;
    }
}
