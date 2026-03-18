package smu.ai.waiting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Waiting extends AppCompatActivity {

    DatabaseReference mDatabase;
    private Button adbtnAdd, adbtnMinus, chbtnAdd, chbtnMinus, registerbtn;
    private TextView adCount, chCount;
    private EditText guestName, gusetPhoneNumber;
    private CheckBox chbox;
    private int adcount = 0;
    private int chcount = 0;
    private int order;
    private int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_waiting);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        guestName = findViewById(R.id.joinpwd);
        gusetPhoneNumber = findViewById(R.id.phonenumber);

        adCount = findViewById(R.id.adultcount);
        adCount.setText(adcount + "");
        adbtnAdd = findViewById(R.id.addbutton1);
        adbtnMinus = findViewById(R.id.minusbutton1);

        chbox = findViewById(R.id.check);

        // 성인 수 조정하기
        adbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adcount < 9) {
                    adcount++;
                    adCount.setText(adcount + "");
                } else if (adcount >= 8) {  // 8로 수정
                    adcount = 8;
                    adCount.setText(adcount + "");
                }
            }
        });

        adbtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adcount > 0) {
                    adcount--;
                    adCount.setText(adcount + "");
                } else if (adcount <= 0) {
                    adcount = 0;
                    adCount.setText(adcount + "");
                }
            }
        });

        chCount = findViewById(R.id.childcount);
        chCount.setText(chcount + "");
        chbtnAdd = findViewById(R.id.addbutton2);
        chbtnMinus = findViewById(R.id.minusbutton2);

        // 아동 수 조정하기
        chbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chcount < 5) {
                    chcount++;
                    chCount.setText(chcount + "");
                } else if (adcount >= 5) {  // 8로 수정
                    chcount = 5;
                    chCount.setText(chcount + "");
                }
            }
        });

        chbtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chcount > 0) {
                    chcount--;
                    chCount.setText(chcount + "");
                } else if (chcount <= 0) {
                    chcount = 0;
                    chCount.setText(chcount + "");
                }
            }
        });

        // Firebase에서 데이터베이스의 상태를 가져오는 코드
        mDatabase.child("guests").get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                // Firebase에서 현재까지 저장된 guests의 개수를 가져와서 order와 key를 설정
                long count = dataSnapshot.getChildrenCount();
                order = (int) count + 1;
                key = order; // key도 order 값으로 설정

                registerbtn = findViewById(R.id.wait_btn);
                registerbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 입력받은 데이터 변수에 저장
                        String getAdNumber = adCount.getText().toString();
                        String getChNumber = chCount.getText().toString();
                        String getGuestName = guestName.getText().toString();
                        String getGuestPhonenumber = gusetPhoneNumber.getText().toString();

                        if ((getGuestName != null) && !getGuestName.isEmpty() && (getGuestPhonenumber != null) && !getGuestPhonenumber.isEmpty() && (adcount != 0)) {
                            if (chbox.isChecked()) {  // 개인정보 제공에 동의한 경우
                                AlertDialog.Builder registerbuilder = new AlertDialog.Builder(Waiting.this);
                                registerbuilder.setTitle("웨이팅 확정");
                                registerbuilder.setMessage("웨이팅 하시는 정보가 맞는지 확인해주세요. \n확인 버튼을 누르면 웨이팅이 등록됩니다.");
                                registerbuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        // key 값에 맞춰 입력받은 데이터 넣기
                                        HashMap result = new HashMap<>();
                                        result.put("order", order);
                                        result.put("adult", getAdNumber);
                                        result.put("child", getChNumber);
                                        result.put("name", getGuestName);
                                        result.put("phonenumber", getGuestPhonenumber);

                                        // writeGuest method 호출하여 데이터 저장
                                        writeGuest(order, getAdNumber, getChNumber, getGuestName, getGuestPhonenumber);

                                        // MainActivity2.java에 현재 웨이팅 팀 수 전달
                                        Intent intent = new Intent(Waiting.this, MainActivity2.class);
                                        intent.putExtra("순서", String.valueOf(order));

                                        startActivity(intent);
                                        Toast.makeText(Waiting.this, "웨이팅 등록되었습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                registerbuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(Waiting.this, "취소 하셨습니다.", Toast.LENGTH_SHORT).show();

                                    }
                                });
                                AlertDialog dialog = registerbuilder.create();
                                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                                    @Override
                                    public void onShow(DialogInterface arg0) {
                                        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                                        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                                    }
                                });
                                dialog.show();
                            } else {  // 개인정보 동의 체크박스를 누르지 않았을 경우
                                Toast.makeText(Waiting.this, "개인정보 제공에 동의해주세요.", Toast.LENGTH_SHORT).show();
                            }
                        } else {  // 값이 입력되지 않은 경우
                            Toast.makeText(Waiting.this, "값이 제대로 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // 데이터베이스 읽기 실패 시 처리
                Toast.makeText(Waiting.this, "데이터를 불러오는 데 실패했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // key 값을 이용해 입력받은 정보를 Database에 저장하는 method
    private void writeGuest(int order, String adnumber, String chnumber, String name, String phonenumber) {
        String guestId = Integer.toString(key);
        GuestInfo guest = new GuestInfo(order, adnumber, chnumber, name, phonenumber);

        mDatabase.child("guests").child(guestId).setValue(guest);
    }
}