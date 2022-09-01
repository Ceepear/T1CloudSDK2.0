package net.t1y.cloud2.common.frame;
import android.content.Context;
import android.util.ArrayMap;
import android.util.SparseArray;
import net.t1y.cloud2.common.frame.pool.DataPool;
import net.t1y.cloud2.common.service.KeyService;
import net.t1y.cloud2.common.service.ServiceControl;
import net.t1y.cloud2.common.service.ServiceControlKt;
import net.t1y.cloud2.common.service.T1Service;


public class Framework {
    private Context context;
    private DataPool _pool = new DataPool();
    private SparseArray<T1Service> serviceSparseArray = new SparseArray<>();
    public Framework(Context context) {
        this.context = context.getApplicationContext();
    }
    public ServiceControl startService(int i, T1Service service){
        if(service==null){
            throw new NullPointerException("Service object cannot be empty!");
        }
        serviceSparseArray.put(service.hashCode(),service);
        service.onStart();
        switch (i){
            case 0:
                return _startService(service);
            case 1:
                return _startServiceKt(service);
            default:
                return null;
        }
    }
    private ServiceControl _startService(final T1Service service1){
        return new ServiceControl(){
            @Override
            public void with(KeyService service) {
                ServiceControl.super.with(service);
                _pool.put(service1.hashCode(),service);
            }
        };
    }
    private ServiceControlKt _startServiceKt(T1Service service1){
        return new ServiceControlKt() {
            @Override
            public void with(KeyService service) {
                super.with(service);
                _pool.put(service1.hashCode(),service);
            }
        };
    }
    public void close() {
        this.context = null;
        for(int t=0;t<serviceSparseArray.size();t++){
            this.serviceSparseArray.get(this.serviceSparseArray.indexOfKey(t)).onStop();
        }
        this.serviceSparseArray = null;
    }

    public Object getService(String string) {
        if(string.startsWith("service:index:")){
            String cls = string.replace("service:index:","");
            for(int t=0;t<serviceSparseArray.size();t++){
               T1Service service = this.serviceSparseArray.get(t);
               if(service.getClass().getName().contains(cls)){
                   return cls.hashCode();
               }
            }
        }
        return null;
    }
}
