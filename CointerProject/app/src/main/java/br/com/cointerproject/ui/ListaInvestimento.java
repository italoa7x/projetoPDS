package br.com.cointerproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.cointerproject.R;
import br.com.cointerproject.controller.ControllerInvestimento;
import br.com.cointerproject.dto.InvestimentoDTO;
import br.com.cointerproject.model.Investimento;

public class ListaInvestimento extends AppCompatActivity {

    private InvestimentoDTO idto;
    private ControllerInvestimento controllerInvestimento = new ControllerInvestimento();
    private ListView list;
    private int[] images ;
    private String[] moedas;
    private double din = 0 ;
    private InvestimentoDTO investimentoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_investimento);
        preencherNomes();
        preencherArray();
        TextView real = (TextView) findViewById(R.id.textView4);
        real.setText(din+"");

        list = (ListView) findViewById(R.id.listView);
        CustomAdaptor customAdaptor = new CustomAdaptor();
        list.setAdapter(customAdaptor);
        registerForContextMenu(list);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                investimentoSelecionado  = (InvestimentoDTO) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
            idto = new InvestimentoDTO();
            idto.setId(investimentoSelecionado.getId());
            controllerInvestimento.excluir(idto);
            Toast.makeText(getApplicationContext(), "Investimento excluído", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

   public void preencherNomes() {
        List<Investimento> arrayList = controllerInvestimento.listar();
        moedas = new String[arrayList.size()];
        int cont = 0;
        double var = 0;
            for(Investimento a: arrayList){
                moedas[cont] = a.getNome();
                var = a.getValor();
                din = din + var;
                cont++;
            }
        }

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