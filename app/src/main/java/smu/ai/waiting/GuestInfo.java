package smu.ai.waiting;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class GuestInfo {

    int order;
    String adnumber;
    String chnumber;
    String name;
    String phonenumber;


    // 고객 정보를 입력받는 생성자 GuestInfo
    public GuestInfo() {}
    public GuestInfo(int order, String adnumber, String chnumber, String name, String phonenumber){
        this.order = order;
        this.adnumber = adnumber;
        this.chnumber = chnumber;
        this.name = name;
        this.phonenumber = phonenumber;
    }

    // 입력값을 가져오는 getter method
    public int getOrder(){return order;}

    public String getAdnumber() {return adnumber;}

    public String getChnumber() {return chnumber;}

    public String getName() {return name;}

    public String getPhonenumber() {return phonenumber;}
}