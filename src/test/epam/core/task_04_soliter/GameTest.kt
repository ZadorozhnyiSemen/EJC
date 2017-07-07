package epam.core.task_04_soliter

import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        var numGames = 0
        val maxGames = 10000

        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        GameModel.debugPring()
        println("#Games" + numGames)
        assert(numGames < maxGames)
    }
}