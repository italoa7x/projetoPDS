package br.com.cointerproject.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import br.com.cointerproject.R;
import br.com.cointerproject.model.Validacao;

public class CadastroActivity extends AppCompatActivity {

    private EditText tiNome;
    private EditText tiEmail;
    private EditText tiSenha;
    private EditText tiSenha2;
    private Button btCadastrar;
    private FirebaseAuth firebaseAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        tiNome = findViewById(R.id.campoNome);
        tiEmail = findViewById(R.id.campoEmail);
        tiSenha = findViewById(R.id.campoSenha);
        btCadastrar = findViewById(R.id.btFinalizarCadastro);

        firebaseAuth = FirebaseAuth.getInstance();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar(v);
            }
        });

    }
    //metodo que cadastrar um usuário no database
    public void cadastrar(View view) {
        boolean ok = true;
        //verificações de validação, ex: se o email é valido, senha com pelo menos 8 caracteres e algumas outras coisas
        if (!Validacao.validarEmail(tiEmail.getText().toString())) {
            tiNome.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            ok = false;
            Toast.makeText(this, "E-mail inválido!", Toast.LENGTH_SHORT).show();
        }

        if (!Validacao.validarSenha(tiSenha.getText().toString(), tiNome.getText().toString())) {
            tiSenha.getBackground().mutate().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            ok = false;
            Toast.makeText(this, "Digite uma senha válida.", Toast.LENGTH_SHORT).show();
        }

        //se a validação for feita corretamente é feito o cadastro no firebase
        if (ok == true) {
            String email = tiEmail.getText().toString();
            String senha = tiSenha.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(tiNome.getText().toString())
                                        .build();
                                user.updateProfile(profileUpdates);
                                Intent t = new Intent(CadastroActivity.this, Home.class);
                                startActivity(t);

                            } else {
                                Toast.makeText(CadastroActivity.this, "Falha no Cadastro",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });}
    }
}