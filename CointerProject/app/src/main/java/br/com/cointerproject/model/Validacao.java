package br.com.cointerproject.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean validarEmail(String email){
        Matcher matcher  = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validarSenha(String senha, String nome) {
        return (senha.length() >= 8 && nome.length() > 0 ? true : false);

    }

}
