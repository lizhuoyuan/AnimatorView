package li.zhuoyuan.customview;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res = {R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f, R.id.g, R.id.h
    };
    private List<ImageView> imageViewList = new ArrayList<>();
    private boolean flag = true;
    private double r = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageViewList.add(imageView);
            imageView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.a:
                if (flag) {
                    startAnim();
                    flag = false;
                } else {
                    closeAnim();
                    flag = true;
                }
                break;
            case R.id.h:
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                Toast.makeText(AnimatorActivity.this, "" + view.getId(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnim() {
        for (int i = 1; i < res.length; i++) {
            float y = (float) (r * Math.sin((Math.PI / 2) / (res.length - 2) * (i - 1)));
            float x = (float) (r * Math.cos((Math.PI / 2) / (res.length - 2) * (i - 1)));
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY", y, 0);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationX", x, 0);
            animator1.setDuration(500).start();
            animator2.setDuration(500).start();
        }
    }

    private void startAnim() {
        for (int i = 1; i < res.length; i++) {
            float y = (float) (r * Math.sin((Math.PI / 2) / (res.length - 2) * (i - 1)));
            float x = (float) (r * Math.cos((Math.PI / 2) / (res.length - 2) * (i - 1)));
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY", 0, y);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationX", 0, x);
            // i * 100    (res.length - i) * 100
            // AnimatorSet set = new AnimatorSet();
            // set.setInterpolator(new BounceInterpolator());
            // set.playTogether(animator1, animator2);
            // set.setDuration(500).start();
            animator1.setDuration(500).start();
            animator2.setDuration(500).start();
        }
    }
}
