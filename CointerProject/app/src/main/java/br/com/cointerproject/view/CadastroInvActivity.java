package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

import br.com.cointerproject.R;
import br.com.cointerproject.model.Investimento;
import br.com.cointerproject.model.Mercado;
import br.com.cointerproject.ui.ListaInvestimento;
import br.com.cointerproject.ui.MoneyTextWatcher;

public class CadastroInvActivity extends AppCompatActivity {

    private Spinner spinnerMercado;
    private Spinner spinnerFonte;
    private EditText nome;
    private EditText valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_investimento);

        nome = findViewById(R.id.txnome);
        valor = findViewById(R.id.txvalor);
        spinnerMercado = findViewById(R.id.spinermercado);
        spinnerFonte = findViewById(R.id.spinerfonte);
        String[] mercado = {"Selecione uma moeda",Mercado.FOREX.name()};
        ArrayAdapter<String> adapterMercado = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, mercado);
        String[] moedas = {"Selecione uma moeda", "Dolar","Euro","Libra", "Dolar Canadence","Bitcoin","LiteCoin","Ethereun","BCash","XRP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, moedas);
        spinnerFonte.setAdapter(adapter);
        spinnerMercado.setAdapter(adapterMercado);
        Locale mLocale = new Locale("pt", "BR");
        valor.addTextChangedListener(new MoneyTextWatcher(valor));

    }

    public void ouvinte (View view) {

        String nomeS = nome.getText().toString();

        Double valorI = Double.parseDouble(MoneyTextWatcher.formatPriceSave((valor.getText().toString())));
        if (nomeS.isEmpty() || valor.getText().toString().isEmpty() || spinnerMercado.getSelectedItemPosition()==0 || spinnerFonte.getSelectedItemPosition()==0){
            Toast.makeText(CadastroInvActivity.this,"Preencha todos os campos",Toast.LENGTH_LONG);
        }
        else{

            String mercado = (String) spinnerMercado.getSelectedItem();
            String moeda = (String) spinnerFonte.getSelectedItem();
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            Investimento investimento = new Investimento(nome.getText().toString(),valorI,moeda);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid);
            ref.push().setValue(investimento);
            Toast.makeText(CadastroInvActivity.this, "Investimento Cadastrado", Toast.LENGTH_LONG).show();
            Intent it = new Intent(CadastroInvActivity.this, ListaInvestimento.class);
            startActivity(it);
        }
    }



}
