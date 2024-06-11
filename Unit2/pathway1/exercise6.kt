fun main() {
    println(">>> EXERCISE 1 <<<")
    ex1()
    println("####################################################################################################")
    
    println(">>> EXERCISE 2 <<<")
    ex2()
    println("####################################################################################################")

    println(">>> EXERCISE 3 <<<")
    ex3()
    println("####################################################################################################")
    
    println(">>> EXERCISE 4 <<<")
    ex4()
    println("####################################################################################################")
    
    println(">>> EXERCISE 5 <<<")
    ex5()
    println("####################################################################################################")

    println(">>> EXERCISE 6 <<<")
    ex6()
    println("####################################################################################################")

    println(">>> EXERCISE 7 <<<")
    ex7()
    println("####################################################################################################")
}

// Mobile notifications
fun ex1() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    // Fill in the code.
    if (numberOfMessages < 100) println("You have $numberOfMessages notifications.")
    else println("Your phone is blowing up! You have 99+ notifications.")
}

// Movie-ticket price
fun ex2() {
    val child = 5
    val adult = 28
    val senior = 87
    
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Fill in the code.
    val r: Int = when (age) {
            in 1..12  -> 15
            in 13..60 -> if (isMonday) 25 else 30
            else -> 20
        }
    
    return r
}

// Temperature converter
fun ex3() {
    // Fill in the code.
    printFinalTemperature(27.0, "Celcius", "Fahrenheit", {(9*it/5) + 32})
    printFinalTemperature(350.0, "Kelvin", "Celcius", {it - 273.15})
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", {((it - 32)*5 /9) + 273.15})
}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

// Song catalog
fun ex4() {
    val funkSong: Song = Song("Faz o Fácil", "Mc J Mito", 2024, 2273739)
    funkSong.printDescription()
    println(funkSong.popular)
}

class Song(
    val title: String,
    val artist: String,
    val publishYear: Int,
    val playCount: Int
) {
    var popular: Boolean = if (playCount < 1000) false else true 
    
    fun printDescription() {
        println("$title, performed by $artist, was released in $publishYear.")
    }
}

// Internet profile
fun ex5() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       // Fill in code
       println("Name: $name")
       println("Age: $age")
       println("${if (hobby == null) "Doesn't have a hobby" else "Likes to $hobby"}. ${if (referrer == null) "Doesn't have a referrer" else "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}"}.") 
    }
}

// Foldable phones
fun ex6() {
    val phone: FoldablePhone = FoldablePhone()
    phone.unfold()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.fold()
    phone.checkPhoneScreenLight()
    phone.switchOn()
    phone.checkPhoneScreenLight()
}


open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(
    var isFolded: Boolean = true
) : Phone() {

    override fun switchOn() {
        if (!isFolded) super.switchOn()
    }

    fun fold() {
        if (!isFolded) {
            isFolded = true
            super.switchOff()
        }
    }

    fun unfold() {
        if (isFolded) isFolded = false
    }
}

// Special auction
fun ex7() {
    val winningBid = Bid(5000, "Private Collector")
    
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)
 
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Fill in the code.
    return when(bid) {
        null -> minimumPrice
        else -> bid.amount 
    }
}
