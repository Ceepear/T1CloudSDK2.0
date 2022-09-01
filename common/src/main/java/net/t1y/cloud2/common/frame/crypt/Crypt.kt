package net.t1y.cloud2.common.frame.crypt
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Crypt {
    fun md5(plainText: String): String? {
        return try {
            val secretBytes: ByteArray =
                MessageDigest.getInstance("md5").digest(plainText.toByteArray())
            var md5code: String = BigInteger(1, secretBytes).toString(16)
            for (i in 0 until 32 - md5code.length) {
                md5code = "0$md5code"
            }
            md5code
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("没有这个md5算法！")
        }
    }

    fun aesEncode(iv:String,key:String,text: String): String? {
        return try {
            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
            val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
            val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
            cipher.init(1, secretKeySpec, ivParameterSpec)
            val encryptedData: ByteArray = cipher.doFinal(text.toByteArray())
            Base64.encode(encryptedData)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    fun aesDecode(iv:String,key:String,text: String): String? {
        return try {
            val decodeByte = Base64.decode(text)
            val ivParameterSpec = IvParameterSpec(iv.toByteArray())
            val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
            val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
            cipher.init(2, secretKeySpec, ivParameterSpec)
            val bytes: ByteArray = cipher.doFinal(decodeByte)
            String(bytes)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}