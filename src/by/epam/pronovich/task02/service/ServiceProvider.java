package by.epam.pronovich.task02.service;

import by.epam.pronovich.task02.service.impl.TextInfo;
import by.epam.pronovich.task02.service.impl.TextParser;

public class ServiceProvider {

    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private TextParsService textParsService = new TextParser();
    private TextInfoService textInfoService = new TextInfo();


    public ServiceProvider() {
    }

    public TextParsService getTextParsService() {
        return textParsService;
    }

    public TextInfoService getTextInfoService() {
        return textInfoService;
    }

    public static ServiceProvider getINSTANCE() {
        return INSTANCE;
    }
}
