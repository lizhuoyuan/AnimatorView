package li.zhuoyuan.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 卓原 on 2016/9/22.
 * email: zhuoyuan93@gmail.com
 */

public class FirstCustomView extends RelativeLayout {

    private Button leftbtn, rightbtn;
    private TextView tvtitle;

    private int leftcolor;
    private Drawable leftBackground;
    private String leftbtntext;

    private int rightcolor;
    private Drawable rightBackground;
    private String rightbtntext;

    private float titleSize;
    private int titleColor;
    private String titletext;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public FirstCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FirstCustomView);
        leftcolor = typedArray.getColor(R.styleable.FirstCustomView_leftcolor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.FirstCustomView_leftbackground);
        leftbtntext = typedArray.getString(R.styleable.FirstCustomView_lefttext);

        typedArray.recycle();
        leftbtn = new Button(context);
        leftbtn.setText(leftbtntext);
        leftbtn.setBackground(leftBackground);
        leftbtn.setTextColor(leftcolor);
    }
}
