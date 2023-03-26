package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser {

    public WordParser() {
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        string.chars()
                .mapToObj(c -> new SymbolLeaf((char) c))
                .forEach(abstractTextComponent::add);
    }
}
