package net.t1y.cloud2.common.service
import java.io.InputStream

abstract class KeyService2(val inputStream: InputStream){
    abstract fun getKeyService()
}
