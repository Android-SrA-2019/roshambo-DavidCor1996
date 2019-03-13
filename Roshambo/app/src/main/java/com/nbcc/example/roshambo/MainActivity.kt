//David Cormier
//2019-03-13
package com.nbcc.example.roshambo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.view.animation.AnticipateOvershootInterpolator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator




class MainActivity : AppCompatActivity() {

    val rochambo = Rochambo()
    var winner = 0
    var gameMove :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgChoice.setImageResource(R.mipmap.none_image_fore)
        imgGame.setImageResource(R.mipmap.none_image_fore)
    }


    fun buttonClicked(view: View) {
        // Do something in response to button
        when(view.id){
            R.id.imgPaper -> {
                imgChoice.setImageResource(0)
                imgChoice.setImageResource(R.mipmap.paper_foreground)
                rochambo.playerMakesMove(1)
                gameMove = rochambo.gameMove
                winner = rochambo.winLoseOrDraw()

            }

            R.id.imgRock -> {
                imgChoice.setImageResource(0)
                imgChoice.setImageResource(R.mipmap.rock_foreground)
                rochambo.playerMakesMove(0)
                gameMove = rochambo.gameMove
                winner = rochambo.winLoseOrDraw()
            }

            R.id.imgScissors -> {
                imgChoice.setImageResource(0)
                imgChoice.setImageResource(R.mipmap.scissors_foreground)
                rochambo.playerMakesMove(2)
                gameMove = rochambo.gameMove
                winner = rochambo.winLoseOrDraw()

            }

        }
        gameMoveImage(gameMove)
        animatePic()
        CheckWin(winner)
    }

    /**
     * Displays game moves image
     */
    private  fun gameMoveImage(num : Int){
        when (num){
            0 -> imgGame.setImageResource(R.mipmap.rock_button_foreground)
            1 -> imgGame.setImageResource(R.mipmap.paper_button_foreground)
            2 -> imgGame.setImageResource(R.mipmap.scissors_button_foreground)
        }
    }

    /**
     * Checks for Win/Lose/Draw
     */
    private  fun CheckWin(num : Int){
        when (num){
            R.string.win -> txtMsg.text = "You Win!"
            R.string.lose -> txtMsg.text = "You Lose"
            R.string.draw -> txtMsg.text = "Draw"
        }
    }

    /**
     * Animates choices
     */
    private fun animatePic(){
        // you can animate any prop that there is a setter for
        // player.setRotationX(0f);

        val animatorPlayer = ObjectAnimator.ofFloat(
            imgChoice,
            "rotationX", 0f, 360f
        )
            .setDuration(500)

        val animatorGame = ObjectAnimator.ofFloat(
            imgGame,
            "rotationY", 0f, 360f
        )
            .setDuration(500)

        val set = AnimatorSet()
        set.playTogether(animatorGame, animatorPlayer)
        set.interpolator = AnticipateOvershootInterpolator()
        set.start()
    }

}
