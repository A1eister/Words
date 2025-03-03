package org.example

fun main() {

    println("Добро пожаловать в игру!")
    val words = mutableListOf("колесо")
    val word = words.random()
    val wordCharArray = CharArray(word.length) { '*' }
    println("Слово: ${"*".repeat(word.length)} ")
    println("Введите букву")

    val correctLetters = mutableListOf<Char>()
    val incorrectLetters = mutableListOf<Char>()

    while (incorrectLetters.size<4 && wordCharArray.contains('*')) {
        val enteredSymbol = readln()
        val charSymbol = enteredSymbol.toCharArray()
        val enteredLetter = charSymbol[0]


        if (isSymbolValid(enteredSymbol, correctLetters, incorrectLetters)) {

            var correctGuess = false
            for (i in word.indices) {
                if (word[i] == enteredLetter) {
                    wordCharArray[i] = enteredLetter
                    correctGuess = true
                }}

        if (correctGuess) {
            correctLetters.add(enteredLetter)
            println("Откройте букву $enteredLetter")
            println("Слово: ${wordCharArray.joinToString("")} ")
            if (wordCharArray.contains('*')) {
                println("следующая попытка!")
            } else {
                println("Поздравляем! Вы победили! Вы угадали слово \"$word\"")
            }
        } else {
            incorrectLetters.add(enteredLetter)
            println("Нет такой буквы!")
            println("Количество жизней: ${4-incorrectLetters.size}")
            if (incorrectLetters.size==4) println("Игра окончена! Вы продули :(")
        }

    }}

}

fun isSymbolValid(input: String, correctLetters: List<Char>, incorrectLetters: List<Char>): Boolean {
    if (input.length != 1) {
        println("Пожалуйста, введите одну букву.")
        return false
    }
    if (input[0] !in 'а'..'я') {
        println("Пожалуйста, введите русские буквы")
        return false
    }
    if (correctLetters.contains(input[0])) {
        println("Буква уже угадана!")
        return false
    }
    if (incorrectLetters.contains(input[0])){
        println("Буква уже была введена")
    return false
}
    return true

}

//fun guessLetter(word: String, wordToChar: CharArray, enteredLetter: Char):
//        Boolean {
//    var correctGuess = false
//    for (i in word.indices) {
//        if (word[i] == enteredLetter) {
//            wordToChar[i] = enteredLetter
//            correctGuess = true
//
//        }
//    }
//    return correctGuess
//}

//fun areAllLettersGuessed(): Boolean {
//    return guessedLetters.all { it }


//        if (wordToChar.contains(enteredLetter)) {
//            println("Откройте букву $enteredLetter")
//correctLetters.add(enteredLetter)










