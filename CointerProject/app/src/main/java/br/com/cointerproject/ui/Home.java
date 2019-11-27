package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.cointerproject.R;
import br.com.cointerproject.TelaConsultaValores;

public class Home extends AppCompatActivity {
    private TextView textoHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textoHome = findViewById(R.id.textohome);
        FirebaseAuth f = FirebaseAuth.getInstance();
        FirebaseUser u = f.getCurrentUser();
        textoHome.setText(u.getEmail());
    }

    public void mudarTelaConsultas(View view){
        Intent it = new Intent(Home.this, TelaConsultaValores.class);
        startActivity(it);
    }
}
