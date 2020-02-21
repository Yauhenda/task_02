package by.epam.pronovich.task02.service;

import by.epam.pronovich.task02.entity.Composite;
import by.epam.pronovich.task02.entity.Leaf;
import by.epam.pronovich.task02.exception.ServiceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface TextParsService {



    Composite parse() throws ServiceException;

    Composite parseParagrapher(Composite allText, String fileText);

    Composite parseSentence(Composite paragraphComp, String paragraph);

    Composite parseWord(Composite sentenceComp, String sentence);

    Composite parseSymbol(Composite wordComp, String word);

}
