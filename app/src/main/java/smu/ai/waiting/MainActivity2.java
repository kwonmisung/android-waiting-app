package smu.ai.waiting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    DatabaseReference mDatabase;
    private TextView tv_team;
    private Button waitbtn, setbtn;
    private int order;
    private String  index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        tv_team = findViewById(R.id.waitnum);
        mDatabase.child("guests").get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                tv_team.setText(String.valueOf(count));
            }
        }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // 데이터베이스 읽기 실패 시 처리
                    Toast.makeText(MainActivity2.this, "데이터를 불러오는 데 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            });

        waitbtn=findViewById(R.id.waitbutton);
        waitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Waiting.class);
                startActivity(intent);
            }
        });

        setbtn=findViewById(R.id.setting_btn);
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}