package Stage2.io.MainTask;

import java.io.File;

public class MainTaskRunner {

    public static void main(String[] args) {
        String path = args[0];
        File file = new File(path);
        if (file.isDirectory()) {
            new Methods().treeView(path);
        } else {
            new Methods().getNumberOfDirectories(path);
        }
    }
}

