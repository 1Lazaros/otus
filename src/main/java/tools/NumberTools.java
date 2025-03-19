package tools;

//для написания методов с использованием регулярных выражений

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTools {
    public boolean isNumber(String numberStr){
        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        Matcher matcher = pattern.matcher(numberStr);
        return matcher.find();
    }
}
