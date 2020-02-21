package by.epam.pronovich.task02.dao;

import by.epam.pronovich.task02.dao.impl.TextFileDAO;

public class DAOProvider {

    private static final DAOProvider INSTANCE = new DAOProvider();

    private FileDAO fileDAO = new TextFileDAO();

    private DAOProvider() {
    }

    public FileDAO getFileDAO() {
        return fileDAO;
    }

    public static DAOProvider getINSTANCE() {
        return INSTANCE;
    }
}
