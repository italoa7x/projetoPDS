package br.com.cointerproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
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
        this.adapter = new InvestimentoAdapter(investimentos,keys);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recycler.setLayoutManager(layoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(recycler.getContext(),
                layoutManager.getOrientation());
        recycler.addItemDecoration(divider);
        recycler.setAdapter(adapter);
    }


    class ItemViewer extends RecyclerView.ViewHolder{
        private TextView nome;
        private TextView valor;
        private TextView lucro;

        private String key;

        public ItemViewer (ViewGroup parent){
            super(LayoutInflater.from(context).inflate(R.layout.itens,parent,false));
            nome = itemView.findViewById(R.id.nome_investimento);
            valor =  itemView.findViewById(R.id.valor_investimento);
            lucro =  itemView.findViewById(R.id.lucro_investimento);

        }

        public void bind (Investimento i, String key){
            valor.setText(String.valueOf(i.getValor()));
            lucro.setText(String.valueOf(i.getLucro()));
            nome.setText(i.getNome());
        }
    }


    class InvestimentoAdapter extends RecyclerView.Adapter<ItemViewer>{
        private List<Investimento> investimentos;
        private List<String> keys;

        public InvestimentoAdapter(List<Investimento> investimentos, List<String> keys) {
            this.investimentos = investimentos;
            this.keys = keys;
        }

        public InvestimentoAdapter() {
            super();
        }

        @NonNull
        @Override
        public ItemViewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewer(parent);
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
