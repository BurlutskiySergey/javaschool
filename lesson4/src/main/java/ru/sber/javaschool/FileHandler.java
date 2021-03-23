package ru.sber.javaschool;

import lombok.Data;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Data
public class FileHandler {
    private File inputFile;
    private File outputFile;
    private char replacementSymbol;
    private static final char NEW_SYMBOL = ' ';

    /**
     * Заменить символ в файле.
     *
     * @param replacementSymbol - Символ на замену.
     */
    public void replaceSymbolInFile(char replacementSymbol) throws IOException {
        this.replacementSymbol = replacementSymbol;
        this.inputFile = new File("lesson4/src/main/resources/input.txt");
        this.outputFile = new File(inputFile.getAbsolutePath().replace(inputFile.getName(),"output.txt"));
        InputStream inputStream = new FileInputStream(inputFile);
        Reader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        OutputStream outputStream = new FileOutputStream(outputFile);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        int data = inputStreamReader.read();
        while(data != -1) {
            char currentSymbol;
            currentSymbol = (char)Integer.parseInt(String.valueOf(data));

            if (checkSymbolsEquality(currentSymbol)) {
                data = NEW_SYMBOL;
            }
            outputStreamWriter.write(data);
            data = inputStreamReader.read();
        }
        inputStreamReader.close();
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }


    /**
     * Проверить символ на равенство заменяемому символу.
     *
     * @param symbol - Символ на замену.
     */
    public boolean checkSymbolsEquality(char symbol) {
        return (symbol == replacementSymbol);
    }
}
