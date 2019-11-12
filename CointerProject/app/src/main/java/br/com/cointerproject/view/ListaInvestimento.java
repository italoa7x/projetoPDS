package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.cointerproject.R;

public class ListaInvestimento extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_investimento);
        list = (ListView) findViewById(R.id.listView);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Pensão");
        arrayList.add("Bitcoin");
        arrayList.add("Dolar");
        arrayList.add("Euro");
        arrayList.add("Libra");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getBaseContext(), "Item clicado", Toast.LENGTH_LONG).show();
                Intent it = new Intent(ListaInvestimento.this, AcompanharInvestimento.class);
              //  it.putExtra("nome", "nome");
                startActivity(it);

            }
        });
    }
}
