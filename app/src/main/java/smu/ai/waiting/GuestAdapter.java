package smu.ai.waiting;

import android.content.Context;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import android.os.Handler;
import android.widget.Toast;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {
    private ArrayList<GuestInfo> mGuestList;
    private Context context;
    private DatabaseReference mDatabase;

    @NonNull
    @Override
    public GuestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_guestinfo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestAdapter.ViewHolder holder, int position) {
        holder.onBind(mGuestList.get(position));
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {  // 삭제 이벤트 등록
            @Override
            public void onClick(View v) {
                remove(holder.getAdapterPosition());
            }
        });

        // 문자 보내기 이벤트 등록
        holder.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                String phonenumber = holder.tvPhone.getText().toString();

                String message = "안녕하세요. 고객님!\n" +
                        "웨이팅 성공을 축하드려요!\n" +
                        "호출 혹은 전화 이후 5분 내로 안 오실 경우 취소되실 수 있습니다.";
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phonenumber, null, message, null, null);

                // 5분 후에 두 번째 메시지 전송 & 웨이팅 목록에서 삭제
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String secondMessage = "웨이팅이 취소되었습니다.\n" +
                                "이용해 주셔서 감사합니다.";
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(phonenumber, null, secondMessage, null, null);

                        remove(holder.getAdapterPosition());
                    }
                }, 5 * 60 * 1000); // 5분 동안의 지연 (5 * 60 * 1000 밀리초)
            }
        });
    }

    public GuestAdapter(Context context, DatabaseReference databaseReference){
        this.context = context;
        this.mDatabase = databaseReference;
    }

    // 원하는 정보 삭제하는 method 정의
    public void remove(int position) {
        try {
            if (position >= 0 && position < mGuestList.size()) {
                GuestInfo guestInfoDelete = mGuestList.get(position);
                mDatabase = FirebaseDatabase.getInstance().getReference("guests");
                String guestKey = String.valueOf(guestInfoDelete.order);

                // guestKey에 해당하는 데이터를 FireBase에서 삭제
                mDatabase.child(guestKey).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                // 삭제 성공
                                // 어댑터에서 데이터 삭제
                                mGuestList.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // 삭제 실패
                            }
                        });
            }
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public void setGuestList(ArrayList<GuestInfo> list) {
        this.mGuestList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mGuestList.size();
    }

    // ViewHolder class 생성
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrder, tvName, tvPhone, tvAdnumber, tvChnumber;
        Button btnSend, btnDelete;

        public ViewHolder(@NonNull View guestView) {
            super(guestView);

            tvOrder = (TextView) guestView.findViewById(R.id.ordertextView);
            tvName = (TextView) guestView.findViewById(R.id.nametextView);
            tvPhone = (TextView) guestView.findViewById(R.id.phonetextView);
            tvAdnumber = (TextView) guestView.findViewById(R.id.adnumbertextView);
            tvChnumber = (TextView) guestView.findViewById(R.id.chnumbertextView);
            btnSend = (Button) guestView.findViewById(R.id.buttonSend);
            btnDelete = (Button)guestView.findViewById(R.id.buttonDelete);
        }

        void onBind(GuestInfo guest) {
            tvOrder.setText(String.valueOf(guest.getOrder()));
            tvName.setText(guest.getName());
            tvPhone.setText(guest.getPhonenumber());
            tvAdnumber.setText(guest.getAdnumber());
            tvChnumber.setText(guest.getChnumber());
        }
    }
}