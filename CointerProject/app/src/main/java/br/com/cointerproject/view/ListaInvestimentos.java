package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import br.com.cointerproject.R;
import br.com.cointerproject.model.FirebaseHelper;
import br.com.cointerproject.model.Investimento;
import br.com.cointerproject.ui.AcompanharInvestimento;
import br.com.cointerproject.ui.RecyclerConfig;

public class ListaInvestimentos extends AppCompatActivity {
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_investimentos);
        recycler = findViewById(R.id.recycler_investimentos);
        new FirebaseHelper().recuperar(new FirebaseHelper.DataStatus() {
            @Override
            public void isLoaded(List<Investimento> investimentos, List<String> keys) {
                new RecyclerConfig().setConfig(recycler,ListaInvestimentos.this,investimentos,keys);
            }

            @Override
            public void inserted() {

            }

            @Override
            public void updated() {

            }

            @Override
            public void deleted() {

            }
        });
    }



    @Override
    public void onBackPressed() {
        Intent it = new Intent(ListaInvestimentos.this, Home.class);
        startActivity(it);
    }
}
