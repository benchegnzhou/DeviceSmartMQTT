package devicesmartmqtt.zbc.com.devicesmartmqtt.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import devicesmartmqtt.zbc.com.devicesmartmqtt.R;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_test_badge)
    Button btnTestBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setStatusbar();
    }


    @OnClick({R.id.btn_test_badge})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test_badge:
                startActivity(new Intent(this,Badge4AppActivity.class));
                break;
        }
    }


    /**
     * 设置状态栏
     */
    private void setStatusbar() {
        //状态栏透明色
        //StatusBarUtil.setTranslucent(this, 1);
//        StatusBarUtil.setColorNoTranslucent(this,  getResources().getColor(R.color.comment_person) );
//        StatusBarUtil.setLightMode(this);
    }
}
