package com.ksivlay.crudstudentapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ksivlay.crudstudentapp.R;
import com.ksivlay.crudstudentapp.adapter.CustomerProvinceAdapter;
import com.ksivlay.crudstudentapp.models.Province;
import com.ksivlay.crudstudentapp.models.Student;

public class StudentFormActivity extends BaseActivity {

    private EditText etFirstName, etLastName, etAddress, etPhoneNumber;
    private Button btnAdd, btnBack;
    private RadioButton rdMale, rbFemale;
    private Spinner spinnerProvice;

    //CustomerProvinceAdapter provinceAdapter;
    private Province selectProvince;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddress);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        rdMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnAdd = findViewById(R.id.btnCreate);
        btnBack = findViewById(R.id.btnBack);
        spinnerProvice = findViewById(R.id.spinnerProvince);
        getAllProvince();

        CustomerProvinceAdapter provinceAdapter = new CustomerProvinceAdapter(this,provinceList);
        spinnerProvice.setAdapter(provinceAdapter);
        spinnerProvice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectProvince = provinceList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                if(firstName.isEmpty()){
                    showMessage("Please input First Name");
                    return;
                }
                if(lastName.isEmpty()){
                    showMessage("Please input Last Name");
                    return;
                }
                if(address.isEmpty()){
                    showMessage("Please input address");
                    return;
                }
                if(phoneNumber.isEmpty()){
                    showMessage("Please input Phone Number");
                    return;
                }
                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
                student.setPhoneNumber(phoneNumber);
                student.setGender(rdMale.isActivated()? "Male" : "Female");
                student.setProvince(selectProvince);
                //studentList.add(student);
                addStudent(student);
                finish();
            }
        });

    }
}