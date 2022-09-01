package net.t1y.cloud2.common.service
import net.t1y.cloud2.common.os.Message
abstract class T1Service{
    fun onStart(){

    }
    abstract fun handleMessage(msg:Message)
    fun sendMessage(msg: Message){
        handleMessage(msg)
    }

    fun onStop(){}
}