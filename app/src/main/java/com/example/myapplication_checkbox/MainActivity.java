package com.example.myapplication_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputMoney;
    private EditText inputInfo;
    private Button okBtn;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        resetCheckBoxes();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputMoneyStr = inputMoney.getText().toString();
                String inputInfoStr = inputInfo.getText().toString();
                try{
                   int money = Integer.parseInt(inputMoneyStr);
                   String result = "Сумма: "+ inputMoneyStr+ ", причина оплаты: "+inputInfoStr;
                    Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, R.string.incorrect_value, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void initViews() {
        inputMoney = findViewById(R.id.inputMoney);
        inputInfo = findViewById(R.id.inputInfo);
        okBtn = findViewById(R.id.okBtn);
        mBankCardChkBx = findViewById(R.id.mBankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mMobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.mCashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }
    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.mBankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.mMobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.mCashAddressChkBx:
                        resetCheckBoxes();
                        mCashAddressChkBx.setChecked(true);
                        inputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    default:
                }
            }
        }
    };

}
