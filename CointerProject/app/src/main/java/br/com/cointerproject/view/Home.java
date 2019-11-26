package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.cointerproject.R;

public class Home extends AppCompatActivity {
    private TextView textoHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textoHome = findViewById(R.id.textohome);
        FirebaseAuth f = FirebaseAuth.getInstance();
        FirebaseUser u = f.getCurrentUser();
        textoHome.setText(u.getDisplayName());
    }
}
