package by.epam.pronovich.task02.dao;

import by.epam.pronovich.task02.exception.DAOException;

public interface FileDAO {

    String readFile() throws DAOException;
}
