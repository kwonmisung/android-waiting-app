package smu.ai.waiting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderFin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_fin);

        getSupportActionBar().setTitle(R.string.title_orderfin);

        TextView results = (TextView) findViewById(R.id.itemtext);
        Button button = (Button) findViewById(R.id.backbtn);

        Bundle extras = getIntent().getExtras();
        results.setText("\n"+extras.getString("t1") + extras.getString("i1")
                +"\n"+extras.getString("t2") + extras.getString("i2")
                +"\n"+extras.getString("t3") + extras.getString("i3")
                +"\n"+extras.getString("t4") + extras.getString("i4")
                +"\n"+extras.getString("t5") + extras.getString("i5")
                +"\n"+extras.getString("t6") + extras.getString("i6")
                +"\n"+extras.getString("t7") + extras.getString("i7")
                +"\n"+extras.getString("t8") + extras.getString("i8")
                +"\n"+extras.getString("t9") + extras.getString("i9")
                +"\n"+extras.getString("t10") + extras.getString("i10"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderFin.this, OrderMain.class);
                startActivity(intent);
            }
        });
    }
}