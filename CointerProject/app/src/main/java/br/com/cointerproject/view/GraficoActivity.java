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
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1, 1),
                new DataPoint(2, 5),
                new DataPoint(3, 3),
                new DataPoint(4, 2),
                new DataPoint(5, 6.5),
                new DataPoint(6, 2.5),
                new DataPoint(7, 4)
        });

        String[] datas = pegarDiasDaSemana();
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//        staticLabelsFormatter.setHorizontalLabels(new String[] {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Hoje"});
        staticLabelsFormatter.setHorizontalLabels(new String[] {datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], "Hoje"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graph.addSeries(series);

        /*Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        GraphView graph = (GraphView) findViewById(R.id.graph);

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 5),
                new DataPoint(d3, 3)
        });

        graph.addSeries(series);

// set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
        graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport().setMinX(d1.getTime());
        graph.getViewport().setMaxX(d3.getTime());
        graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
        graph.getGridLabelRenderer().setHumanRounding(false);*/
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
        cal.setTime (dt1);
        for (int i = 5; i >= 0; i--) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            datas[i] = df.format(cal.getTime());
        }

        return datas;
    }

}
