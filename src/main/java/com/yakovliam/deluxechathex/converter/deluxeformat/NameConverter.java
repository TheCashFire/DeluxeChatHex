package com.yakovliam.deluxechathex.converter.deluxeformat;

import com.yakovliam.deluxechathex.converter.Converter;
import com.yakovliam.deluxechathex.model.formatting.Extra;
import com.yakovliam.deluxechathex.model.formatting.FormatPart;
import com.yakovliam.deluxechathex.model.formatting.action.ClickAction;
import com.yakovliam.deluxechathex.model.formatting.action.ClickActionType;
import com.yakovliam.deluxechathex.model.formatting.action.HoverAction;
import com.yakovliam.deluxechathex.util.Triple;

import java.util.List;

public class NameConverter implements Converter<Triple<String, List<String>, String>, FormatPart> {

    /**
     * Converts a k into a v
     *
     * @param stringStringStringTriple k
     * @return v
     */
    @Override
    public FormatPart convert(Triple<String, List<String>, String> stringStringStringTriple) {
        String name = stringStringStringTriple.getLeft();
        List<String> nameTooltip = stringStringStringTriple.getCenter();
        String nameClickCmd = stringStringStringTriple.getRight();

        Extra extra = new Extra(nameClickCmd != null
                ? new ClickAction(ClickActionType.SUGGEST_COMMAND, nameClickCmd) : null,
                new HoverAction(nameTooltip));

        return new FormatPart(name, extra);
    }
}
