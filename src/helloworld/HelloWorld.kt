package helloworld

fun main(args: Array<String>) {
    println("Hello World!\n")
    forLoop()

    var i = 42
    var str = when {
        i > 30 -> "bigger than 30"
        i == 42 -> "it's the truth"
        else -> "else"
    }
    println(str)
}

fun forLoop() {
    val names = listOf<Any>("Marc", "Simon", "Markus")
    for (name in names) {
        println(name)
    }
}