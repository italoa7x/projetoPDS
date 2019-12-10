package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.cointerproject.R;
import br.com.cointerproject.model.Investimento;
import br.com.cointerproject.view.Home;

public class AcompanharInvestimento extends AppCompatActivity {
    private TextView moeda;
    private TextView status;
    private TextView valor;
    private TextView bruto;
    private TextView liquido;
    private TextView liquidez;
    private TextView iof;
    private TextView ir;
    private TextView bvmf;
    private TextView retorno;
    private Button excluir;
    private Button editar;
    private Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhar_investimento);
        moeda = findViewById(R.id.campo_moeda);
        status = findViewById(R.id.campo_status);
        valor = findViewById(R.id.campo_investido);
        bruto = findViewById(R.id.campo_bruto);
        liquido = findViewById(R.id.campo_liquido);
        liquidez = findViewById(R.id.campo_liquidez);
        iof = findViewById(R.id.campo_iof);
        ir = findViewById(R.id.campo_ir);
        bvmf = findViewById(R.id.campo_bvmf);
        retorno = findViewById(R.id.campo_retorno);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();



        Intent it = getIntent();
        final Investimento parametro = (Investimento) it.getSerializableExtra("investimento");
        moeda.setText(parametro.getMoeda());
        status.setText(parametro.getStatus());
        valor.setText(String.valueOf(parametro.getValor()));

        excluir = findViewById(R.id.button_excluir);
        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent it = new Intent(AcompanharInvestimento.this, Home.class);
                startActivity(it);
            }
        });

        editar = findViewById(R.id.button_editar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        finalizar = findViewById(R.id.button_finalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
