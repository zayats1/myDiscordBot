package org.zayats1.discord.bot.main

import com.jessecorbett.diskord.bot.bot
import com.jessecorbett.diskord.bot.classicCommands
import com.jessecorbett.diskord.bot.events
import com.jessecorbett.diskord.util.sendMessage
import com.jessecorbett.diskord.util.words
import org.zayats1.discord.bot.games.RockPaperScissorsGame


private val BOT_TOKEN = try {
    ClassLoader.getSystemResource("bot_token.txt").readText().trim()
} catch (error: Exception) {
    throw RuntimeException(
        "Failed to load bot token. Make sure to create a file named bot-token.txt in" +
                " src/main/resources and paste the bot token into that file.", error
    )
}

const val WELCOME_CHANNEL_ID = "875686523813654540"
suspend fun main() {
    bot(BOT_TOKEN) {
        events {
            onGuildMemberAdd {
                channel(WELCOME_CHANNEL_ID).sendMessage("Welcome to the server, ${it.user?.username}!")
            }
        }
        classicCommands("!") {
            command("DICK") {
                it.respond("DUCK")
            }
            command("Чувачі") { message ->
                val game = RockPaperScissorsGame()
                val words = message.words
                message.reply(game.fight(words[1]))
            }
        }
    }
}