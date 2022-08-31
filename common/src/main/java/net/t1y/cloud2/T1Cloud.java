package net.t1y.cloud2;
import android.content.Context;
import net.t1y.cloud2.common.os.DebugCtrl;
import net.t1y.cloud2.common.os.T1CloudCtrl;
import net.t1y.cloud2.common.service.KeyService2;
import net.t1y.cloud2.common.service.ServiceControlKt;
import net.t1y.cloud2.common.service.T1Service;

public final class T1Cloud implements T1CloudCtrl {
    private static T1Cloud t1y = null;
    private Context context;
    private boolean _kotlinGlobalScope;
    private DebugCtrl _debugCtrl;
    private T1Cloud(Context context) {
        this.context = context.getApplicationContext();
    }
    public static T1Cloud init(Context context){
        if(t1y == null){
            t1y = new T1Cloud(context);
        }
        return t1y;
    }
    private void startService(T1Service service, KeyService2 keyService2){

    }

    public ServiceControlKt startServiceKotlin(T1Service service){
        return new ServiceControlKt();
    }

    public void openKotlinGlobalScope(){
        this._kotlinGlobalScope = true;
    }
    public void closeKotlinGlobalScope(){
        this._kotlinGlobalScope = false;
    }
    public void openDebug(DebugCtrl debugCtrl){
        this._debugCtrl = debugCtrl;
    }
    public void closeDebug(){
        this._debugCtrl = null;
    }
    @Override
    public void close() {
        t1y = null;
    }
    public static T1CloudCtrl getStack(){
        return t1y;
    }
}
