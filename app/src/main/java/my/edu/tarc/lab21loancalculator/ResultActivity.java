package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView viewTextMonthlyPayment, viewTextStatus;
    private ImageView imageViewThumbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        viewTextMonthlyPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);
        viewTextStatus = (TextView)findViewById(R.id.textViewStatus);
        imageViewThumbs=(ImageView)findViewById(R.id.imageViewThumbs);

        //To get the intent that pass data
        Intent intent =getIntent(); //Asking = "Who is calling me?"
        double payment = intent.getDoubleExtra(LoanCalculator.LOAN_PAYMENT,0);
        String status = intent.getStringExtra(LoanCalculator.LOAN_STATUS);


        viewTextMonthlyPayment.setText(String.format("%.2f", payment));
        //// TODO: Display Outputs
        if(status.equals("Approved")) {

            imageViewThumbs.setImageResource(R.drawable.thumbup);
        }

        else
        {
            imageViewThumbs.setImageResource(R.drawable.thumbdown);
        }



    }
    public void closeActivity(View view) {
        //terminate an activity
        finish();
    }

}
