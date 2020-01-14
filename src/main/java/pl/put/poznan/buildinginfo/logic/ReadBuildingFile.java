package pl.put.poznan.buildinginfo.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasa znajdująca  plik i wczytująca ścieżkę do pamięci jako string
 */
public class ReadBuildingFile {
    /**
     * Metoda prywatna pobierająca dane z pliku i generująca budynek
     * @param filename  nazwa pliku
     * @return
     */
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

    /**
     * metoda konwerująca plik do ścieżki dostępu
     * @param filename nazwa pliku
     * @return
     */
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
