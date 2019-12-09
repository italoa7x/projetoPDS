package br.com.cointerproject.view;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import br.com.cointerproject.R;
import br.com.cointerproject.fachadaRequisicoes.FachadaRequisicoes;

public class GraficoActivity extends AppCompatActivity {

    private String moedaSelecionada;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        Intent intent = getIntent();
        moedaSelecionada = (String) intent.getSerializableExtra("moeda");

        GraphView graph = (GraphView) findViewById(R.id.graph);
        preencherGrafico(moedaSelecionada);

        String[] datas = pegarDiasDaSemana();
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], "Hoje"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graph.getGridLabelRenderer().setLabelsSpace(10);

        graph.addSeries(series);
//        graph.addSeries(pointsSeries);
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

    private FachadaRequisicoes fachada;
    private LineGraphSeries<DataPoint> series;
//    private PointsGraphSeries<DataPoint> pointsSeries;

    public void preencherGrafico(String moeda) {
        fachada = new FachadaRequisicoes();
        float[] valores = new float[7];

        try {
            valores = fachada.consultarDiasDaSemana(getApplicationContext(), moeda);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DataPoint[] dataPoints = new DataPoint[]{
                new DataPoint(0, valores[0]),
                new DataPoint(1, valores[1]),
                new DataPoint(2, valores[2]),
                new DataPoint(3, valores[3]),
                new DataPoint(4, valores[4]),
                new DataPoint(5, valores[5]),
                new DataPoint(6, valores[6])
        };

        series = new LineGraphSeries<>(dataPoints);

        /*pointsSeries = new PointsGraphSeries<>(dataPoints);
        pointsSeries.setCustomShape(new PointsGraphSeries.CustomShape() {

            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setColor(Color.BLACK);
                paint.setTextSize(38);
                canvas.drawText(String.valueOf(dataPoint.getY()), x, y, paint);
            }
        });*/

    }
}
