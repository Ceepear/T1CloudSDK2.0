package net.t1y.cloud2.common.service

open class T1Service {
    private var _kotlinGlobalScope:Boolean = false
    fun openKotlinGlobalScope(b:Boolean){
        this._kotlinGlobalScope = b
    }
}