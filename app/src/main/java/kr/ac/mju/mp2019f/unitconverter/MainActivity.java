package kr.ac.mju.mp2019f.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// 60132322 정유빈
// HW 2
// 완료일자 2019년 9월 26일

public class MainActivity extends AppCompatActivity {

    // EditText 변수 설정

    private EditText inchEdtiText;
    private EditText cmEdtiText;
    private TextView errorTextView;

    //Button 변수 설정

    private Button inchButton;
    private Button cmButton;
    private  Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //activity_main.xml 로 부터 id를 가져오기

        inchEdtiText = findViewById(R.id.inch_Edit);
        cmEdtiText = findViewById(R.id.cm_Edit);
        errorTextView = findViewById(R.id.error_Text);

        inchButton = findViewById(R.id.inch_Button);
        cmButton = findViewById(R.id.cm_Button);
        clearButton = findViewById(R.id.clear_Button);



        //INCH2CM 버튼을 눌렀을 경우 일어나는 OnClickListener 함수
        inchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //에러메세지 TextView와 CM EditText 뷰를 항상 공란으로 초기화 시켜주기 위해 설정
                errorTextView.setText(String.format(""));
                cmEdtiText.setText(String.format(""));

                //해당 EditText가 공란인지 아닌지 확인 후 공란이 아니라면 그 이후 함수 실행
                if(inchEdtiText.getText().toString().equals("")){
                    errorTextView.setText(String.format("Empty Inch setting"));
                }else{

                    // EditText에 문자가 포함되어 있지 않을 경우 음수인지 확인 후 인치 -> 센치로 변환 출력
                    try{
                        String inchStr = inchEdtiText.getText().toString().trim();
                        double inchDouble = Double.valueOf(inchStr).doubleValue();

                        if(inchDouble < 0){
                            errorTextView.setText(String.format("Inch number under 0"));
                        }else{
                            double sum = inchDouble * 2.54;
                            String s_sum = Double.toString(sum);
                            cmEdtiText.setText(String.format(s_sum));
                        }

                        // EditText에 문자가 포함되어 있으면 에러문 출력
                    }catch (NumberFormatException e){
                        errorTextView.setText("Inch : Only insert number");
                    }
                }
            }
        });


        //CM2INCH 버튼을 눌렀을 경우 일어나는 OnClickListener 함수
        cmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorTextView.setText(String.format(""));
                inchEdtiText.setText(String.format(""));

                if(cmEdtiText.getText().toString().equals("")){
                    errorTextView.setText(String.format("Empty CM setting"));
                }else{
                    try{
                        String cmStr = cmEdtiText.getText().toString().trim();
                        double cmDouble = Double.valueOf(cmStr).doubleValue();

                        if(cmDouble < 0){
                            errorTextView.setText(String.format("CM number under 0"));
                        }else{
                            double sum = cmDouble / 2.54;
                            String s_sum = Double.toString(sum);
                            inchEdtiText.setText(String.format(s_sum));
                        }

                    }catch (NumberFormatException e){
                        errorTextView.setText("CM : Only insert number");
                    }
                }
            }
        });


        //모든 텍스트창들을 초기화 시키고 싶을 때 사용하는 버튼
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inchEdtiText.setText(String.format(""));
                cmEdtiText.setText(String.format(""));
                errorTextView.setText(String.format("All text Clear!"));
            }
        });

    }
}
