package net.t1y.cloud2.common.frame.crypt

import android.os.Build
import net.t1y.cloud2.common.os.Message
import net.t1y.cloud2.common.service.T1Service
import java.util.Base64

class Base64 {
    companion object{
    fun encode(bytes: ByteArray?): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Base64.getEncoder().encodeToString(bytes)
        } else android.util.Base64.encodeToString(bytes, android.util.Base64.NO_WRAP)
    }
    fun decode(s: String?): ByteArray? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Base64.getDecoder().decode(s)
        } else android.util.Base64.decode(s, android.util.Base64.DEFAULT)
    }
        }
}