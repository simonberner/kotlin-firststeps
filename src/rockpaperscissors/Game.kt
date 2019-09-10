package rockpaperscissors

import java.awt.Choice

val pleaseChoose = "Please choose between Rock [r], Paper [p] or Scissors [s]: "

fun main() {
    do {
        print("Hello and welcome to the Game Rock-Paper-Scissors!\n")
        print(pleaseChoose)
        val choice = readLine()
        val userChoice = mapResponse(choice)
        val computerChoice = calcComputerResponse()
        println("You have chosen: '${userChoice}'")
        println("The computer has chosen: '${computerChoice}'")
        println(calcWinner(userChoice, computerChoice))
        println("Would you like to replay the game? Please choose [y] for Yes or any other character for No: ")
        val replay = readLine()
    } while (replay == "y")
}

// referee which calculates the winner
fun calcWinner(userChoice: String, computerChoice: String): String {
    val result = when (userChoice) {
        "rock" -> when (computerChoice) {
            "rock" -> "It's a tie"
            "paper" -> "Paper beats rock, the computer wins."
            "scissors" -> "Rock beats scissors, the player wins."
            else -> "It's unclear if '$userChoice' beats '$computerChoice', or not."
        }
        "paper" -> when (computerChoice) {
            "rock" -> "Paper beats rock, the player wins."
            "paper" -> "It's a tie"
            "scissors" -> "Scissors beat paper, the computer wins."
            else -> "It's unclear if '$userChoice' beats '$computerChoice', or not."
        }
        "scissors" -> when (computerChoice) {
            "rock" -> "Rock beats scissors, the computer wins."
            "paper" -> "Scissors beat paper, the player wins."
            "scissors" -> "It's a tie"
            else -> "It's unclear if '$userChoice' beats '$computerChoice', or not."
        }
        else -> "It's unclear if '$userChoice' beats '$computerChoice', or not."
    }
    return result
}

// computer draws
fun calcComputerResponse(): String {
    val possibleChoices = arrayOf("Rock", "Paper", "Scissors")
    return possibleChoices.random()
}

// map user shortcut choice to the nouns of the game
fun mapResponse(choice: String?): String {
    val response = when (choice) {
        "r" -> "Rock"
        "p" -> "Paper"
        "s" -> "Scissors"
        else -> "Invalid input! " + pleaseChoose
    }
    return response
}

