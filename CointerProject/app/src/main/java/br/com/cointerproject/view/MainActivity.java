package br.com.cointerproject.view;

import android.os.Bundle;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cointerproject.R;
import br.com.cointerproject.controller.ControllerUsuario;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.view.utils.ValidarEmail;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView txtCadastrar;
    private Button btAcessar;
    private EditText areaEmail;
    private EditText areaSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        this.logarNoSistema();
    }

    // Usei essa método para ser executado no momento em que a tela for construida.
    private void logarNoSistema() {
        txtCadastrar = findViewById(R.id.txtCadastrar);
        areaEmail = findViewById(R.id.campoEmail);
        areaSenha = findViewById(R.id.campoSenha);

        // O método abaixo verifica se foi clicado no TextView "Cadastrar", se sim, ele irá trocar para a tela de cadastro.
        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // O método abaixo foi criado para verificar se o botão acessar foi clicado, se sim, é feito a lógica para validar os dados.
        btAcessar = findViewById(R.id.btcadastrar);
        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = areaEmail.getText().toString();
                String senha = areaSenha.getText().toString();

                Toast mensagem;
                ControllerUsuario controllerUsuario = new ControllerUsuario();

                if(email.length() > 0 && senha.length() > 0){
                    boolean validao = ValidarEmail.validar(email);
                    if(validao){
                        try {
                            Usuario user = new Usuario();
                            user.setEmail(email);
                            user.setSenha(senha);
                            Usuario usuarioValidado = controllerUsuario.logar(user);
                            if(usuarioValidado != null){

                            }
                        } catch (ErroAoLogarException e) {
                            mensagem = Toast.makeText(getApplicationContext(), e.getMessage(), 2000);
                            mensagem.show();
                        }

                    }
                }
                // Essa verificação foi feita para caso a entrada do campo e-mail for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
                else if(email.length() == 0){
                    mensagem =  Toast.makeText(getApplicationContext(), "Digite o e-mail.", 2000);
                    mensagem.show();
                    areaEmail.requestFocus();
                }
                // Essa verificação foi feita para caso a entrada do campo senha for igual a 0, significa que o usuário não digitou nada. Então, ele recebe um aviso.
                else if(senha.length() == 0){
                    mensagem =  Toast.makeText(getApplicationContext(), "Digite a senha.", 2000);
                    mensagem.show();
                    areaSenha.requestFocus();
                }


            }
        });
    }


}
