package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 *
 * @author WINDOWS 8
 *
 */
public class CSVReader {

    public static void main(String... args) {
        List<Data> data = readCSVFile("C:\\Users\\BT_1N3_03\\IdeaProjects\\CSV-Tutorial\\src\\sample\\2012_SAT_Results.csv");

        // let's print all the person read from CSV file
        for (Data b : data) {
            System.out.println(b);
        }
    }

    public static List<Data> readCSVFile(String fileName) {
        List<Data> dataSet = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                System.out.println(Arrays.toString(attributes));

                Data data = createData(attributes);

                // adding book into ArrayList
                dataSet.add(data);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return dataSet;
    }

    private static Data createData(String[] metadata) {
        String DBN = metadata[0];
        String school = metadata[1];
        int numSat = Integer.parseInt(metadata[2]);
        int reading = Integer.parseInt(metadata[3]);
        int math = Integer.parseInt(metadata[4]);
        int writing = Integer.parseInt(metadata[5]);

        // create and return book of this metadata
        return new Data(DBN, school, numSat, reading, math, writing);
    }

}

class Data {
    private String DBN;
    private String school;
    private int numSAT;
    private int reading;
    private int math;
    private int writing;

    public Data(String DBN, String school, int numSAT, int reading, int math, int writing) {
        this.DBN = DBN;
        this.school = school;
        this.numSAT = numSAT;
        this.reading = reading;
        this.math = math;
        this.writing = writing;
    }

    public String getDBN() {
        return DBN;
    }

    public void setDBN(String DBN) {
        this.DBN = DBN;
    }

    public String getSchool(String school)
    {
        return school;
    }

    public int getNumSAT() {
        return numSAT;
    }

    public void setNumSAT(int numSAT) {
        this.numSAT = numSAT;
    }

    public int getMath() {
        return math;
    }

    public void setMAth(int math) {
        this.math = math;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public int getWriting() {
        return writing;
    }

    public void setWriting(int writing) {
        this.writing = writing;
    }

    @Override
    public String toString() {
        return "DBN: " + DBN + ", School: " + school + ", Number of SAT Takers: " + numSAT + ", Average SAT Reading: " + reading + ", Average SAT Math: " + math + ", Average SAT Writing: " + writing;
    }

}