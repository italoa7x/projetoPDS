package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;
import br.com.cointerproject.R;

public class AcompanharInvestimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhar_investimento);
        Intent it = getIntent();
        String parametro = (String) it.getSerializableExtra("nome");
      //  TextView nome = (TextView) findViewById(R.id.textView);
      //  nome.setText(parametro);
    }
}
