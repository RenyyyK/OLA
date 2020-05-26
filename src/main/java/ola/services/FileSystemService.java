package ola.services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String APPLICATION_FOLDER = "src";
    private static final String USER_FOLDER = System.getProperty("user.dir");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        /*
        System.out.println(USER_FOLDER);
        System.out.println(APPLICATION_FOLDER);
        System.out.println(APPLICATION_HOME_PATH);
        System.out.println(APPLICATION_HOME_PATH.resolve(Paths.get("main", path)));
        */
        return APPLICATION_HOME_PATH.resolve(Paths.get("main", path));
    }
}
