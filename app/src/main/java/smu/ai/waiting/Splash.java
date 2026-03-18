package smu.ai.waiting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splash extends AppCompatActivity {

    Animation anim_Fadein, anim_Character;
    ImageView ivLogo;
    LinearLayout characterLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ivLogo = (ImageView) findViewById(R.id.imageViewLogo);
        characterLayout = (LinearLayout) findViewById(R.id.CharacterLayout);

        anim_Fadein = AnimationUtils.loadAnimation(this, R.anim.anim_splash_fadein);
        anim_Character = AnimationUtils.loadAnimation(this, R.anim.anim_character);

        // fadein 애니메이션 후 splash 애니메이션 넣기
        anim_Fadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash.this, MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 애니메이션 등록
        ivLogo.startAnimation(anim_Fadein);
        characterLayout.startAnimation(anim_Character);
    }
}