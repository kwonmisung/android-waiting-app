package smu.ai.waiting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class OrderMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_order);

        // 그리드뷰에 어댑터 등록
        final GridView gridView = findViewById(R.id.gridOrder);
        MyGridView gAdapter = new MyGridView(this);
        gridView.setAdapter(gAdapter);
    }
}