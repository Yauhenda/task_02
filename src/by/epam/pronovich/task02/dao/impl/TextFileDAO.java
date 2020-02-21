package by.epam.pronovich.task02.dao.impl;

import by.epam.pronovich.task02.dao.FileDAO;
import by.epam.pronovich.task02.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFileDAO implements FileDAO {

    private static final Path PATH_TO_FILE = Paths.get("src", "by", "epam", "pronovich", "task02",
            "res", "text.txt");

    @Override
    public String readFile() throws DAOException {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> text = Files.readAllLines(PATH_TO_FILE);
            for (String s : text) {
                stringBuilder.append(s).append("\n");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return stringBuilder.toString();
    }
}
