package epam.core.task_04_soliter

import org.junit.Assert.*
import org.junit.Test

class TableauPileTest {
    @Test
    fun addCards() {
        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))
        val cards = mutableListOf(Card(11, hearts))

        tableauPile.addCards(cards)

        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun removeCards() {
        val tableauPile = TableauPile(mutableListOf(
                Card(4, clubs),
                Card(3, diamonds),
                Card(2, spades)))

        tableauPile.removeCards(1)

        assertEquals(mutableListOf(Card(4, clubs, true)), tableauPile.cards)
    }
}