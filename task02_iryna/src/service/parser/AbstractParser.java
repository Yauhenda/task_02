package service.parser;

import dao.LeafWord;

public abstract class AbstractParser implements ParserChain {
    private AbstractParser next;

    @Override
    public ParserChain linkWith(ParserChain next) {
        ((AbstractParser) next).next = this;
        return next;
    }

    public LeafWord nextParse(String line){
        if (next != null){
            return next.parseLine(line);
        } else {
            return null;
        }
    }
}
