import kotlin.math.max

const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Мир"
const val TYPE_VKPAY = "VK Pay"
const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
fun main() {
    println(comission(TYPE_VISA, 10_000, 0))
    println(comission(TYPE_MIR, 10_000, 0))
    println(comission(TYPE_MASTERCARD, 10_000, 0))
    println(comission(TYPE_MAESTRO, 10_000, 0))
    println(comission(TYPE_VKPAY, 10_000, 0))
}
fun comission(typeCard: String, amount: Int, previous: Int): Int = when (typeCard) {
    "Visa" -> if (amount <= 150_000 && amount+previous <= 600_000) max(35, (amount * 0.0075f).toInt()) else ERROR_LIMIT
    "Мир" -> if (amount <= 150_000 && amount+previous <= 600_000) max(35, (amount * 0.0075f).toInt()) else ERROR_LIMIT
    "MasterCard" -> if (amount >= 300 && amount+previous <75000) 0 else if (amount <= 150_000 && amount+previous <= 600_000) {(amount * 0.006f).toInt()+20} else ERROR_LIMIT
    "Maestro" -> if (amount >= 300 && amount+previous <75000) 0 else if (amount <= 150_000 && amount+previous <= 600_000) {(amount * 0.006f).toInt()+20} else ERROR_LIMIT
    "VK Pay" -> if (amount <= 15_000 && amount+previous <= 40_000) 0 else ERROR_LIMIT
    else -> ERROR_TYPE
}
