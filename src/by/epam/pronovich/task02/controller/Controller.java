package by.epam.pronovich.task02.controller;

import by.epam.pronovich.task02.service.ServiceProvider;
import by.epam.pronovich.task02.service.TextInfoService;

public class Controller {


    public int calcParagraphQuant() {
        TextInfoService textInfoService = ServiceProvider.getINSTANCE().getTextInfoService();
        return textInfoService.calcParagraphQuant();
    }


    public int calcSentenceQuant() {
        TextInfoService textInfoService = ServiceProvider.getINSTANCE().getTextInfoService();
        return textInfoService.calcSentenceQuant();
    }


    public int calcWordQuant() {
        TextInfoService textInfoService = ServiceProvider.getINSTANCE().getTextInfoService();
        return textInfoService.calcWordQuant();
    }


    public int calcSymbolQuant() {
        TextInfoService textInfoService = ServiceProvider.getINSTANCE().getTextInfoService();
        return textInfoService.calcSymbolQuant();
    }


    public String findLongestWord() {
        TextInfoService textInfoService = ServiceProvider.getINSTANCE().getTextInfoService();
        return textInfoService.findLongestWord();
    }

}
