package com.example.timecalculator

class TimeCalculatorProcess {

    fun addTimes(time1: String, time2: String): String {
        val seconds1 = convertToSeconds(time1)
        val seconds2 = convertToSeconds(time2)
        return convertToTimeFormat(seconds1 + seconds2)
    }

    fun subtractTimes(time1: String, time2: String): String {
        val seconds1 = convertToSeconds(time1)
        val seconds2 = convertToSeconds(time2)
        return convertToTimeFormat(seconds1 - seconds2)
    }

    private fun convertToSeconds(time: String): Int {
        var totalSeconds = 0
        var hours = 0
        var minutes = 0

        val regex = "(\\d+)([hms])".toRegex()
        val matches = regex.findAll(time)

        for (match in matches) {
            val value = match.groupValues[1].toInt()
            when (match.groupValues[2]) {
                "h" -> hours = value
                "m" -> minutes = value
                "s" -> totalSeconds += value
            }
        }

        totalSeconds += hours * 3600 + minutes * 60
        return totalSeconds
    }

    private fun convertToTimeFormat(totalSeconds: Int): String {
        if (totalSeconds < 0) {
            return "Нельзя отнять большее из меньшего"
        }
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return buildString {
            if (hours > 0) append("${hours}h")
            if (minutes > 0) append("${minutes}m")
            if (seconds > 0) append("${seconds}s")
            if (isEmpty()) append("0s")
        }.toString()
    }
}