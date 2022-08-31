package net.t1y.cloud2;
import android.content.Context;
import net.t1y.cloud2.common.service.ServiceControl;
import net.t1y.cloud2.common.service.T1Service;
public class T1Cloud {
    private static T1Cloud t1y = null;
    private Context context;
    private T1Cloud(Context context) {
        this.context = context.getApplicationContext();
    }
    public static void init(Context context){
        if(t1y == null){
            t1y = new T1Cloud(context);
        }
    }
    public ServiceControl startService(T1Service service){
        return null;
    }
}
