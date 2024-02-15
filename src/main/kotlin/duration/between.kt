package duration

import java.time.Duration
import java.time.LocalDateTime

private fun main(){
    // step01()

    // Sample LocalDateTime objects
    val startDateTime = LocalDateTime.of(2022, 1, 1, 12, 0, 0)
    val endDateTime = LocalDateTime.of(2022, 1, 1, 13, 30, 0)

    // Calculate the Duration between the two LocalDateTime objects
    val duration: Duration = Duration.between(startDateTime, endDateTime)

    // Print the Duration
    println("Duration between $startDateTime and $endDateTime is: $duration")
    // Duration between 2022-01-01T12:00 and 2022-01-01T13:30 is: PT1H30M
    // PT : Period of TIme
    // 1H : 1 hour
    // 30M : 30 min

}