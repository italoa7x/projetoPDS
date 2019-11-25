package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cointerproject.R;
import br.com.cointerproject.controller.ControllerUsuario;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.ui.utils.Validacao;

public class CadastroActivity extends AppCompatActivity {
    private ControllerUsuario controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        controller = new ControllerUsuario(getApplicationContext());
    }

    public void cadastrarUsuario(View view) {
        EditText tiNome = (EditText) (findViewById(R.id.editTextNome));
        EditText tiEmail = (EditText) (findViewById(R.id.editTextEmail));
        EditText tiSenha = (EditText) (findViewById(R.id.editTextSenha));

        boolean ok = true;

        ok = Validacao.validarEmail(tiEmail.getText().toString());
        ok = Validacao.validarSenha(tiSenha.getText().toString(), tiNome.getText().toString());

        if (ok == true) {
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setNome(tiNome.getText().toString());
            usuario.setEmail(tiEmail.getText().toString());
            usuario.setSenha(tiSenha.getText().toString());

            // Após o objeto DTO ser populado, ele é passado para o controller do usuário.
            UsuarioDTO retorno = controller.salvar(usuario);
            if(retorno != null){
                Toast.makeText(this, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_tela_login);
            }else{
                Toast.makeText(this, "Erro ao salvar usuário.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
