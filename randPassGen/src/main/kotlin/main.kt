import java.util.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


fun createPassword(): String? {
    // write code that returns a randomized password

    var random = Random()
    var i = 0
    val symbols = "abcdefghijklmnopqrstuvwxyz" //acts as symbol for potential password
    var password: String? = "" //password will be returned at the end of method
    var length = 6
    while (i < length) {
        val character =
            symbols[random.nextInt(symbols.length)] //selects a random number, the number position is symbol, is used to select a character
        password += character //each character is stored in password
        i++
    }
    return password
}