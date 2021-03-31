package com.example.kira;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    ExprGenerator generator;
    TextView textViewExpression;
    TextView textViewScore;
    EditText fieldAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();
    }
    private void init(){
        textViewExpression=findViewById(R.id.text_expression);
        fieldAnswer=findViewById(R.id.field_answer);
        textViewScore=findViewById(R.id.text_score);
        generator=new ExprGenerator();
        textViewExpression.setText(generator.getExpr());
        textViewScore.setText("0");
    }

    public void onSubmitClicked(View view){
        boolean result=generator.check(Integer.parseInt(fieldAnswer.getText().toString()));
        if(result){
            textViewExpression.setText(generator.getExpr());
            textViewScore.setText(Integer.toString(generator.score));
            fieldAnswer.setText("");
        }
        else{
            Intent intent = new Intent(this, MenuActivity.class);
            SQLiteHelper helper = new SQLiteHelper(this, "records.db", null, 1);
            helper.insert(generator.score);
            startActivityForResult(intent,0);
        }
    }
}
