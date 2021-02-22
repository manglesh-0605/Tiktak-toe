package android.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // 0 is "o" and 1 is "x"---------------------------------------------------------------------------
    int activePlayer = 0;

    boolean gameActive = true;

    // 2 means the counter is empty--------------------------------------------------------------------
    int[] gameState = {2 , 2 , 2 , 2 , 2 , 2 , 2  , 2 , 2};

    //these are the winning positions -----------------------------------------------------------------
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //this method runs Each time you tap the view-----------------------------------------------------
    public void dropIn(View v){
        ImageView counter=(ImageView) v;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.o);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }


            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    gameActive = false ;
                    String winner = "";

                    if (activePlayer == 1) {
                        winner = "O";

                    } else {
                        winner = "X";
                    }
//                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();


                    //play again button------------------------------------------------------------------
                    Button btn = (Button) findViewById(R.id.playAgainButton);

                    //text view which shows winner --------------------------------------------------------
                    TextView txt=(TextView) findViewById(R.id.winnerText);

                    //setting the text in the test Field---------------------------------------------------
                    txt.setText(winner+"  has won!!");

                    btn.setVisibility(View.VISIBLE);
                    txt.setVisibility(View.VISIBLE);






                }
            }
        }


    }

    public void playAgain(View v){
        //play again button------------------------------------------------------------------
        Button btn = (Button) findViewById(R.id.playAgainButton);

        //text view which shows winner --------------------------------------------------------
        TextView txt=(TextView) findViewById(R.id.winnerText);

        btn.setVisibility(View.INVISIBLE);
        txt.setVisibility(View.INVISIBLE);
//
//        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
////
//        for (int i=0 ; i < grid.getChildCount() ; i++){
//            ImageView counter = (ImageView) grid.getChildAt(i);
//
//            counter.setImageDrawable(null);
//        }
////
////        // 0 is "o" and 1 is "x"---------------------------------------------------------------------------
//        activePlayer = 0;
//////
//        gameActive = true;
////
////        // 2 means the counter is empty--------------------------------------------------------------------
////
//        for(int i :gameState){
//            gameState[i]=2;
//
//        }






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}