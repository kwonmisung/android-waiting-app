package smu.ai.waiting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {
    private Button btnList, btnManage, btnOrder, btnSale, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_settings);

        // 웨이팅 목록을 보여주는 페이지로 이동
        btnList = findViewById(R.id.buttonList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Waitlist.class);
                startActivity(intent);
            }
        });

        // 매장을 관리할 수 있는 페이지로 이동
        btnManage = findViewById(R.id.buttonManage);
        btnManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Management.class);
                startActivity(intent);
            }
        });

        // 물품을 발주할 수 있는 페이지로 이동
        btnOrder = findViewById(R.id.buttonOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, OrderMain.class);
                startActivity(intent);
            }
        });

        // 매출을 입력할 수 있는 페이지로 이동
        btnSale = findViewById(R.id.buttonSale);
        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Sales.class);
                startActivity(intent);
            }
        });

        // 로그아웃할 수 있는 페이지로 이동
        btnLogout = findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, Logout.class);
                startActivity(intent);
            }
        });

    }
}