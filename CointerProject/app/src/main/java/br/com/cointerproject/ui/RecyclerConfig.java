package br.com.cointerproject.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.cointerproject.R;
import br.com.cointerproject.model.Investimento;


public class RecyclerConfig {
    private Context context;
    private InvestimentoAdapter adapter;

    public void setConfig(RecyclerView recycler, Context context, List<Investimento> investimentos,List<String> keys){
        this.context = context;
        this.adapter = new InvestimentoAdapter(investimentos,keys,context);
        recycler.setLayoutManager(new LinearLayoutManager(context));
        recycler.setAdapter(adapter);
    }


    class ItemViewer extends RecyclerView.ViewHolder{
        private TextView nome;
        private TextView status;
        private TextView moeda;
        private TextView valor;
        private Investimento inv;
        private Context contexto;

        private String key;

        public ItemViewer (ViewGroup parent, Context contexto){
            super(LayoutInflater.from(context).inflate(R.layout.itens,parent,false));
            nome = itemView.findViewById(R.id.nome_investimento);
            status =  itemView.findViewById(R.id.status_investimento);
            moeda =  itemView.findViewById(R.id.moeda_investimento);
            valor =  itemView.findViewById(R.id.valor_investimento);
            this.contexto = contexto;


        }

        public Investimento getInv() {
            return inv;
        }

        public void setInv(Investimento inv) {
            this.inv = inv;
        }

        public void bind (Investimento i, String key){
            valor.setText(valor.getText()+String.valueOf(i.getValor()));
            moeda.setText(i.getMoeda());
            nome.setText(i.getNome());
            status.setText(i.getStatus());
            inv = i;
            itemView.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    ouvinte();

                }
            });

        }

        public void ouvinte () {
            Intent it = new Intent(this.contexto,AcompanharInvestimento.class);
            it.putExtra("investimento",inv);
            this.contexto.startActivity(it);
        }


    }


    class InvestimentoAdapter extends RecyclerView.Adapter<ItemViewer>{
        private List<Investimento> investimentos;
        private List<String> keys;
        private Context contexto;

        public InvestimentoAdapter(List<Investimento> investimentos, List<String> keys, Context contexto) {
            this.investimentos = investimentos;
            this.keys = keys;
            this.contexto = contexto;


        }

        public InvestimentoAdapter() {
            super();
        }

        @NonNull
        @Override
        public ItemViewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewer(parent,contexto);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewer holder, int position) {
            holder.bind(investimentos.get(position),keys.get(position));
        }

        @Override
        public int getItemCount() {
            return investimentos.size();
        }


    }


}
