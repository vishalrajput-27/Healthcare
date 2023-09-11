package com.example.myhealthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp: 5yrs", "Mobile No:9835462389","600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp: 15yrs", "Mobile No:7835462389","900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp: 10yrs", "Mobile No:8235462389","300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No:9834546238","500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp: 7yrs", "Mobile No:9835462398","800"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Nachiket Shimpee", "Hospital Address : Navrangpura", "Exp: 12yrs", "Mobile No:8743987465","700"},
                    {"Doctor Name : Arbaz Khan", "Hospital Address : Dhanilimda", "Exp: 2yrs", "Mobile No:7835463289","400"},
                    {"Doctor Name : Akshi Thakkar", "Hospital Address : Aavkar Hall ", "Exp: 20yrs", "Mobile No:8235462387","1000"},
                    {"Doctor Name : Deepanshu Aggarwal", "Hospital Address : Bopal", "Exp: 5yrs", "Mobile No:9824546238","550"},
                    {"Doctor Name : Sakshi Rajora", "Hospital Address : Kankaria", "Exp: 11yrs", "Mobile No:9835462398","300"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Manasvi Patel", "Hospital Address : Navrangpura", "Exp: 5yrs", "Mobile No:9835462839","600"},
                    {"Doctor Name : Sourabh Pandey", "Hospital Address : Dhanilimda", "Exp: 25yrs", "Mobile No:7835662389","1200"},
                    {"Doctor Name : Dhananjay Sharma", "Hospital Address : Aavkar Hall", "Exp: 10yrs", "Mobile No:8335462389","1300"},
                    {"Doctor Name : Jaydeep Patel", "Hospital Address : Bopal", "Exp: 30yrs", "Mobile No:8834546238","1500"},
                    {"Doctor Name : Abhisekh Zakhariya", "Hospital Address : Kankaria", "Exp: 2yrs", "Mobile No:9835462298","900"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Ajit Sharma", "Hospital Address : Pimpri", "Exp: 1yrs", "Mobile No:9835562389","100"},
                    {"Doctor Name : Prasad Pandey", "Hospital Address : Nigdi", "Exp: 5yrs", "Mobile No:7835462329","900"},
                    {"Doctor Name : Swapnil Patel", "Hospital Address : Pune", "Exp: 15yrs", "Mobile No:8235462389","2000"},
                    {"Doctor Name : Anjan Deshmukh", "Hospital Address : Chinchwad", "Exp: 3yrs", "Mobile No:9834446238","500"},
                    {"Doctor Name : Ashok Wadke", "Hospital Address : Katraj", "Exp: 8yrs", "Mobile No:6835462398","850"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Preet Patel", "Hospital Address : Ranip", "Exp: 5yrs", "Mobile No:9825462389","600"},
                    {"Doctor Name : Elvis Christian", "Hospital Address : MountAbu", "Exp: 9yrs", "Mobile No:6835462389","400"},
                    {"Doctor Name : Pratham Kale", "Hospital Address : Pune", "Exp: 14yrs", "Mobile No:8235462380","700"},
                    {"Doctor Name : Ankush Bahuguna", "Hospital Address : Chinchwad", "Exp: 6yrs", "Mobile No:9834556238","600"},
                    {"Doctor Name : Krishna Joshi", "Hospital Address : Kankaria", "Exp: 7yrs", "Mobile No:9835462198","450"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][0]);
            item.put("line3", doctor_details[i][0]);
            item.put("line4", doctor_details[i][0]);
            item.put("line5", "Cons Fees"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5 "},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });



        }


    }
