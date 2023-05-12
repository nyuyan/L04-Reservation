package sg.edu.rp.c346.id22015056.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etPhone;
    EditText etSize;
    CheckBox smoke;
    CheckBox nonSmoke;
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    Button btnConfirm;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.Name);
        etPhone = findViewById(R.id.Phone);
        etSize = findViewById(R.id.Number);
        tvDisplay = findViewById(R.id.textViewDisplay);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnReset = findViewById(R.id.buttonReset);
        btnConfirm = findViewById(R.id.buttonConfirm);
        smoke = findViewById(R.id.Smoke);
        nonSmoke = findViewById(R.id.NonSmoke);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "Time is " + tp.getCurrentHour().toString() + ":" + tp.getCurrentMinute();
                tvDisplay.setText(time);

            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = "The date is " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                tvDisplay.setText(date);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 6, 1);
                tvDisplay.setText("");
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editText = findViewById(R.id.Name);
                        EditText editTextPhone = findViewById(R.id.Phone);
                        EditText editTextSize = findViewById(R.id.Number);
                        String name = etName.getText().toString();
                        String phone = editTextPhone.getText().toString();
                        String size = editTextSize.getText().toString();

                        DatePicker datePicker = findViewById(R.id.datePicker);
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth() + 1;
                        int day = datePicker.getDayOfMonth();
                        TimePicker timePicker = findViewById(R.id.timePicker);
                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();

                        boolean isSmokeChecked = smoke.isChecked();
                        boolean isNonSmokeChecked = nonSmoke.isChecked();

                        StringBuilder cfm = new StringBuilder();
                        cfm.append(name).append("\n");
                        cfm.append(phone).append("\n");
                        cfm.append(size).append("\n");
                        cfm.append("The date will be: ").append(day).append("-").append(month).append("-").append(year).append("\n");
                        cfm.append("The time will be: ").append(hour).append(":").append(minute).append("\n");
                        cfm.append("Smoke table area: ").append(isSmokeChecked).append("\n");
                        cfm.append("Non Smoke table area: ").append(isNonSmokeChecked);

                        Toast.makeText(MainActivity.this,cfm.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }


