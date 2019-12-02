package br.com.cointerproject.fachadaRequisicoes;

import android.widget.TextView;

public interface ITrequisicoes {

    public void consultar(String moeda, TextView campoValorMoeda) throws Exception;
}
