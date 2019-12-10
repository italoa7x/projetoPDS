package br.com.cointerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MeuPerfil extends AppCompatActivity {

    private TextView areaNome, areaEmail;
    private FirebaseAuth authen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);

        // pega a instância do banc ode dados.
        authen = FirebaseAuth.getInstance();
        //Pega o usuário logado da instância do firebase;
        FirebaseUser usuario = authen.getCurrentUser();

        areaNome = findViewById(R.id.areaNomeUsuario);
        areaEmail = findViewById(R.id.areaEmailusuario);

        areaNome.setText(usuario.getDisplayName());
        areaEmail.setText(usuario.getEmail());


    }
}
