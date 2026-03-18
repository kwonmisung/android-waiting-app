package smu.ai.waiting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TableWithCircles extends androidx.appcompat.widget.AppCompatImageView {

    // 4개의 그림 지정
    private Paint cleanPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint regularPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint servicePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint complainPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TableWithCircles (Context context) {
        super(context);
        init();
    }

    public TableWithCircles (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TableWithCircles (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    // 원의 초기색을 흰색으로 지정하는 method
    private void init(){
        cleanPaint.setColor(Color.WHITE);
        regularPaint.setColor(Color.WHITE);
        servicePaint.setColor(Color.WHITE);
        complainPaint.setColor(Color.WHITE);
    }

    // cleanPaint의 색을 변경하는 method
    public void setCleanCircleColor(int color) {
        cleanPaint.setColor(color);
        invalidate();
    }

    // regularPaint의 색을 변경하는 method
    public void setRegularCircleColor(int color) {
        regularPaint.setColor(color);
        invalidate();
    }

    // servicePaint의 색을 변경하는 method
    public void setServiceCircleColor(int color) {
        servicePaint.setColor(color);
        invalidate();
    }

    // complainPaint의 색을 변경하는 method
    public void setComplainCircleColor(int color) {
        complainPaint.setColor(color);
        invalidate();
    }

    // 원 그리기
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(50, 50, 20, cleanPaint);
        canvas.drawCircle(50, 100, 20, regularPaint);
        canvas.drawCircle(50, 150, 20, servicePaint);
        canvas.drawCircle(50, 200, 20, complainPaint);
    }
}
