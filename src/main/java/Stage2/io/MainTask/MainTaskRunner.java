package Stage2.io.MainTask;

import java.io.File;

public class MainTaskRunner {

    public static void main(String[] args) {
        String path = args[0];
        File check = new File(path);
        if (check.isDirectory()) {
            new Methods().treeView(path);
        } else {
            new Methods().getNumberOfDirectories(path);
        }
    }
}

