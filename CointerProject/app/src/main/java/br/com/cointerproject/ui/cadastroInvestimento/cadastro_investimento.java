package br.com.cointerproject.ui.cadastroInvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.cointerproject.R;

public class cadastro_investimento extends AppCompatActivity {

    private Button cadastro;
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
        cadastro = findViewById(R.id.btcadastrar);
        spinnerMercado = findViewById(R.id.spinermercado);
        spinnerFonte = findViewById(R.id.spinerfonte);
    }

    public void ouvinte (View view) {
        if (estaVazio()){
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_LONG);
        }
    }


    private boolean estaVazio(){
        String campoNome = nome.getText().toString();
        String campoValor = nome.getText().toString();

        if (campoNome.isEmpty() || campoValor.isEmpty()){
            return false;
        }
        return true;
    }
}
