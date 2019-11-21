package br.com.cointerproject;

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
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.exceptions.ErroAoLogarException;
import br.com.cointerproject.ui.utils.Validacao;

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
        txtCadastrar = findViewById(R.id.txtCadastrar);
        areaEmail = findViewById(R.id.campoEmail);
        areaSenha = findViewById(R.id.campoSenha);
        btAcessar = findViewById(R.id.btAcessar);

        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_cadastro);
            }
        });

        btAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
                ControllerUsuario controllerUsuario = new ControllerUsuario(getApplicationContext());

                if(email.length() > 0 && senha.length() > 0){
                    boolean validao = Validacao.validarEmail(email);
                    if(validao){
                        try {
                            UsuarioDTO user = new UsuarioDTO();
                            user.setEmail(email);
                            user.setSenha(senha);
                            UsuarioDTO usuarioValidado = controllerUsuario.logar(user);
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
