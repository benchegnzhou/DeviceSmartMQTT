package devicesmartmqtt.zbc.com.devicesmartmqtt.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tot.badges.IconBadgeNumManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import devicesmartmqtt.zbc.com.devicesmartmqtt.R;
import devicesmartmqtt.zbc.com.devicesmartmqtt.util.badgeUtil;
/**
 * Created by benchengzhou on 2019/5/12 23:13.
 * 作者邮箱：mappstore@163.com
 * 功能描述：
 * 类    名： Badge4AppActivity
 * 备    注： 
 */
public class Badge4AppActivity extends AppCompatActivity {

    @Bind(R.id.btn_badge_show)
    Button btnBadgeShow;
    private IconBadgeNumManager setIconBadgeNumManager;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge4_app);
        ButterKnife.bind(this);
//        badgeUtil.addNumShortCut(this, this.getClass(), true, "20", true);
        setIconBadgeNumManager = new IconBadgeNumManager();
    }


    @OnClick({R.id.btn_badge_show,R.id.btn_badge_dissmis})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_badge_show:
                count+=10;
                sendIconNumNotification();
                break;
            case R.id.btn_badge_dissmis:
                count=0;
                sendIconNumNotification();
                break;
        }
    }




    private void sendIconNumNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm == null) return;
        String notificationChannelId = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = createNotificationChannel();
            nm.createNotificationChannel(notificationChannel);
            notificationChannelId = notificationChannel.getId();
        }
        Notification notification = null;
        try {
            notification = new NotificationCompat.Builder(this, notificationChannelId)
                    .setSmallIcon(getApplicationInfo().icon)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle("title")
                    .setContentText("content num: " + count)
                    .setTicker("ticker")
                    .setAutoCancel(true)
                    .setNumber(count)
                    .build();
            notification = setIconBadgeNumManager.setIconBadgeNum(getApplication(), notification, count);

            nm.notify(32154, notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static NotificationChannel createNotificationChannel() {
        String channelId = "test";
        NotificationChannel channel = null;
        channel = new NotificationChannel(channelId,
                "Channel1", NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(true); //是否在桌面icon右上角展示小红点
        channel.setLightColor(Color.RED); //小红点颜色
        channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
        return channel;
    }
}
