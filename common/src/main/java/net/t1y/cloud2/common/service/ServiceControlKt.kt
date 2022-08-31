package net.t1y.cloud2.common.service;

class ServiceControlKt {
    fun with(func:()->KeyService){
        func()
    }
}
