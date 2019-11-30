package pl.put.poznan.buildinginfo.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadBuildingFile {
    private File getFileFromResources(String filename)
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public String toString(String filename)
    {
        String filepath = getFileFromResources(filename + ".json").getPath();
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
