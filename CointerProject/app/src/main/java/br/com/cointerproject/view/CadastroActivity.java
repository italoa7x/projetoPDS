package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.com.cointerproject.R;
import br.com.cointerproject.dao.UsuarioDAO;
import br.com.cointerproject.model.Usuario;
import br.com.cointerproject.model.Validacao;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrar(View view) {
        EditText tiNome = (EditText) (findViewById(R.id.editTextNome));
        EditText tiEmail = (EditText) (findViewById(R.id.editTextEmail));
        EditText tiSenha = (EditText) (findViewById(R.id.editTextSenha));
        EditText tiSenha2 = (EditText) (findViewById(R.id.editTextSenha2));

        boolean ok = true;

        ok = Validacao.validarEmail(tiEmail.getText().toString());
        ok = Validacao.validarSenha(tiSenha.getText().toString(), tiNome.getText().toString());
        if (tiSenha.getText().toString().equals(tiSenha2.getText().toString()) == false) ok = false;

        if (ok == true) {
            Usuario usuario = new Usuario();
            usuario.setNome(tiNome.getText().toString());
            usuario.setEmail(tiEmail.getText().toString());
            usuario.setSenha(tiSenha.getText().toString());

            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
        }
    }
}
