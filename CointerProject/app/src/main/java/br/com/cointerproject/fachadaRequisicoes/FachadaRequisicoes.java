package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.widget.TextView;

public class FachadaRequisicoes {

    private ITrequisicoes requisicao;

    // O método abaixo verifica qual foi a moeda escolhida e chama seu respectivo método.
    public void consultar(Context context, String nomeMoeda, Object areaValorMoeda) throws Exception {

        switch(nomeMoeda.toUpperCase()) {
            case "DOLAR":
            case "DOLAR CANADENSE":
            case "EURO":
            case "LIBRA":
                requisicao = new RequisicaoFiatCoin(context);
                requisicao.consultar(nomeMoeda, (TextView) areaValorMoeda);
                break;
            case "BCASH":
            case "BITCOIN":
            case "ETHEREUN":
            case "LITECOIN":
            case "XRP":
                requisicao = new RequisicaoCryptoCoin(context);
                requisicao.consultar(nomeMoeda, (TextView) areaValorMoeda);
                break;
            default:
                throw new RuntimeException("Tipo de moeda inválida!");
        }

    }

    public float[] consultarDiasDaSemana(Context context, String nomeMoeda) throws Exception {
        switch(nomeMoeda.toUpperCase()) {

            case "DOLAR":
            case "DOLAR CANADENSE":
            case "EURO":
            case "LIBRA":
                requisicao = new RequisicaoFiatCoin(context);
                break;
            case "BCASH":
            case "BITCOIN":
            case "ETHEREUN":
            case "LITECOIN":
            case "XRP":
                requisicao = new RequisicaoCryptoCoin(context);
                break;
            default:
                throw new RuntimeException("Tipo de moeda inválida!");
        }

        return requisicao.consultarDias(nomeMoeda);
    }

}

