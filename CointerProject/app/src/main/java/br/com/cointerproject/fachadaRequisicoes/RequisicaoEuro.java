package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.widget.TextView;

public class RequisicaoEuro extends RequisicaoMoeda {
    public RequisicaoEuro(Context contexto) {
        super(contexto);
    }

    @Override
    public void consultarValor(String nomeMoeda, TextView campoValorMoeda) throws Exception {
        super.consultar(nomeMoeda, campoValorMoeda);
    }
}
