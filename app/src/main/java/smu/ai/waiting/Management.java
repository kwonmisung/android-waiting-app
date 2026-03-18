package smu.ai.waiting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Management extends AppCompatActivity {

    TableWithCircles[] tables;  // table을 담는 배열
    Dialog manageDialog;
    Button btnOk, btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_management);

        // table 배열 만들기
        tables = new TableWithCircles[7];
        tables[0] = findViewById(R.id.table1);
        tables[1] = findViewById(R.id.table2);
        tables[2] = findViewById(R.id.table3);
        tables[3] = findViewById(R.id.table4);
        tables[4] = findViewById(R.id.table5);
        tables[5] = findViewById(R.id.table6);
        tables[6] = findViewById(R.id.table7);

        // 각 table에 Dialog 등록
        for (int i = 0; i < 7; i++){
            final int tableIndex = i;
            tables[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomDialog(tableIndex);
                }
            });
        }
    }

    // Dialog 보여주는 method 정의
    public void showCustomDialog(final int tableIndex){
        manageDialog = new Dialog(Management.this);
        manageDialog.setContentView(R.layout.management_dialog);

        CheckBox cbClean, cbRegular, cbService, cbComplain;
        cbClean = manageDialog.findViewById(R.id.checkBoxClean);
        cbRegular = manageDialog.findViewById(R.id.checkBoxRegular);
        cbService = manageDialog.findViewById(R.id.checkBoxService);
        cbComplain = manageDialog.findViewById(R.id.checkBoxComplain);

        // 원의 색을 변경 적용
        btnOk = manageDialog.findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCircleColors(tableIndex, cbClean.isChecked(), cbRegular.isChecked(), cbService.isChecked(), cbComplain.isChecked());
                manageDialog.dismiss();
            }
        });

        // Dialog 닫기
        btnCancel = manageDialog.findViewById(R.id.buttonCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageDialog.dismiss();
            }
        });

        manageDialog.show();
    }

    // 체크박스 체크 여부에 맞춰 원의 색 변경
    private void updateCircleColors(int tableIndex, boolean isCleanChecked, boolean isRegularChecked, boolean isServiceChecked, boolean isComplainChecked) {
        // 각 테이블에 대한 색상 업데이트
        if (isCleanChecked) {
            tables[tableIndex].setCleanCircleColor(Color.RED);
        } else {
            tables[tableIndex].setCleanCircleColor(Color.WHITE);
        }
        if (isRegularChecked) {
            tables[tableIndex].setRegularCircleColor(Color.YELLOW);
        } else {
            tables[tableIndex].setRegularCircleColor(Color.WHITE);
        }
        if (isServiceChecked) {
            tables[tableIndex].setServiceCircleColor(Color.GREEN);
        } else {
            tables[tableIndex].setServiceCircleColor(Color.WHITE);
        }
        if (isComplainChecked) {
            tables[tableIndex].setComplainCircleColor(Color.BLUE);
        } else {
            tables[tableIndex].setComplainCircleColor(Color.WHITE);
        }
    }
}