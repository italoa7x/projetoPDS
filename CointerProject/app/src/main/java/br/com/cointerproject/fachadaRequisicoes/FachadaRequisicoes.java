package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.widget.TextView;

public class FachadaRequisicoes {

    private ITrequisicoes requisicao;

    // O método abaixo verifica qual foi a moeda escolhida e chama seu respectivo método.
    public void consultar(Context context, String nomeMOeda, Object areaValorMoeda) throws Exception {
        switch(nomeMOeda.toUpperCase()) {
            case "DOLAR":
                recuperarDolar(context, areaValorMoeda);
                break;
            case "DOLAR CANADENCE":
                recuperarDolarCan(context, areaValorMoeda);
                break;
            case "BCASH":
                consultarBCash(context, areaValorMoeda);
                break;
            case "BITCOIN":
                consultarBitcoin(context, areaValorMoeda);
                break;
            case "ETHEREUN":
                consultarEthereun(context, areaValorMoeda);
                break;
            case "EURO":
                consultarEuro(context, areaValorMoeda);
                break;
            case "LIBRA":
                consultarLibra(context, areaValorMoeda);
                break;
            case "LITECOIN":
                consultarLiteCoin(context, areaValorMoeda);
                break;
            case "XRP":
                consultarXRP(context, areaValorMoeda);
                break;
            default:
                throw new RuntimeException("Tipo de moeda inválida!");
        }

    }
    // Abaixo estão os método que chamam os métodos responsáveis pela requisição.

    private void consultarBitcoin(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoBitcoin(contexto);
        requisicao.consultar("BTC", (TextView) areaValorMoeda);
    }
    private void consultarDolar(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoDolar(contexto);
        requisicao.consultar("USD", (TextView) areaValorMoeda);
    }

    private void consultarLibra(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoLibra(contexto);
        requisicao.consultar("GBP", (TextView) areaValorMoeda);
    }

    private void consultarEuro(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoEuro(contexto);
        requisicao.consultar("EUR", (TextView) areaValorMoeda);
    }

    private void consultarEthereun(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoEthereun(contexto);
        requisicao.consultar("ETH", (TextView) areaValorMoeda);
    }


    private void consultarBCash(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoBCash(contexto);
        requisicao.consultar("BCH", (TextView) areaValorMoeda);
    }

    private void recuperarDolarCan(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoDolarCanadence(contexto);
        requisicao.consultar("CAD", (TextView) areaValorMoeda);
    }


    private void consultarLiteCoin(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoLiteCoin(contexto);
        requisicao.consultar("LTC", (TextView) areaValorMoeda);
    }

    private void consultarXRP(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoBCash(contexto);
        requisicao.consultar("XRP", (TextView) areaValorMoeda);
    }

    private void recuperarDolar(Context contexto, Object areaValorMoeda) throws Exception {
        requisicao = new RequisicaoDolar(contexto);
        requisicao.consultar("USD", (TextView) areaValorMoeda);
    }
}

