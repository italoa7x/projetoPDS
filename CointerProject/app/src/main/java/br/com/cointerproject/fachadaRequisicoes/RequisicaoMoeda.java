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

public abstract class RequisicaoMoeda implements ITrequisicoes {
    private RequestQueue fila;

    public RequisicaoMoeda(Context contexto){
        fila = Volley.newRequestQueue(contexto);
    }

    @Override
    public void consultar(String moeda, final TextView campoValorMoeda) throws Exception {
        String uri = "https://api.exchangeratesapi.io/latest?base="+moeda;
        JsonObjectRequest obj = new JsonObjectRequest(Request.Method.GET, uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String valorMoeda = response.getJSONObject("rates").getString("BRL");
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
