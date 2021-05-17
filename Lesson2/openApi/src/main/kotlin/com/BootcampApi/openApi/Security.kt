//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import java.util.*
//
//
//object Hash {
//    @JvmStatic
//    fun main(args: Array<String>) {
//
//        var random = Random()
//        var i = 0
//        val symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!£$%^&*()" //acts as symbol for potential password
//        var password: String? = "" //password will be returned at the end of method
//        var length = 6
//        while (i < length) {
//            val character =
//                symbols[random.nextInt(symbols.length)] //selects a random number, the number position is symbol, is used to select a character
//            password += character //each character is stored in password
//            i++
//        }
//
//        val passwordEncoder = BCryptPasswordEncoder()
//        val hashedPassword = passwordEncoder.encode(password)
//        //println(hashedPassword)
//    }
//}