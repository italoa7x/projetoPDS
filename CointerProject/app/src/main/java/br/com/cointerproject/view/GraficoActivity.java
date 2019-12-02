package br.com.cointerproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.cointerproject.R;

public class GraficoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(2.5, 5),
                new DataPoint(4, 3),
                new DataPoint(6, 2),
                new DataPoint(8, 6.5),
                new DataPoint(10, 2.5),
                new DataPoint(12, 4)
        });

        String[] datas = pegarDiasDaSemana();
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Hoje"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], "Hoje"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graph.addSeries(series);
    }

    public String[] pegarDiasDaSemana() {
        DateFormat df = new SimpleDateFormat("dd/MM");
        Date dataAtual = new Date(System.currentTimeMillis());
        String[] datas = new String[6];

        Date dt1 = null;
        try {
            dt1 = df.parse(df.format(dataAtual));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt1);
        for (int i = 5; i >= 0; i--) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            datas[i] = df.format(cal.getTime());
        }

        return datas;
    }

}
