fun main() {
//    TASK 1
//    val event: Event = Event(
//        title = "Study Kotlin",
//        description = "Commit to studying Kotlin at least 15 minutes per day.",
//        daypart = "Evening",
//        duration = 15
//    )
//    println(event)

    // TASK 2
//    val event: Event = Event(
//        title = "Study Kotlin",
//        description = "Commit to studying Kotlin at least 15 minutes per day.",
//        daypart = Daypart.EVENING,
//        duration = 15
//    )
//    println(event)

    // TASK 3
    val events: MutableList<Event> = mutableListOf(
        Event(
            title = "Wake up",
            description = "Time to get up",
            daypart = Daypart.MORNING,
            duration = 0
        ),
        Event(
            title = "Eat breakfast",
            daypart = Daypart.MORNING,
            duration = 15
        ),
        Event(
            title = "Learn about Kotlin",
            daypart = Daypart.AFTERNOON,
            duration = 30
        ),
        Event(
            title = "Practice Compose",
            daypart = Daypart.AFTERNOON,
            duration= 60
        ),
        Event(
            title = "Watch latest DevBytes video",
            daypart = Daypart.AFTERNOON,
            duration = 10
        ),
        Event(
            title = "Check out latest Android Jetpack library",
            daypart = Daypart.EVENING,
            duration = 45
        )
    )

    // TASK 4
    val shortEvents: List<Event> = events.filter {
        it.duration < 60
    }
    println("You have ${shortEvents.size} short events.")

    // TASK 5
    val eventsByDaypart = events.groupBy { it.daypart }
    eventsByDaypart.forEach {
        println("${it.key}: ${it.value.size} events")
    }

    // TASK 6
    println("Last event of the day: ${events.last().title}")

    // TASK 7
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}