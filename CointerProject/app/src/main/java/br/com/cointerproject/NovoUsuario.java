package br.com.cointerproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cointerproject.controller.ControllerUsuario;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.ui.utils.Validacao;

public class NovoUsuario extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        campoNome = findViewById(R.id.campoNome);
        campoEmail = findViewById(R.id.campoEmail);
        campoSenha = findViewById(R.id.campoSenha);

    }

    public void finalizarCadastro(View view){
        UsuarioDTO usuario = new UsuarioDTO();
        ControllerUsuario controller = new ControllerUsuario(getApplicationContext());

        String nomeUsuario = campoNome.getText().toString();
        String emailUsuario = campoEmail.getText().toString();
        String senhaUsuario = campoSenha.getText().toString();

        boolean ok = true;
        // Foi feito essa lógica para testar o email, nome e senha do usuário.
        ok = Validacao.validarEmail(emailUsuario);
        //ok = Validacao.validarSenha(senhaUsuario, nomeUsuario);
        // Se os dados forem válidos, é seguido o cadastro do usuário.
        if(ok){
            usuario.setNome(nomeUsuario);
            usuario.setEmail(emailUsuario);
            usuario.setSenha(senhaUsuario);

            boolean result = controller.salvar(usuario);
            if(result) {
                Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Ocorreu um erro no cadastro.", Toast.LENGTH_SHORT).show();
            }
        }


    }

}
