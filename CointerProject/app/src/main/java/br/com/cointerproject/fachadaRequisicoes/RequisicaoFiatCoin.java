package br.com.cointerproject.fachadaRequisicoes;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class RequisicaoFiatCoin implements ITrequisicoes {

    private RequestQueue fila;

    public RequisicaoFiatCoin(Context contexto){
        fila = Volley.newRequestQueue(contexto);
    }

    public String getCodigoMoeda(String moeda) {
        switch(moeda.toUpperCase()) {
            case "DOLAR":
                return "USD";
            case "DOLAR CANADENSE":
                return "CAD";
            case "EURO":
                return "EUR";
            case "LIBRA":
                return "GBP";
        }

        return null;
    }

    public void consultar(String moeda, final TextView campoValorMoeda) throws Exception {
        String codMoeda = getCodigoMoeda(moeda);

        String uri = "https://api.exchangeratesapi.io/latest?base=" + codMoeda;
        JsonObjectRequest obj = new JsonObjectRequest(Request.Method.GET, uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String valorMoeda = response.getJSONObject("rates").getString("BRL");
                            campoValorMoeda.setText(String.format("%.6s", valorMoeda));
                        } catch (JSONException e) {
                            throw new RuntimeException("Erro ao consultar moeda " + e.getMessage());
                        }
                    }
                }, null);
        fila.add(obj);
    }

    public float[] consultarDias(String moeda) throws Exception {
        String codMoeda = getCodigoMoeda(moeda);
        String url = "https://economia.awesomeapi.com.br/json/list/" + codMoeda + "-BRL/7";
        final float[] valores = new float[7];

        AsyncTask<String, String, String> jsonTask = new JsonTask().execute(url);
        String jsonData = jsonTask.get();
        System.out.println(jsonData);

        JSONArray jArr = new JSONArray(jsonData);

        int indice = 6;
        for(int i = 0; i < jArr.length(); i++) {
            JSONObject jObj2 = jArr.getJSONObject(i);
            float valor =  Float.parseFloat(jObj2.getString("high"));
            valores[indice] = valor;
            indice--;
        }

        return valores;
    }

}
