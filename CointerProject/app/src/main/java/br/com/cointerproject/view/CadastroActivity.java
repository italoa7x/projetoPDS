package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.cointerproject.R;
import br.com.cointerproject.controller.ControllerUsuario;
import br.com.cointerproject.dto.UsuarioDTO;
import br.com.cointerproject.model.Validacao;

public class CadastroActivity extends AppCompatActivity {

    private EditText tiNome;
    private EditText tiEmail;
    private EditText tiSenha;
    private EditText tiSenha2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        tiNome = findViewById(R.id.editTextNome);
        tiEmail = findViewById(R.id.editTextEmail);
        tiSenha = findViewById(R.id.editTextSenha);
        tiSenha2 = findViewById(R.id.editTextSenha2);
    }

    public void cadastrar(View view) {
        boolean ok = true;

        if (!Validacao.validarEmail(tiEmail.getText().toString())) {
            tiNome.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            ok = false;
        }

        if (!Validacao.validarSenha(tiSenha.getText().toString(), tiNome.getText().toString())) {
            tiSenha.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            ok = false;
        }

        if (!tiSenha.getText().toString().equals(tiSenha2.getText().toString()) == false) {
            tiSenha2.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            ok = false;
        }

        if (ok == true) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setNome(tiNome.getText().toString());
            dto.setEmail(tiEmail.getText().toString());
            dto.setSenha(tiSenha.getText().toString());

            ControllerUsuario control = new ControllerUsuario(getApplicationContext());
            control.salvar(dto);
        }
    }
}
