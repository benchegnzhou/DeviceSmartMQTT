package devicesmartmqtt.zbc.com.devicesmartmqtt.application;

import android.app.Application;
import android.content.Context;

import com.ztsc.commonutils.CommonUtil;
import com.ztsc.commonutils.utilconfig.Config;
 /**
  * Created by benchengzhou on 2019/5/12 0:16.
  * 作者邮箱：mappstore@163.com
  * 功能描述：
  * 类    名： MApplication
  * 备    注： 
  */

public class MApplication extends Application {
    public static Application sApplication;
    public static Context sAppContext;



    @Override
    public void onCreate() {
        super.onCreate();
        CommonUtil.getInstance().init(this, new Config()
                .setLogOpen(true)
                .setLogTag("DEVICE_SMART")
                .setToastOpen(true));

        //获取全局上下文
        sAppContext =this.getApplicationContext();
        sApplication = this;
    }
}
