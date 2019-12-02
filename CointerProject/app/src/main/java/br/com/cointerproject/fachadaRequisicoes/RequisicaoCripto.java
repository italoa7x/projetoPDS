package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class RequisicaoCripto implements ITrequisicoes {
    private RequestQueue fila;

    public RequisicaoCripto(Context contexto){
        fila = Volley.newRequestQueue(contexto);
    }


    @Override
    public void consultar(String moeda, final TextView campoValorMoeda) throws Exception {
        String uri = "https://www.mercadobitcoin.net/api/"+ moeda +"/ticker";
        JsonObjectRequest obj = new JsonObjectRequest(Request.Method.GET, uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String valorMoeda = response.getJSONObject("ticker").getString("buy");
                            campoValorMoeda.setText(String.format("%.6s", valorMoeda));
                        } catch (JSONException e) {
                            throw new RuntimeException("Erro ao consultar bitcoin "+e.getMessage());
                        }
                    }
                }, null);
        fila.add(obj);
    }

    public abstract void consultarValor(String nomeMoeda, TextView campoValorMoeda) throws Exception;
}
