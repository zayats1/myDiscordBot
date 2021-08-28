package org.zayats1.discord.bot.games

import kotlin.random.Random

const val ROCK = "Камінь"
const val PAPER = "Папір"
const val SCISSORS = "Ножиці"
const val PRIZE = 300

class RockPaperScissorsGame {

    fun fight(item: String): String {
        val nl = System.lineSeparator()
        val enemy = getEnemy()
        var battleResult: String = "0"
        when (item) {
            ROCK -> {
                when (enemy) {
                    ROCK -> battleResult = "Тепер у тебе є два каменя"
                    PAPER -> battleResult = "Папірець упав на камінь, після того, як його використали, $nl" +
                            "Але то були твої останні $PRIZE баксів"
                    SCISSORS -> battleResult = "Ножиці були зроблені в Німеччині тому не зламалися об нього. $nl" +
                            "Відтоді на твому камені є некрасиві царапини"
                }
            }
            PAPER -> {
                when (enemy) {
                    ROCK -> battleResult =
                        "Ти обмотуєш папером камінь, який у тебе кинули з кольорового фургончика, $nl" +
                                "камінь розсипався на якийсь порошок, фургон зник за горизонтом"
                    PAPER -> battleResult = "Папір ліг на папір, і ти помічаєш що це дві купюри по $PRIZE баксів"
                    SCISSORS -> battleResult = "Ножиці перерізали папір, а то були твої $PRIZE баксів"
                }
            }
            SCISSORS -> {
                when (enemy) {
                    ROCK -> battleResult = "Камінь затупив леза й ножиці викинули у смітник"
                    PAPER -> battleResult = "Ножиці перерізали папір, а то були $PRIZE баксів"
                    SCISSORS -> battleResult =
                        "Битва йшла метал об метал, але твої ножиці були зроблені в Піднебесній, тому й зламалися"
                }
            }
            else -> battleResult = "я тебе не розумію"
        }
        return battleResult
    }

    private fun getEnemy(): String {
        return when (Random.nextInt(0, 2)) {
            0 -> ROCK
            1 -> PAPER
            2 -> SCISSORS
            else -> "Sus"
        }
    }
}
