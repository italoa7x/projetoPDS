package br.com.cointerproject;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.cointerproject.ui.Home;
import br.com.cointerproject.ui.utils.Validacao;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView txtCadastrar;
    private Button btAcessar;
    private EditText areaEmail;
    private EditText areaSenha;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        txtCadastrar = findViewById(R.id.txtCadastrar);
        areaEmail = findViewById(R.id.campoEmail);
        areaSenha = findViewById(R.id.campoSenha);
        btAcessar = findViewById(R.id.btAcessar);
        firebaseAuth = FirebaseAuth.getInstance();


        // O código abaixo chama a tela de cadastro.
        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_cadastro_usuario);
                Intent t = new Intent(MainActivity.this, NovoUsuario.class);
                startActivity(t);
            }
        });
        if(firebaseAuth.getCurrentUser()!=null){
            Toast.makeText(getApplicationContext(), "Login efetuado com sucesso", Toast.LENGTH_SHORT);
            Intent t = new Intent(MainActivity.this, Home.class);
            startActivity(t);
        }

        logarNoSistema();

    }

    
    // Usei essa método para ser executado no momento em que a tela for construida.
    private void logarNoSistema() {
        // O método abaixo foi criado para verificar se o botão acessar foi clicado, se sim, é feito a lógica para validar os dados.
        btAcessar = findViewById(R.id.btAcessar);
        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = areaEmail.getText().toString();
                String senha = areaSenha.getText().toString();

                Toast mensagem;

                if(email.length() > 0 && senha.length() > 0){
                    boolean validao = Validacao.validarEmail(email);
                    if(validao){

                            firebaseAuth.signInWithEmailAndPassword(email, senha)
                                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(), "Login efetuado com sucesso", Toast.LENGTH_SHORT);
                                                Intent t = new Intent(MainActivity.this, Home.class);
                                                startActivity(t);
                                            } else {
                                                Toast.makeText(getApplicationContext(), "E-mail ou senha inválido.", Toast.LENGTH_SHORT);
                                            }
                                        }
                                    });


                    }
                }
                // Essa verificação foi feita para caso a entrada do campo e-mail for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
                else if(email.length() == 0){
                    mensagem =  Toast.makeText(getApplicationContext(), "Digite o e-mail.", Toast.LENGTH_SHORT);
                    mensagem.show();
                    areaEmail.requestFocus();
                }
                // Essa verificação foi feita para caso a entrada do campo senha for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
                else if(senha.length() == 0){
                    mensagem =  Toast.makeText(getApplicationContext(), "Digite a senha.", Toast.LENGTH_SHORT);
                    mensagem.show();
                    areaSenha.requestFocus();
                }


            }
        });
    }


}
