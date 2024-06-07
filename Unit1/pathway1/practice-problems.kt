/*
Tell your friends what you learned in this pathway.

    Can you write a main() function that prints these messages on four separate lines?

Use the val keyword when the value doesn't change. 
Use the var keyword when the value can change.
When you define a function, you define the parameters that can be passed to it. 
When you call a function, you pass arguments for the parameters.
*/

fun main() {
    println("EXERCISE 1")
    exercise1()
    println()

    println("EXERCISE 2")
    exercise2()
    println()
    
    println("EXERCISE 3")
    exercise3()
    println()
    
    println("EXERCISE 4")
    exercise4()
    println()
    
    println("EXERCISE 5")
    exercise5()
    println()
    
    println("EXERCISE 6")
    exercise6()
    println()
    
    println("EXERCISE 7")
    exercise7()
    println()
    
    println("EXERCISE 8")
    exercise8()
    println()
    
    println("EXERCISE 9")
    println(exercise9(300, 250))
    println(exercise9(300, 300))
    println(exercise9(200, 220))
    println()
    
    println("EXERCISE 10")
    exercise10("Ankara", 27, 31, 82)
    exercise10("Tokyo", 32, 36, 10)
    exercise10("Cape Town", 59, 64, 2)
    exercise10("Guatemala City", 50, 55, 7)
}

fun exercise1() {
    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.")
    println("When you define a function, you define the parameters that can be passed to it.")
    println("When you call a function, you pass arguments for the parameters.")
}

fun exercise2() {
    println("New chat message from a friend")
}

fun exercise3() {
    var discountPercentage: Int
    var offer: String
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    
    println(offer)    
}

fun exercise4() {
    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults.toInt() + numberOfKids.toInt()
    println("The total party size is: $total")
}

fun exercise5() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = baseSalary + bonusAmount
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}

fun exercise6() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$firstNumber - $thirdNumber = ${subtraction(firstNumber, thirdNumber)}")    
}

fun add(a: Int, b: Int): Int {
    return a+b
}

fun subtraction(a: Int, b: Int): Int {
    return a-b
}

fun exercise7() {
    val firstUserEmailId = "user_one@gmail.com"

    // The following line of code assumes that you named your parameter as emailId. 
    // If you named it differently, feel free to update the name.
    println(displayAlertMessage(emailId = firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()

}

fun displayAlertMessage(operatingSystem: String = "Unknown", emailId:String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}

fun exercise8() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories") 
}

fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
    return totalCaloriesBurned
}

fun exercise9(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}

fun exercise10(city: String, lowTemp: Int, highTemp: Int, chanceRain: Int) {
    println("City: $city")
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    println("Chance of rain: $chanceRain%")
    println()
}