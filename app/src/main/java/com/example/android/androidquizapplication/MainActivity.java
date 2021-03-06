package com.example.android.androidquizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // user degree
    int totalDegree = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * calculate degree of textView Questions
     * @param questionNumber int question number
     * @param questionAnswer String question answer
     */
    private void addDegreeForCorrectTextViewAnswer(int questionNumber, String questionAnswer)
    {
        if (questionNumber == 1) {
            if (Integer.parseInt(questionAnswer) == 25)  {
                totalDegree += 10;
            }
        } else if (questionNumber == 2) {
            if (questionAnswer.toLowerCase().equals("dog")) {
                totalDegree += 10;
            }
        }
    }

    /**
     * calculate degree of radio group view Questions
     * @param questionNumber int question number
     * @param radioButtonId String selected radio button id
     */
    private void addDegreesForCorrectRadioButtonAnswer(int questionNumber, int radioButtonId)
    {
        // get the select radio button
        RadioButton radioButton = (RadioButton) findViewById(radioButtonId);
        if (questionNumber == 3) {
            if (radioButton.getText().equals("24")) {
                totalDegree += 10;
            }
        } else if (questionNumber == 4) {
            if (radioButton.getText().equals("21")) {
                totalDegree += 10;
            }
        } else if (questionNumber == 5) {
            if (radioButton.getText().equals("Boa")) {
                totalDegree += 10;
            }
        } else if (questionNumber == 6) {
            if (radioButton.getText().equals("5")) {
                totalDegree += 10;
            }
        }
    }

    /**
     *
     * @param QuestionNumber int question number
     * @param isFirstCheckBoxChecked Boolean check status for first check box
     * @param isSecondCheckBoxChecked Boolean check status for second check box
     * @param isThirdCheckBoxChecked Boolean check status for third check box
     * @param isFourthCheckBoxChecked Boolean check status for fourth check box
     */
    private void addDegreesForCorrectCheckBoxesAnswer(
            int QuestionNumber,
            Boolean isFirstCheckBoxChecked,
            Boolean isSecondCheckBoxChecked,
            Boolean isThirdCheckBoxChecked,
            Boolean isFourthCheckBoxChecked
    ) {
        if (QuestionNumber == 7) {
            if (isSecondCheckBoxChecked) {
                Log.i("Main Activity", "question 7 answer 1");
                totalDegree += 10;
            }
            if (isThirdCheckBoxChecked) {
                Log.i("Main Activity", "question 7 answer 2");
                totalDegree += 10;
            }
        } else if (QuestionNumber == 8) {
            if (isFirstCheckBoxChecked) {
                Log.i("Main Activity", "question 8 answer 1");
                totalDegree += 10;
            }
            if (isSecondCheckBoxChecked) {
                Log.i("Main Activity", "question 8 answer 2");
                totalDegree += 10;
            }
        }
    }

    /**
     * display message for user in case if pass or fail
     */
    private void displaySuccessRatio()
    {
        if (totalDegree > 50) {
            Toast.makeText(this,
                    getString(R.string.passQuiz, totalDegree),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,getString(R.string.failedInQuiz),Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * check user answer and show result
     * @param view view
     */
    public void submitUserAnswers(View view)
    {
        totalDegree = 0;
        // get first editView which contain first question answer
        TextView firstEditView     = (TextView) findViewById(R.id.first_question_answer);
        String firstQuestionAnswer =  firstEditView.getText().toString();
        // get second editView which contain second question answer
        TextView secondEditView     = (TextView) findViewById(R.id.second_question_answer);
        String secondQuestionAnswer =  secondEditView.getText().toString();
        // get selected radio button which contain third question answer
        RadioGroup firstRadioGroup = (RadioGroup) findViewById(R.id.first_radio_group);
        int thirdQuestionAnswer    = firstRadioGroup.getCheckedRadioButtonId();
        // get selected radio button which contain fourth question answer
        RadioGroup secondRadioGroup = (RadioGroup) findViewById(R.id.second_radio_group);
        int fourthQuestionAnswer    = secondRadioGroup.getCheckedRadioButtonId();
        // get selected radio button which contain fifth question answer
        RadioGroup thirdRadioGroup = (RadioGroup) findViewById(R.id.third_radio_group);
        int fifthQuestionAnswer    = thirdRadioGroup.getCheckedRadioButtonId();
        // get selected radio button which contain six question answer
        RadioGroup fourthRadioGroup = (RadioGroup) findViewById(R.id.fourth_radio_group);
        int sixQuestionAnswer       = fourthRadioGroup.getCheckedRadioButtonId();
        // check which of question number seven answer where selected
        CheckBox checkBoxGroup1Answer1         = (CheckBox) findViewById(R.id.answer1_checkbox_group1);
        Boolean isCheckBoxGroup1Answer1Checked = checkBoxGroup1Answer1.isChecked();
        CheckBox checkBoxGroup1Answer2         = (CheckBox) findViewById(R.id.answer2_checkbox_group1);
        Boolean isCheckBoxGroup1Answer2Checked = checkBoxGroup1Answer2.isChecked();
        CheckBox checkBoxGroup1Answer3         = (CheckBox) findViewById(R.id.answer3_checkbox_group1);
        Boolean isCheckBoxGroup1Answer3Checked = checkBoxGroup1Answer3.isChecked();
        CheckBox checkBoxGroup1Answer4         = (CheckBox) findViewById(R.id.answer4_checkbox_group1);
        Boolean isCheckBoxGroup1Answer4Checked = checkBoxGroup1Answer4.isChecked();
        // check which of question number eight answer where selected
        CheckBox checkBoxGroup2Answer1         = (CheckBox) findViewById(R.id.answer1_checkbox_group2);
        Boolean isCheckBoxGroup2Answer1Checked = checkBoxGroup2Answer1.isChecked();
        CheckBox checkBoxGroup2Answer2         = (CheckBox) findViewById(R.id.answer2_checkbox_group2);
        Boolean isCheckBoxGroup2Answer2Checked = checkBoxGroup2Answer2.isChecked();
        CheckBox checkBoxGroup2Answer3         = (CheckBox) findViewById(R.id.answer3_checkbox_group2);
        Boolean isCheckBoxGroup2Answer3Checked = checkBoxGroup2Answer3.isChecked();
        CheckBox checkBoxGroup2Answer4         = (CheckBox) findViewById(R.id.answer4_checkbox_group2);
        Boolean isCheckBoxGroup2Answer4Checked = checkBoxGroup2Answer4.isChecked();
        // check if no answers send
        if (
                firstQuestionAnswer.matches("") ||
                        secondQuestionAnswer.matches("") ||
                        firstRadioGroup.getCheckedRadioButtonId() == -1 ||
                        secondRadioGroup.getCheckedRadioButtonId() == -1 ||
                        thirdRadioGroup.getCheckedRadioButtonId() == -1 ||
                        fourthRadioGroup.getCheckedRadioButtonId() == -1 ||
                        (!isCheckBoxGroup1Answer1Checked &&
                                !isCheckBoxGroup1Answer2Checked &&
                                !isCheckBoxGroup1Answer3Checked &&
                                !isCheckBoxGroup1Answer4Checked ) ||
                        (!isCheckBoxGroup2Answer1Checked &&
                                !isCheckBoxGroup2Answer2Checked &&
                                !isCheckBoxGroup2Answer3Checked &&
                                !isCheckBoxGroup2Answer4Checked )
                ) {
            Toast.makeText(this,getString(R.string.notCompletedAnswers),Toast.LENGTH_SHORT).show();
        } else {
            // check if answers in edit views is correct and update user degree
            addDegreeForCorrectTextViewAnswer(1, firstQuestionAnswer);
            addDegreeForCorrectTextViewAnswer(2, secondQuestionAnswer);
            // check if answers in radio group views is correct and update user degree
            addDegreesForCorrectRadioButtonAnswer(3, thirdQuestionAnswer);
            addDegreesForCorrectRadioButtonAnswer(4, fourthQuestionAnswer);
            addDegreesForCorrectRadioButtonAnswer(5, fifthQuestionAnswer);
            addDegreesForCorrectRadioButtonAnswer(6, sixQuestionAnswer);
            // check if answers in edit views is correct and update user degree
            addDegreesForCorrectCheckBoxesAnswer(7,
                    isCheckBoxGroup1Answer1Checked,
                    isCheckBoxGroup1Answer2Checked,
                    isCheckBoxGroup1Answer3Checked,
                    isCheckBoxGroup1Answer4Checked);
            addDegreesForCorrectCheckBoxesAnswer(8,
                    isCheckBoxGroup2Answer1Checked,
                    isCheckBoxGroup2Answer2Checked,
                    isCheckBoxGroup2Answer3Checked,
                    isCheckBoxGroup2Answer4Checked);
            displaySuccessRatio();
        }
    }

    /**
     * empty all views
     * @param view view
     */
    public void reset(View view)
    {
        // empty edit text views
        TextView firstEditView  = (TextView) findViewById(R.id.first_question_answer);
        firstEditView.setText("");
        TextView secondEditView = (TextView) findViewById(R.id.second_question_answer);
        secondEditView.setText("");
        // set all radio buttons to false
        RadioGroup firstGroup = (RadioGroup) findViewById(R.id.first_radio_group);
        firstGroup.clearCheck();
        RadioGroup secondGroup = (RadioGroup) findViewById(R.id.second_radio_group);
        secondGroup.clearCheck();
        RadioGroup thirdGroup = (RadioGroup) findViewById(R.id.third_radio_group);
        thirdGroup.clearCheck();
        RadioGroup fourthGroup = (RadioGroup) findViewById(R.id.fourth_radio_group);
        fourthGroup.clearCheck();
        // set all checkbox buttons to false
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.answer1_checkbox_group1);
        checkBox1.setChecked(false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.answer2_checkbox_group1);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.answer3_checkbox_group1);
        checkBox3.setChecked(false);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.answer4_checkbox_group1);
        checkBox4.setChecked(false);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.answer1_checkbox_group2);
        checkBox5.setChecked(false);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.answer2_checkbox_group2);
        checkBox6.setChecked(false);
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.answer3_checkbox_group2);
        checkBox7.setChecked(false);
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.answer4_checkbox_group2);
        checkBox8.setChecked(false);
    }
}

