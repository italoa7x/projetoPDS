package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.widget.TextView;

public class RequisicaoXRP extends RequisicaoCripto {
    public RequisicaoXRP(Context contexto) {
        super(contexto);
    }

    @Override
    public void consultarValor(String nomeMoeda, TextView campoValorMoeda) throws Exception {
        super.consultar(nomeMoeda, campoValorMoeda);
    }
}
