package li.zhuoyuan.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 帅裂苍穹的卓原 on 2016/9/22 17:15 .
 * email: zhuoyuan93@gmail.com
 * 属性动画
 */


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();

                /*PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0f, 200f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0f, 200f);
                ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(1000).start();*/

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 360f);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360f);
                final ObjectAnimator animator4 = ObjectAnimator.ofFloat(button, "rotation", 0, 360f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1, animator2, animator3);

               /* animatorSet.play(animator1).with(animator2).with(animator3);
                animatorSet.play(animator4).after(animator1);*/

                // animatorSet.playSequentially(animator1, animator2, animator3, animator4);
                /*animator1.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        animator4.setDuration(1000).start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                    }
                });*/
                animator1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();

                    }
                });
                animatorSet.setDuration(1000).start();


            }
        });

    }
}
