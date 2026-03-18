package smu.ai.waiting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Waitlist extends AppCompatActivity {

    DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    private GuestAdapter guestAdapter;
    private ArrayList<GuestInfo> guestInfo;
    Button btnDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waitlist);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_waitlist);

        // RecyclerView에 수직뷰 등록하기
        recyclerView = (RecyclerView) findViewById(R.id.guestListview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // 리스트 생성하기
        guestInfo = new ArrayList<>();

        // 저장한 정보 꺼내오기 & 어댑터 수정하기
        mDatabase = FirebaseDatabase.getInstance().getReference("guests");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                guestInfo.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    GuestInfo guest = dataSnapshot.getValue(GuestInfo.class);
                    guestInfo.add(guest);
                }
                guestAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // 어댑터에 리스트 등록 & 리사이클러뷰에 어댑터 등록
        guestAdapter = new GuestAdapter(this, mDatabase);
        guestAdapter.setGuestList(guestInfo);
        recyclerView.setAdapter(guestAdapter);
    }
}
