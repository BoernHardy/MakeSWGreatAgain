package at.sw2017.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class calculator extends AppCompatActivity implements View.OnClickListener{

    public enum State {
        ADD , SUB , MUL , DIV , INIT , NUM
    }

    State state = State.INIT;

    ArrayList<Button> numberButtons;
    TextView numberView;
    int firstNumber = 0;

    public void setUpNumberButtonListener() {
        for (int i = 1; i <= 9; i++)
        {
            String buttonName = "Button_ID_" + i;

            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this);
           numberButtons.add(button);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numberButtons = new ArrayList<Button>();
        setUpNumberButtonListener();

        // für jeden button machen

        Button button0 = ( Button ) findViewById ( R.id.Button_ID_0);
        button0.setOnClickListener ( this );

        Button button = ( Button ) findViewById ( R.id.Button_ID_Div);
        button.setOnClickListener ( this );

        Button button1 = ( Button ) findViewById ( R.id.Button_ID_Gleich);
        button1.setOnClickListener ( this );

        Button button2 = ( Button ) findViewById ( R.id.Button_ID_Minus);
        button2.setOnClickListener ( this );

        Button button3 = ( Button ) findViewById ( R.id.Button_ID_Plus);
        button3.setOnClickListener ( this );

        Button button4 = ( Button ) findViewById ( R.id.Button_ID_Mal);
        button4.setOnClickListener ( this );

        Button button5 = ( Button ) findViewById ( R.id.Button_ID_C);
        button5.setOnClickListener ( this );

        numberView = (TextView)findViewById(R.id.numberView);
    }

    @Override
    public void onClick ( View v ) {
        Button clickedButton = ( Button ) v;
        switch ( clickedButton . getId ()) {
            case R . id .Button_ID_Plus:
                clearNumberView ();
                state = State . ADD;
                break;
            case R . id . Button_ID_Minus:
                clearNumberView ();
                state = State . SUB;

                break;
            case R . id . Button_ID_Mal:
                clearNumberView ();
                state = State . MUL;
                break;
            case R . id . Button_ID_Div:
                clearNumberView ();
                state = State . DIV;
                break;
            case R . id . Button_ID_Gleich:
                calculateResult ();
                state = State . INIT;
                break;
            case R . id . Button_ID_C:
                clearTextView();
                state = State . INIT;
                break;
            default:
                String recentNumber = numberView . getText (). toString ();
                if ( state == State . INIT ) {
                    recentNumber = "";
                    state = State . NUM;
                }
                recentNumber += clickedButton . getText (). toString ();
                numberView . setText ( recentNumber );
        }
    }


    private void clearTextView () {
        numberView . setText ("0");
        firstNumber = 0;
        state = State . INIT;
    }
    private void clearNumberView () {
        String tempString = numberView . getText (). toString ();
        if (! tempString . equals ( "" )){
            firstNumber = Integer . valueOf ( tempString );
        }
        numberView . setText ( "" );
    }


    private void calculateResult () {
        int secondNumber = 0;
        String tempString = numberView . getText (). toString ();
        if (! tempString . equals ( "" )){
            secondNumber = Integer . valueOf ( tempString );
        }
        int result;
        switch ( state ){
            case ADD:
                result = Calculations . doAddition ( firstNumber , secondNumber );
                break;
            case SUB:
                result = Calculations . doSubtraction ( firstNumber , secondNumber );
                break;
            case MUL:
                result = Calculations . doMultiplication ( firstNumber , secondNumber );
                break;
            case DIV:
                result = Calculations . doDivision ( firstNumber , secondNumber );
                break;
            default:
                result = secondNumber;
        }
        numberView . setText ( Integer . toString ( result ));
    }













}
