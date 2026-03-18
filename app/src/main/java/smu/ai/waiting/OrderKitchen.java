package smu.ai.waiting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderKitchen extends AppCompatActivity {

    private Button webbtn, resetbtn, finbtn, btnAdd1, btnMinus1, btnAdd2, btnMinus2, btnAdd3, btnMinus3, btnAdd4, btnMinus4, btnAdd5, btnMinus5, btnAdd6, btnMinus6, btnAdd7, btnMinus7, btnAdd8, btnMinus8, btnAdd9, btnMinus9, btnAdd10, btnMinus10;
    private TextView Count1, Count2, Count3, Count4, Count5, Count6, Count7, Count8, Count9, Count10;
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private int count5 = 0;
    private int count6 = 0;
    private int count7 = 0;
    private int count8 = 0;
    private int count9 = 0;
    private int count10 = 0;
    private TextView item1num, item2num, item3num, item4num, item5num, item6num, item7num, item8num, item9num, item10num,
            item1tv, item2tv, item3tv, item4tv, item5tv, item6tv, item7tv, item8tv, item9tv, item10tv;

    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_kitchen);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_orderkitchen);

        webbtn = findViewById(R.id.webbutton);
        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wb = findViewById(R.id.webView);
                WebSettings webSettings = wb.getSettings();
                webSettings.setJavaScriptEnabled(true);

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);

                wb.setWebViewClient(new WebViewClient());
                wb.loadUrl("http://www.365allfoodmarket.com/?n_media=27758&n_query=%EC%8B%9D%EC%9E%AC%EB%A3%8C%EB%B0%9C%EC%A3%BC&n_rank=7&n_ad_group=grp-a001-01-000000022795929&n_ad=nad-a001-01-000000148687530&n_keyword_id=nkw-a001-01-000003936960032&n_keyword=%EC%8B%9D%EC%9E%AC%EB%A3%8C%EB%B0%9C%EC%A3%BC&n_campaign_type=1&n_ad_group_type=1&n_match=1");
            }
        });

        resetbtn = findViewById(R.id.resetbutton);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1 = 0;
                Count1.setText(count1 + "");
                count2 = 0;
                Count2.setText(count2 + "");
                count3 = 0;
                Count3.setText(count3 + "");
                count4 = 0;
                Count4.setText(count4 + "");
                count5 = 0;
                Count5.setText(count5 + "");
                count6 = 0;
                Count6.setText(count6 + "");
                count7 = 0;
                Count7.setText(count7 + "");
                count8 = 0;
                Count8.setText(count8 + "");
                count9 = 0;
                Count9.setText(count9 + "");
                count10 = 0;
                Count10.setText(count10 + "");
            }
        });

        Count1 = findViewById(R.id.count1);
        Count1.setText(count1 + "");
        btnAdd1 = findViewById(R.id.addbutton1);
        btnMinus1 = findViewById(R.id.minusbutton1);

        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count1++;
                Count1.setText(count1 + "");
            }
        });

        btnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count1 > 0) {
                    count1--;
                    Count1.setText(count1 + "");
                } else if (count1 <= 0) {
                    count1 = 0;
                    Count1.setText(count1 + "");
                }
            }
        });

        Count2 = findViewById(R.id.count2);
        Count2.setText(count2 + "");
        btnAdd2 = findViewById(R.id.addbutton2);
        btnMinus2 = findViewById(R.id.minusbutton2);

        btnAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2++;
                Count2.setText(count2 + "");
            }
        });

        btnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count2 > 0) {
                    count2--;
                    Count2.setText(count2 + "");
                } else if (count2 <= 0) {
                    count2 = 0;
                    Count2.setText(count2 + "");
                }
            }
        });

        Count3 = findViewById(R.id.count3);
        Count3.setText(count3 + "");
        btnAdd3 = findViewById(R.id.addbutton3);
        btnMinus3 = findViewById(R.id.minusbutton3);

        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count3++;
                Count3.setText(count3 + "");
            }
        });

        btnMinus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count3 > 0) {
                    count3--;
                    Count3.setText(count3 + "");
                } else if (count3 <= 0) {
                    count3 = 0;
                    Count3.setText(count3 + "");
                }
            }
        });

        Count4 = findViewById(R.id.count4);
        Count4.setText(count4 + "");
        btnAdd4 = findViewById(R.id.addbutton4);
        btnMinus4 = findViewById(R.id.minusbutton4);

        btnAdd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count4++;
                Count4.setText(count4 + "");
            }
        });

        btnMinus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count4 > 0) {
                    count4--;
                    Count4.setText(count4 + "");
                } else if (count4 <= 0) {
                    count4 = 0;
                    Count4.setText(count4 + "");
                }
            }
        });

        Count5 = findViewById(R.id.count5);
        Count5.setText(count5 + "");
        btnAdd5 = findViewById(R.id.addbutton5);
        btnMinus5 = findViewById(R.id.minusbutton5);

        btnAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count5++;
                Count5.setText(count5 + "");
            }
        });

        btnMinus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count5 > 0) {
                    count5--;
                    Count5.setText(count5 + "");
                } else if (count5 <= 0) {
                    count5 = 0;
                    Count5.setText(count5 + "");
                }
            }
        });

        Count6 = findViewById(R.id.count6);
        Count6.setText(count6 + "");
        btnAdd6 = findViewById(R.id.addbutton6);
        btnMinus6 = findViewById(R.id.minusbutton6);

        btnAdd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count6++;
                Count6.setText(count6 + "");
            }
        });

        btnMinus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count6 > 0) {
                    count6--;
                    Count6.setText(count6 + "");
                } else if (count6 <= 0) {
                    count6 = 0;
                    Count6.setText(count6 + "");
                }
            }
        });

        Count7 = findViewById(R.id.count7);
        Count7.setText(count7 + "");
        btnAdd7 = findViewById(R.id.addbutton7);
        btnMinus7 = findViewById(R.id.minusbutton7);

        btnAdd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count7++;
                Count7.setText(count7 + "");
            }
        });

        btnMinus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count7 > 0) {
                    count7--;
                    Count7.setText(count7 + "");
                } else if (count7 <= 0) {
                    count7 = 0;
                    Count7.setText(count7 + "");
                }
            }
        });

        Count8 = findViewById(R.id.count8);
        Count8.setText(count8 + "");
        btnAdd8 = findViewById(R.id.addbutton8);
        btnMinus8 = findViewById(R.id.minusbutton8);

        btnAdd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count8++;
                Count8.setText(count8 + "");
            }
        });

        btnMinus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count8 > 0) {
                    count8--;
                    Count8.setText(count8 + "");
                } else if (count8 <= 0) {
                    count8 = 0;
                    Count8.setText(count8 + "");
                }
            }
        });

        Count9 = findViewById(R.id.count9);
        Count9.setText(count9 + "");
        btnAdd9 = findViewById(R.id.addbutton9);
        btnMinus9 = findViewById(R.id.minusbutton9);

        btnAdd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count9++;
                Count9.setText(count9 + "");
            }
        });

        btnMinus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count9 > 0) {
                    count9--;
                    Count9.setText(count9 + "");
                } else if (count9 <= 0) {
                    count9 = 0;
                    Count9.setText(count9 + "");
                }
            }
        });

        Count10 = findViewById(R.id.count10);
        Count10.setText(count10 + "");
        btnAdd10 = findViewById(R.id.addbutton10);
        btnMinus10 = findViewById(R.id.minusbutton10);

        btnAdd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count10++;
                Count10.setText(count10 + "");
            }
        });

        btnMinus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count10 > 0) {
                    count10--;
                    Count10.setText(count10 + "");
                } else if (count10 <= 0) {
                    count10 = 0;
                    Count10.setText(count10 + "");
                }
            }
        });

        item1num = (TextView) findViewById(R.id.count1);
        item2num = (TextView) findViewById(R.id.count2);
        item3num = (TextView) findViewById(R.id.count3);
        item4num = (TextView) findViewById(R.id.count4);
        item5num = (TextView) findViewById(R.id.count5);
        item6num = (TextView) findViewById(R.id.count6);
        item7num = (TextView) findViewById(R.id.count7);
        item8num = (TextView) findViewById(R.id.count8);
        item9num = (TextView) findViewById(R.id.count9);
        item10num = (TextView) findViewById(R.id.count10);

        item1tv = (TextView) findViewById(R.id.item_1);
        item2tv= (TextView) findViewById(R.id.item_2);
        item3tv = (TextView) findViewById(R.id.item_3);
        item4tv = (TextView) findViewById(R.id.item_4);
        item5tv = (TextView) findViewById(R.id.item_5);
        item6tv = (TextView) findViewById(R.id.item_6);
        item7tv = (TextView) findViewById(R.id.item_7);
        item8tv = (TextView) findViewById(R.id.item_8);
        item9tv = (TextView) findViewById(R.id.item_9);
        item10tv = (TextView) findViewById(R.id.item_10);

        finbtn = findViewById(R.id.finishbtn);
        Intent intent = new Intent(OrderKitchen.this, OrderFin.class);
        finbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i1_num, i2_num, i3_num, i4_num, i5_num, i6_num, i7_num, i8_num, i9_num, i10_num;
                String item1, item2, item3, item4, item5, item6, item7, item8, item9, item10;

                i1_num = item1num.getText().toString();
                i2_num = item2num.getText().toString();
                i3_num = item3num.getText().toString();
                i4_num = item4num.getText().toString();
                i5_num = item5num.getText().toString();
                i6_num = item6num.getText().toString();
                i7_num = item7num.getText().toString();
                i8_num = item8num.getText().toString();
                i9_num = item9num.getText().toString();
                i10_num = item10num.getText().toString();

                item1 = item1tv.getText().toString();
                item2 = item2tv.getText().toString();
                item3 = item3tv.getText().toString();
                item4 = item4tv.getText().toString();
                item5 = item5tv.getText().toString();
                item6 = item6tv.getText().toString();
                item7 = item7tv.getText().toString();
                item8 = item8tv.getText().toString();
                item9 = item9tv.getText().toString();
                item10 = item10tv.getText().toString();

                item1tv = (TextView) findViewById(R.id.item_1);
                item2tv = (TextView) findViewById(R.id.item_2);
                item3tv = (TextView) findViewById(R.id.item_3);
                item4tv = (TextView) findViewById(R.id.item_4);
                item5tv = (TextView) findViewById(R.id.item_5);
                item6tv = (TextView) findViewById(R.id.item_6);
                item7tv = (TextView) findViewById(R.id.item_7);
                item8tv = (TextView) findViewById(R.id.item_8);
                item9tv = (TextView) findViewById(R.id.item_9);
                item10tv = (TextView) findViewById(R.id.item_10);

                Bundle extras = new Bundle();
                extras.putString("i1", i1_num);
                extras.putString("i2", i2_num);
                extras.putString("i3", i3_num);
                extras.putString("i4", i4_num);
                extras.putString("i5", i5_num);
                extras.putString("i6", i6_num);
                extras.putString("i7", i7_num);
                extras.putString("i8", i8_num);
                extras.putString("i9", i9_num);
                extras.putString("i10", i10_num);

                extras.putString("t1", item1);
                extras.putString("t2", item2);
                extras.putString("t3", item3);
                extras.putString("t4", item4);
                extras.putString("t5", item5);
                extras.putString("t6", item6);
                extras.putString("t7", item7);
                extras.putString("t8", item8);
                extras.putString("t9", item9);
                extras.putString("t10", item10);

                intent.putExtras(extras);

                AlertDialog.Builder builder = new AlertDialog.Builder(OrderKitchen.this);
                builder.setTitle("발주 확정");
                builder.setMessage("발주 정보를 모두 확인하셨습니까?\n확인을 누르면 발주가 확정됩니다.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                        Toast.makeText(OrderKitchen.this, "발주가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    }

                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(OrderKitchen.this,"취소하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}