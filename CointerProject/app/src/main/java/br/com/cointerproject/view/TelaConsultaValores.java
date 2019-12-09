package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cointerproject.R;
import br.com.cointerproject.fachadaRequisicoes.*;

public class TelaConsultaValores extends AppCompatActivity {

    private TextView areaValorMoeda;
    private Spinner comboMoedas;
    private FachadaRequisicoes fachada;
    private String moedaSelecionada;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta_valores);

        fachada = new FachadaRequisicoes();
        areaValorMoeda = findViewById(R.id.txtValorMoeda);
        comboMoedas = findViewById(R.id.comboMoedas);
        String[] moedas = {"Selecione uma moeda", "Dolar","Euro","Libra", "Dolar Canadense","Bitcoin","LiteCoin","Ethereun","BCash","XRP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, moedas);
        comboMoedas.setAdapter(adapter);

        comboMoedas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moedaSelecionada = comboMoedas.getSelectedItem().toString();
                if(!moedaSelecionada.equals("Selecione uma moeda")){
                    try {
                        fachada.consultar(getApplicationContext(), moedaSelecionada, areaValorMoeda);
                    } catch (Exception e) {
                        Toast.makeText(TelaConsultaValores.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void exibirGrafico(View view) {
        Intent intent = new Intent(getApplicationContext(), GraficoActivity.class);
        intent.putExtra("moeda", moedaSelecionada);
        startActivity(intent);
    }
}
