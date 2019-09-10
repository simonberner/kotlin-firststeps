package rockpaperscissors

const val pleaseChoose = "Please choose between Rock [r], Paper [p] or Scissors [s]: "

fun main() {
    do {
        print("Hello and welcome to the Game Rock-Paper-Scissors!\n")
        val userChoice = playerDraw()
        val computerChoice = computerDraw()
        println(calculateWinner(userChoice, computerChoice))
        println("Would you like to replay the game? Please press [y] for Yes or any other key for No: ")
        val replay = readLine()
    } while (replay == "y")
}


fun playerDraw(): String {
    print(pleaseChoose)
    val userCommand = readLine()
    val userChoice = mapUserCommand(userCommand)
    println("You have chosen: '${userChoice}'")

    return userChoice
}

fun computerDraw(): String {
    val possibleChoices = arrayOf("Rock", "Paper", "Scissors")
    val computerChoice = possibleChoices.random()
    println("The computer has chosen: '${computerChoice}'")

    return computerChoice
}

fun calculateWinner(userChoice: String, computerChoice: String): String {
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

// map user command  to the actual game nouns
fun mapUserCommand(choice: String?): String {
    val response = when (choice) {
        "r" -> "Rock"
        "p" -> "Paper"
        "s" -> "Scissors"
        else -> "Invalid input! " + pleaseChoose
    }

    return response
}

