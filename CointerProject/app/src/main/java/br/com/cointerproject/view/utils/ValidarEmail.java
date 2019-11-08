package br.com.cointerproject.view.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ValidarEmail {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean validar(String email){
        Matcher matcher  = pattern.matcher(email);
        return matcher.matches();
    }

}
