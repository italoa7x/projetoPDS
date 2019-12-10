package br.com.cointerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import br.com.cointerproject.ui.fragmentos.FragmentoListarInvestimentos;
import br.com.cointerproject.ui.fragmentos.FragmentNovoInvestimento;
import br.com.cointerproject.ui.fragmentos.FragmentoHome;
import br.com.cointerproject.ui.fragmentos.FragmentoValoresMonetarios;
import br.com.cointerproject.ui.login.TelaLogin;


public class TelaHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogler = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.abrir_navegacao, R.string.fechar_navegacao);

        drawer.addDrawerListener(toogler);
        toogler.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new FragmentoValoresMonetarios()).commit();
            navigation.setCheckedItem(R.id.op_valores_monetarios);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_home, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.op_novo_investimento:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new FragmentNovoInvestimento()).commit();
                break;
            case R.id.op_valores_monetarios:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new FragmentoValoresMonetarios()).commit();
                break;


            case R.id.op_meus_investimentos:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new FragmentoListarInvestimentos()).commit();
                break;

            case R.id.op_logof:
                FirebaseAuth.getInstance().signOut();
                Intent it = new Intent(TelaHome.this, TelaLogin.class);
                startActivity(it);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
