package smu.ai.waiting;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class Chart extends AppCompatActivity {

    PieChart salesChart;
    TextView results;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_chart);

        // 전달받은 퍼센트 값 불러오기
        float monpercent = getIntent().getFloatExtra("monsale", 0);
        float tuespercent = getIntent().getFloatExtra("tuessale", 0);
        float wedpercent = getIntent().getFloatExtra("wedsale", 0);
        float thupercent = getIntent().getFloatExtra("thusale", 0);
        float fripercent = getIntent().getFloatExtra("frisale", 0);
        float satpercent = getIntent().getFloatExtra("satsale", 0);
        float sunpercent = getIntent().getFloatExtra("sunsale", 0);

        salesChart = (PieChart) findViewById(R.id.piechart);
        salesChart.setUsePercentValues(true);
        salesChart.getDescription().setEnabled(false);
        salesChart.setExtraOffsets(20, 20, 20, 0);

        // 범례 지정
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(monpercent, "월"));
        entries.add(new PieEntry(tuespercent, "화"));
        entries.add(new PieEntry(wedpercent, "수"));
        entries.add(new PieEntry(thupercent, "목"));
        entries.add(new PieEntry(fripercent, "금"));
        entries.add(new PieEntry(satpercent, "토"));
        entries.add(new PieEntry(sunpercent, "일"));

        // 데이터셋 이름 지정
        PieDataSet dataSet = new PieDataSet(entries, "요일별 매출");
        dataSet.setValueTextSize(16f);

        // 데이터셋마다의 색 지정
        dataSet.setColors(getResources().getColor(R.color.red),
                getResources().getColor(R.color.orange), getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.green), getResources().getColor(R.color.blue),
                getResources().getColor(R.color.navy), getResources().getColor(R.color.purple));

        // 데이터 담기
        PieData data = new PieData(dataSet);
        data.setValueTextSize(14f);

        // 차트로 표현할 데이터 지정하기
        salesChart.setData(data);
        salesChart.invalidate();

        // 한 주 매출 총액 보여주기
        float total = getIntent().getExtras().getFloat("total");
        results = findViewById(R.id.textViewTotal);
        results.setText(total + " (원)");
    }
}
