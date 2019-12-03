package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.cointerproject.R;

public class Home extends AppCompatActivity {
    private TextView textoHome;
    private Button botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textoHome = findViewById(R.id.textohome);
        botao = findViewById(R.id.deslogar);
        FirebaseAuth f = FirebaseAuth.getInstance();
        FirebaseUser u = f.getCurrentUser();
        textoHome.setText(u.getDisplayName());


        botao.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void mudarTelaConsultas(View view){
        Intent it = new Intent(Home.this, TelaConsultaValores.class);
        startActivity(it);
    }

    public void telaCadastroI(View view){
        Intent it = new Intent(Home.this, CadastroInvActivity.class);
        startActivity(it);
    }

    public void listaInvestimentos(View view){
        Intent it = new Intent(Home.this, ListaInvestimentos.class);
        startActivity(it);
    }
}
