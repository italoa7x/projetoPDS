package br.com.cointerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.cointerproject.ui.fragments_dashboard.FragmentCadastrarInvestimento;
import br.com.cointerproject.ui.fragments_dashboard.FragmentHome;
import br.com.cointerproject.ui.fragments_dashboard.FragmentListarInvestimentos;
import br.com.cointerproject.ui.fragments_dashboard.FragmentValoresMonetarios;
import br.com.cointerproject.view.CadastroInvActivity;
import br.com.cointerproject.view.Home;
import br.com.cointerproject.view.ListaInvestimentos;

public class TelaDashBoard extends AppCompatActivity {

    private BottomNavigationView barraInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dash_board);

        barraInferior = findViewById(R.id.barra_inferior);

        barraInferior.setOnNavigationItemSelectedListener(navList);
    }

    // O código abaixo será responsável por verificar qual opção do menu inferior será selecionada pelo usuário.
    private BottomNavigationView.OnNavigationItemSelectedListener navList = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment telaSelecionada = null;
            // Aqui será verificado qual opção da barra inferior foi pressionada.
            switch(menuItem.getItemId()){
                case R.id.nav_home:
                    telaSelecionada = new FragmentHome();
                    break;
                case R.id.nav_novo_investimento:
                    telaSelecionada = new FragmentCadastrarInvestimento();
                    break;
                case R.id.nav_valores:
                    telaSelecionada = new FragmentValoresMonetarios();
                    break;
                case R.id.nav_meus_investimentos:
                    telaSelecionada = new FragmentListarInvestimentos();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.barra_inferior, telaSelecionada).commit();
            return true;
        }
    };


}
