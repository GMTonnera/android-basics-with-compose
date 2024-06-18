data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)

val Event.durationOfEvent: String
    get() = if (duration < 60) "short" else "long"