package com.nbcc.example.roshambo


import java.util.*

class Rochambo {
    val ROCK = 0
    val PAPER = 1
    val SCISSOR = 2
    val NONE = 3

    val WIN = R.string.win
    val LOSE = R.string.lose
    val DRAW = R.string.draw

    var gameMove: Int = 0
        private set
    var playerMove: Int = 0
        private set
    private val rand: Random = Random()

    init {
        gameMove = rand.nextInt(2)
        playerMove = NONE
    }

    /**
     * Player chooses their next move, the game immediately follows and
     * makes it's next move. Use winLoseOrDraw() to see the outcome
     *
     * @param playerMove  ROCK, PAPER, or SCISSOR are valid arguments
     */
    fun playerMakesMove(playerMove: Int) {

        if (Integer.compareUnsigned(playerMove, NONE) > 0)
            throw IllegalArgumentException("not a valid player move")

        this.playerMove = playerMove
        gameMakesMove()
    }

    /**
     * The game makes a random choice of ROCK, PAPER, or SCISSOR
     */
    private fun gameMakesMove() {
        gameMove = rand.nextInt(3)
    }

    fun winLoseOrDraw(): Int {

        if (playerMove == ROCK) {
            return if (gameMove == ROCK) {
                DRAW
            } else if (gameMove == PAPER) {
                LOSE
            } else {
                WIN
            }
        } else if (playerMove == PAPER) {
            return if (gameMove == PAPER) {
                DRAW
            } else if (gameMove == SCISSOR) {
                LOSE
            } else {
                WIN
            }
        } else if (playerMove == SCISSOR) {
            return if (gameMove == SCISSOR) {
                DRAW
            } else if (gameMove == ROCK) {
                LOSE
            } else {
                WIN
            }
        }

        return DRAW //shouldn't get here
    }


}
