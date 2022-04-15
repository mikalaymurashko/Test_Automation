package Stage2.io.MainTask;

import java.io.File;

public class MainTaskRunner {

    public static void main(String[] args) {

        String path = args[0];
        File check = new File(path);
        if (check.isDirectory()) {
            new Methods().TreeView(path);
        } else {
            new Methods().getNumberOfDirectories(path);
        }
//        new Methods().TreeView(args[0]);
//        new Methods().getNumberOfDirectories("E:/Test_Automation/src/main/java/Stage2/I_O/mainTask.txt");
//        new Methods().getNumberOfDirectories("E:/Music/Enter_Shikari/Albums");
    }
}

