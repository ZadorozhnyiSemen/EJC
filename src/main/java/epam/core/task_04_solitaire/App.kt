package epam.core.task_04_solitaire

fun main(args: Array<String>) {
    GameModel.resetGame()
    var flag = true
    println("Hello player")
    while (flag) {
        println("pick action (play fair there is no validation)")
        println("You can open new card by pressing '0'")
        println("You can tap on waste pile by pressing '9'")
        println("You can tap on piles by pressing from '1' to '7'")
        println("you can tap on foundation pile by pressing 'q' 'w' 'e' 'r'")
        println("QUIT = QUIT")
        println("Type 'restart' to restart")
        GameModel.debugPring()
        val userAction = readLine()
        when (userAction) {
            "QUIT" -> flag = false
            "restart" -> GamePresenter.onRestartTap()
            "0" -> GamePresenter.onDeckTap()
            "9" -> GamePresenter.onWasteTap()
            "q" -> GamePresenter.onFoundationTap(0)
            "w" -> GamePresenter.onFoundationTap(1)
            "e" -> GamePresenter.onFoundationTap(2)
            "r" -> GamePresenter.onFoundationTap(3)
            "1" -> pressed(userAction.toInt())
            "2" -> pressed(userAction.toInt())
            "3" -> pressed(userAction.toInt())
            "4" -> pressed(userAction.toInt())
            "5" -> pressed(userAction.toInt())
            "6" -> pressed(userAction.toInt())
            "7" -> pressed(userAction.toInt())

        }
        GamePresenter.onDeckTap()
        GamePresenter.onWasteTap()
        GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
            GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
        }
    }

}

fun  pressed(tableauIndex: Int) {
    println("Enter index of card top to bottom from 1 to 13")
    val index = readLine()
    GamePresenter.onTableauTap(tableauIndex - 1, index!!.toInt() - 1);
}


