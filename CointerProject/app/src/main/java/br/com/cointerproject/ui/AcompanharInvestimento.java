package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;
import br.com.cointerproject.R;
import br.com.cointerproject.model.Investimento;

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

        Intent it = getIntent();
        Investimento parametro = (Investimento) it.getSerializableExtra("investimento");
        moeda.setText(parametro.getMoeda());
        status.setText(parametro.getStatus());
        valor.setText(String.valueOf(parametro.getValor()));

      //  TextView nome = (TextView) findViewById(R.id.textView);
      //  nome.setText(parametro);

    }
}
