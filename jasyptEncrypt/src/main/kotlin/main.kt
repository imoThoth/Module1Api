
import org.jasypt.util.text.BasicTextEncryptor


fun main(args: Array<String>) {

    val textEncryptor = BasicTextEncryptor()
    val privateData = "secret-data"
    textEncryptor.setPasswordCharArray("some-random-data".toCharArray())
    val myEncryptedText = textEncryptor.encrypt(privateData)
    println("Encrypted Data = $myEncryptedText")
    val plainText = textEncryptor.decrypt(myEncryptedText)
    println("Encrypted Data = $plainText")

    println(privateData == (plainText))
}

