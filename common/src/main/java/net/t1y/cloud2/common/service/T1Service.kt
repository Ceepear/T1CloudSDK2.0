package net.t1y.cloud2.common.service
import net.t1y.cloud2.common.os.Message
import net.t1y.cloud2.common.os.T1CloudCtrl

abstract class T1Service{
    private lateinit var cloud:T1CloudCtrl
    fun onStart(){

    }
    abstract fun handleMessage(msg:Message)
    fun sendMessage(msg: Message){
        handleMessage(msg)
    }
    fun getServiceManger(): T1CloudCtrl {
        return cloud
    }
    fun setT1ServiceManger(cloud:T1CloudCtrl){
        this.cloud = cloud;
    }

    fun onStop(){}
}