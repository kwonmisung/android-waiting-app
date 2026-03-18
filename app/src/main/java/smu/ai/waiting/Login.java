package smu.ai.waiting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private boolean saveLoginData;
    private CheckBox login_chk;
    private SharedPreferences appData;
    private String id;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText login_id, login_pwd;
    private Button loginbtn;

    /*@Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent login_intent = new Intent(Login.this, MainActivity2.class);
            startActivity(login_intent);
            Toast.makeText(this, "자동 로그인 \n" + user.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_login);

        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();

        login_chk = findViewById(R.id.login_chk);
        login_id = findViewById(R.id.loginemail);
        login_pwd = findViewById(R.id.loginpwd);

        loginbtn = findViewById(R.id.login_btn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_id.getText().toString().trim();
                String pwd = login_pwd.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {//성공했을때
                                    Intent intent = new Intent(Login.this, MainActivity2.class);
                                    startActivity(intent);
                                } else {//실패했을때
                                    Toast.makeText(Login.this, "아이디와 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                save();

            }
        });

        if (saveLoginData) {
            login_id.setText(id);             // 아이디가 입력된 상태로 유지
            login_chk.setChecked(saveLoginData); // 체크된 상태로 유지
        }
    }

    private void save() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putBoolean("SAVE_LOGIN_DATA", login_chk.isChecked());
        editor.putString("ID", login_id.getText().toString().trim());

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }

    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        saveLoginData = appData.getBoolean("SAVE_LOGIN_DATA", false);
        id = appData.getString("ID", "");
    }
}