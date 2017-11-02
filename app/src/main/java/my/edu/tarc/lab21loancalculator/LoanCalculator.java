package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoanCalculator extends AppCompatActivity {
    public static final String LOAN_PAYMENT = "payment";//is a constant
    public static final String LOAN_STATUS = "status";

    private EditText editTextViheclePrice, editTextDownpayment, editTextRepayment, editTextInterestRate, editTextSalary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);

        editTextViheclePrice = (EditText)findViewById(R.id.editTextVehiclePrice);
        editTextDownpayment = (EditText)findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);

    }
    public void calculateLoan(View view){
        //// TODO: Calculate payment amount and determine the status of loan application

        double salary, VP, DP, IR, totalInterest, totalLoan, MonthlyPayment;
        int repayment;
        String status;

        salary = Double.parseDouble(editTextSalary.getText().toString());
        VP = Double.parseDouble(editTextViheclePrice.getText().toString());
        DP = Double.parseDouble(editTextDownpayment.getText().toString());
        IR = Double.parseDouble(editTextInterestRate.getText().toString());
        repayment = Integer.parseInt(editTextRepayment.getText().toString());

        totalInterest = (VP - DP) * IR * (repayment/12);
        totalLoan = (VP - DP) + (totalInterest/100);
        MonthlyPayment = totalLoan/repayment;

        if(MonthlyPayment > (salary*0.3))
            status="Disapproved";
        else
            status="Approved";

        //define intent object
        //This is an explicit intent, I know exactly what i wan to call
        Intent intent =new Intent(this,ResultActivity.class);//this=in this application, ResultActivity, its a class
        //pass data from this activity to another activity, putExtra
        //format: putExtra(TAG, value)
        intent.putExtra(LOAN_PAYMENT, MonthlyPayment);
        intent.putExtra(LOAN_STATUS, status);


        startActivity(intent);
    }
}
