package smu.ai.waiting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class Guest extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private EditText name, email, password, check;
    private Button checkbtn, joinbtn, backbtn;
    Boolean checkpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_guest);

        name = findViewById(R.id.joinname);
        email = findViewById(R.id.joinemail);
        password = findViewById(R.id.joinpwd);
        check = findViewById(R.id.checkpwd);

        //가입버튼 화면 전환 & 다이얼로그 띄우기
        joinbtn = findViewById(R.id.join_btn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameText = name.getText().toString().trim();
                final String emailText = email.getText().toString().trim();
                final String pwdText = password.getText().toString().trim();
                final String checkText = check.getText().toString().trim();
                checkpwd = checkText.equals(pwdText);
                if ((emailText != null) && !emailText.isEmpty() && (pwdText != null) && !pwdText.isEmpty() && (nameText != null) && !nameText.isEmpty() && (checkText != null) && !checkText.isEmpty()) {
                    if (checkpwd == true) {
                        AlertDialog.Builder guestbuilder = new AlertDialog.Builder(Guest.this);
                        guestbuilder.setTitle("회원가입");
                        guestbuilder.setMessage("이 정보로 회원가입 하시겠습니까?");
                        guestbuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 추가한 내용
                                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                                        .addOnCompleteListener(Guest.this, new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {

                                                if (task.isSuccessful()) {
                                                    FirebaseUser user = mAuth.getCurrentUser();
                                                    Intent intent = new Intent(Guest.this, Login.class);
                                                    startActivity(intent);
                                                    Toast.makeText(Guest.this, "회원가입 되었습니다.", Toast.LENGTH_SHORT).show();
                                                    finish();
                                                } else {
                                                    Toast.makeText(Guest.this, "이미 존재하는 계정입니다.",
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        });
                        guestbuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Guest.this, "취소 하셨습니다.", Toast.LENGTH_SHORT).show();

                            }
                        });
                        AlertDialog dialog = guestbuilder.create();
                        dialog.show();
                    } else {
                        Toast.makeText(Guest.this, "비밀번호가 일치하지 않습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Guest.this, "모든 값이 입력되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                }

                //뒤로가기 화면 전환
                backbtn = findViewById(R.id.backbutton);
                backbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Guest.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}

