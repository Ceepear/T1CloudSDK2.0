package net.t1y.cloud2.common.frame.pool;

import android.util.SparseArray;
import net.t1y.cloud2.common.service.KeyService;
import net.t1y.cloud2.common.service.T1Service;

public class DataPool {
    private SparseArray<KeyService> serviceSparseArray = new SparseArray<>();
    public void put(int code, KeyService service){
        serviceSparseArray.put(code,service);
    }
    public String[] get(int code){
        KeyService service = serviceSparseArray.get(code);
        return new String[]{service.getPublicKey(),service.getPrivateKey()};
    }
    public void clear(){
        this.serviceSparseArray.clear();
        this.serviceSparseArray = null;
    }
}
