package by.epam.pronovich.task02.service.impl;

import by.epam.pronovich.task02.dao.DAOProvider;
import by.epam.pronovich.task02.dao.FileDAO;
import by.epam.pronovich.task02.entity.Composite;
import by.epam.pronovich.task02.entity.Leaf;
import by.epam.pronovich.task02.exception.DAOException;
import by.epam.pronovich.task02.exception.ServiceException;
import by.epam.pronovich.task02.service.TextParsService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements TextParsService {

    private static final String LINE_SPLITTER = "[\n]";
    private static final String PARAGRAF = "\\s{4}";

    @Override
    public Composite parse() throws ServiceException {
        DAOProvider instance = DAOProvider.getINSTANCE();
        FileDAO fileDAO = instance.getFileDAO();
        String fileText = null;
        try {
            fileText = fileDAO.readFile();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        Composite allText = new Composite();
        allText = parseParagrapher(allText, fileText);
        return allText;
    }

    @Override
    public Composite parseParagrapher(Composite allText, String fileText) {
        Composite paragraphComp = new Composite();
        String paragraph;
        Pattern compile = Pattern.compile(PARAGRAF);
        Matcher matcher = compile.matcher(fileText);
        while (matcher.find()) {

            paragraph = matcher.group();
            if (Pattern.matches(PARAGRAF, paragraph)) {
                char[] chars = paragraph.toCharArray();
                for (char aChar : chars) {
                    paragraphComp.add(new Leaf(aChar));
                }
            }
            System.out.println(paragraph);

        }
        allText.add(paragraphComp);
        return allText;
    }

    @Override
    public Composite parseSentence(Composite paragraphComp, String paragraph) {
        return null;
    }

    @Override
    public Composite parseWord(Composite sentenceComp, String sentence) {
        return null;
    }

    @Override
    public Composite parseSymbol(Composite wordComp, String word) {
        return null;
    }
}
