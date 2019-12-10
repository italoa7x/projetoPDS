package br.com.cointerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.cointerproject.ui.login.TelaLogin;

public class MeuPerfil extends AppCompatActivity {

    private TextView areaNome, areaEmail;
    private FirebaseAuth authen;
    private FirebaseUser usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);

        // pega a instância do banc ode dados.
        authen = FirebaseAuth.getInstance();
        //Pega o usuário logado da instância do firebase;
        usuario = authen.getCurrentUser();

        areaNome = findViewById(R.id.areaNomeUsuario);
        areaEmail = findViewById(R.id.areaEmailusuario);

        areaNome.setText(usuario.getDisplayName());
        areaEmail.setText(usuario.getEmail());




    }

    // Método de atualizar os dados do usuário.
    public void atualizarDados(View view){
        String novoNome = areaNome.getText().toString();
        String novoEmail = areaEmail.getText().toString();
    }

    private boolean validarNovosDados(String novoNome, String novoEmail){
        // pega a instância do banc ode dados.
        authen = FirebaseAuth.getInstance();
        //Pega o usuário logado da instância do firebase;
        FirebaseUser usuario = authen.getCurrentUser();

        if(!usuario.getDisplayName().equals(novoNome) && !usuario.getEmail().equals(novoEmail)){
            return true;
        }else{
            return false;
        }
    }


    // Método de excluir conta do usuário.
    public void excluirConta(View view){
        usuario.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MeuPerfil.this, "Usuário excluído!", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(MeuPerfil.this, TelaLogin.class);
                    startActivity(it);
                }
            }
        });
    }
}
