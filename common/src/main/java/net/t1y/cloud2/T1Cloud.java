package net.t1y.cloud2;
import android.content.Context;
import net.t1y.cloud2.common.frame.Framework;
import net.t1y.cloud2.common.os.DebugCtrl;
import net.t1y.cloud2.common.os.HttpCtrl;
import net.t1y.cloud2.common.os.T1CloudCtrl;
import net.t1y.cloud2.common.service.KeyService2;
import net.t1y.cloud2.common.service.ServiceControl;
import net.t1y.cloud2.common.service.ServiceControlKt;
import net.t1y.cloud2.common.service.T1Service;

public final class T1Cloud implements T1CloudCtrl {
    private static T1Cloud t1y = null;
    private boolean _kotlinGlobalScope;
    private DebugCtrl _debugCtrl;
    private Framework framework;
    private HttpCtrl httpCtrl;
    private T1Cloud(Context context) {
        this.framework = new Framework(context);
    }
    public static T1Cloud init(Context context){
        if(t1y == null){
            t1y = new T1Cloud(context);
        }
        return t1y;
    }
    public ServiceControl startService(T1Service service){
        return framework.startService(0,service);
    }

    public ServiceControlKt startServiceKotlin(T1Service service){
        return (ServiceControlKt) framework.startService(1,service);
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

    @Override
    public void setHttpCtrl(HttpCtrl httpCtrl) {
        this.httpCtrl = httpCtrl;
    }

    public HttpCtrl getHttpCtrl() {
        return httpCtrl;
    }

    @Override
    public Object getCloudService(String string) {
        return this.framework.getService(string);
    }

    public void closeDebug(){
        this._debugCtrl = null;
    }
    @Override
    public void close() {
        t1y = null;
        framework.close();
    }
    public static T1CloudCtrl getStack(){
        return t1y;
    }
}
