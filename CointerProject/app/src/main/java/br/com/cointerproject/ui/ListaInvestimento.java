package br.com.cointerproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.cointerproject.R;

public class ListaInvestimento extends AppCompatActivity {
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
