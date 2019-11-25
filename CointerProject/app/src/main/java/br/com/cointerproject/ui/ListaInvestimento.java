package br.com.cointerproject.ui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.cointerproject.R;
import br.com.cointerproject.controller.ControllerInvestimento;
import br.com.cointerproject.dto.InvestimentoDTO;

public class ListaInvestimento extends AppCompatActivity {

    private InvestimentoDTO idto;
    private ControllerInvestimento controllerInvestimento;
    private ListView list;
    int[] images ;
    ArrayList<String> arrayList;
    String[] moedas = {"Pensão","Amor","Carro","Bitcoin","Euro",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_investimento);
        preencherArray();

        list = (ListView) findViewById(R.id.listView);
        CustomAdaptor customAdaptor = new CustomAdaptor();
        list.setAdapter(customAdaptor);
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListaInvestimento.this, AcompanharInvestimento.class);
                it.putExtra("nome", moedas[position] );
                startActivity(it);
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(menu, v, info);
        menu.add("Excluir");


    }
    public boolean onContextItemSelected(final MenuItem item){
        super.onContextItemSelected(item);
        if(item.getTitle() == "Excluir") {
            Toast.makeText(getApplicationContext(), "Investimento excluído", Toast.LENGTH_SHORT).show();
//            controllerInvestimento.excluir();
        }
        return true;
    }

   /* public void preencherNomes() {
        List arrayList = controllerInvestimento.listar();
        moedas = new String[arrayList.size()];
        int cont = 0;
        for (int i = 0; i < arrayList.size(); i++) {
        }
    }*/


    public void preencherArray(){
        images = new int[moedas.length];
        for(int i = 0; i<moedas.length;i++){
            images[i] = R.drawable.cifrao;
        }
    }
    class CustomAdaptor extends BaseAdapter{

        public int getCount(){
            return images.length;
        }
        public Object getItem(int postion){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView = view.findViewById(R.id.imageView2);
            TextView textView = view.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            textView.setText(moedas[position]);
            return view;
        }
    }
}