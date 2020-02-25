package service.parser;

import dao.LeafWord;

public interface ParserChain {
   LeafWord parseLine(String string);

   ParserChain linkWith( ParserChain next);

}
