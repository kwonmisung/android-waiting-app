package smu.ai.waiting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sales extends AppCompatActivity {

    EditText edit_mon, edit_tues, edit_wed, edit_thu, edit_fri, edit_sat, edit_sun;
    Button btnShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_sales);

        edit_mon = (EditText) findViewById(R.id.editMonday);
        edit_tues = (EditText) findViewById(R.id.editTuesday);
        edit_wed = (EditText) findViewById(R.id.editWednesday);
        edit_thu = (EditText) findViewById(R.id.editThursday);
        edit_fri = (EditText) findViewById(R.id.editFriday);
        edit_sat = (EditText) findViewById(R.id.editSaturday);
        edit_sun = (EditText) findViewById(R.id.editSunday);

        // Chart.java로 데이터 전송
        btnShow = (Button) findViewById(R.id.buttonShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 값이 입력되지 않은 경우
                if (isEditTextEmpty(edit_mon) || isEditTextEmpty(edit_tues) || isEditTextEmpty(edit_wed) ||
                        isEditTextEmpty(edit_thu) || isEditTextEmpty(edit_fri) || isEditTextEmpty(edit_sat) ||
                        isEditTextEmpty(edit_sun)) {
                    Toast.makeText(Sales.this, "값이 전부 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 입력받은 매출 저장
                int monsale = Integer.parseInt(edit_mon.getText().toString());
                int tuessale = Integer.parseInt(edit_tues.getText().toString());
                int wedsale = Integer.parseInt(edit_wed.getText().toString());
                int thusale = Integer.parseInt(edit_thu.getText().toString());
                int frisale = Integer.parseInt(edit_fri.getText().toString());
                int satsale = Integer.parseInt(edit_sat.getText().toString());
                int sunsale = Integer.parseInt(edit_sun.getText().toString());

                // 매출 합계 구하기
                int total = monsale + tuessale + wedsale + thusale + frisale + satsale + sunsale;

                Intent salesintent = new Intent(Sales.this, Chart.class);

                // 퍼센트로 전환하여 인텐트에 담기
                Bundle extras = new Bundle();
                extras.putFloat("monsale", calculatePercentage(monsale, total));
                extras.putFloat("tuessale", calculatePercentage(tuessale, total));
                extras.putFloat("wedsale", calculatePercentage(wedsale, total));
                extras.putFloat("thusale", calculatePercentage(thusale, total));
                extras.putFloat("frisale", calculatePercentage(frisale, total));
                extras.putFloat("satsale", calculatePercentage(satsale, total));
                extras.putFloat("sunsale", calculatePercentage(sunsale, total));
                extras.putFloat("total", total);

                salesintent.putExtras(extras);

                startActivity(salesintent);
            }
        });
    }

    // editText가 비었는지 확인하는 메소드 정의
    private boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    // 퍼센트 구하기 메소드 정의
    private float calculatePercentage(int value, int total) {
        return (float) value / total * 100;
    }
}