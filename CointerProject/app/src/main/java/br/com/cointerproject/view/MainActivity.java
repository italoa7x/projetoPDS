package br.com.cointerproject.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cointerproject.R;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        this.logarNoSistema();
    }
    private TextView txtCadastrar;
    private Button btAcessar;
    private EditText areaEmail = findViewById(R.id.campoEmail);;
    private EditText areaSenha = findViewById(R.id.campoSenha);;

    // Usei essa método para ser executado no momento em que a tela for construida.

    private void logarNoSistema() {
        txtCadastrar = findViewById(R.id.txtCadastrar);

        // O método abaixo verifica se foi clicado no TextView "Cadastrar", se sim, ele irá trocar para a tela de cadastro.
        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("WrongConstant") Toast mensagem = Toast.makeText(getApplicationContext(),"clicou em cadastrar",2000);
                mensagem.show();
            }
        });

        // O método abaixo foi criado para verificar se o botão acessar foi clicado, se sim, é feito a lógica para validar os dados.
        btAcessar = findViewById(R.id.btAcessar);
        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = areaEmail.getText().toString();
                String senha = areaSenha.getText().toString();

                @SuppressLint("WrongConstant") Toast mensagem = Toast.makeText(getApplicationContext(),"clicou em acessar",2000);
                mensagem.show();

            }
        });
    }

    private boolean validarDados(String email, String senha){
        if(email.length() > 0 && senha.length() > 0){


        }
        // Essa verificação foi feita para caso a entrada do campo e-mail for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
        else if(email.length() == 0){
            areaEmail.requestFocus();
            @SuppressLint("WrongConstant") Toast aviso = Toast.makeText(getApplicationContext(),"Insira o e-mail.",1000);
            aviso.show();
            areaEmail.requestFocus();
        }
        // Essa verificação foi feita para caso a entrada do campo senha for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
        else if(senha.length() == 0){
            @SuppressLint("WrongConstant") Toast aviso = Toast.makeText(getApplicationContext(),"Insira a senha.",1000);
            aviso.show();

        }
        return false;
    }



}
