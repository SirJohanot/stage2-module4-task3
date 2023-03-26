package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.stream.Stream;

public class LexemeParser extends AbstractTextParser {

    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        Stream.of(string.split(LEXEME_REGEX))
                .filter(s -> s.matches(WORD_REGEX))
                .forEach(s -> {
                    TextComponent textComponent = new TextComponent(TextComponentType.WORD);
                    nextParser.parse(textComponent, s);
                    abstractTextComponent.add(textComponent);
                });
    }

}
