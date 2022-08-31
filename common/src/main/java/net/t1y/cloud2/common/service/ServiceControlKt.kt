package net.t1y.cloud2.common.service;
abstract class ServiceControlKt:ServiceControl {
    fun with(func:()->KeyService){
        val key = func()
        this.with(key)
    }
}
