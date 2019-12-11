package br.com.cointerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import br.com.cointerproject.ui.login.TelaLogin;
import br.com.cointerproject.view.CadastroInvActivity;
import br.com.cointerproject.view.ListaInvestimentos;
import br.com.cointerproject.view.TelaConsultaValores;

public class TelaHome extends AppCompatActivity {

    ListView list;
    String[] menu = {"Home","Perfil","Meus Investimentos","Novo Investimento","Consultar Valores","Logout"};
    Integer[] imagens = {R.drawable.home,R.drawable.user, R.drawable.lista,
    R.drawable.novo, R.drawable.valor,R.drawable.logout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_home2);
        list = findViewById(R.id.listViewMenu);
        CustomAdaptor customAdaptor = new CustomAdaptor();
        list.setAdapter(customAdaptor);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent it = new Intent();
                    startActivity(it);
                }
                else if(position==1){
                    Intent it = new Intent(TelaHome.this, MeuPerfil.class);
                    startActivity(it);
                }
                else if(position==2){
                    Intent it = new Intent(TelaHome.this, ListaInvestimentos.class);
                    startActivity(it);
                }
                else if (position==3){
                    Intent it = new Intent(TelaHome.this, CadastroInvActivity.class);
                    startActivity(it);
                }
                else if (position==4){
                    Intent it = new Intent(TelaHome.this, TelaConsultaValores.class);
                    startActivity(it);
                }
                else if (position==5){
                    Intent it = new Intent(TelaHome.this, TelaLogin.class);
                    FirebaseAuth.getInstance().signOut();
                    startActivity(it);
                }

            }
        });
    }
    class CustomAdaptor extends BaseAdapter {

        public int getCount(){
            return imagens.length;
        }
        public Object getItem(int postion){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View view = getLayoutInflater().inflate(R.layout.custom_layout, null);
            ImageView imageView = view.findViewById(R.id.imageView4);
            TextView textView = view.findViewById(R.id.menuText);
            imageView.setImageResource(imagens[position]);
            textView.setText(menu[position]);
            return view;
        }
    }
}

