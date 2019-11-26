package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

/**
 * gamedata
 */
public class GameData {

    private ArrayList<String> Categories = new ArrayList<String>();
    private ArrayList<String> IceBreakers = new ArrayList<String>();
    private ArrayList<String> Countries = new ArrayList<String>();
    private ArrayList<String> Movies = new ArrayList<String>();
    private ArrayList<String> GameData = new ArrayList<String>();
    // ArrayList<String> lines = new ArrayList<String>();
    // String line = null;

    public ArrayList<String> getCategories() {
        return this.Categories;
    }

    public ArrayList<String> getIceBreakers() {
        return this.IceBreakers;
    }

    public ArrayList<String> getCountries() {
        return this.Countries;
    }

    public ArrayList<String> getMovies() {
        return this.Movies;
    }

    // D:\\Sem_Troisieme\\JAVA\\Projects\\Project\\src\\app\\dataFile.txt
    public void createData() {
        File file = new File("D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\dataFile.txt  ");
        try {
            short i = 0;
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isEmpty()) {
                    for (short x = 0; x < 10; x++) {
                        String Question = reader.nextLine();
                        String Answer = reader.nextLine();
                        if (i == 0) {
                            this.IceBreakers.add(Question);
                            this.IceBreakers.add(Answer);
                        }
                        if (i == 1) {
                            this.Countries.add(Question);
                            this.Countries.add(Answer);
                        }
                        if (i == 2) {
                            this.Movies.add(Question);
                            this.Movies.add(Answer);
                        }
                        if (i == 3) {
                            break;
                        }
                    }
                    i++;
                }
                if (i == 0) {
                    this.Categories.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
    }

    public void modifyData(String oldLine, String newLine) throws IOException {
        String filePath = "D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\dataFile.txt";
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    public void eraseData() {
        this.Categories.clear();
        this.Countries.clear();
        this.IceBreakers.clear();
        this.Movies.clear();
    }
}