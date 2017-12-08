package com.kaklotar.harin.tableexpandeblelistviewrow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TableLayout tableLayout;
    // TableRow row;

    User user;

    List<User> userList = new ArrayList<>();

    String[] studentName = {"Harin", "Harit", "Spider man", "Thor", "IronMan"};
    String[] studentSurName = {"India", "Germany", "New York", "Asgard", "America"};

    ImageView moreButton;
    TextView number, name, surname;
    LinearLayout secondLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = (TableLayout) findViewById(R.id.table);

        user = new User();

        addTempData();


    }

    private void addTempData() {
        User newUser;
        for (int i = 0; i < 5; i++) {

            newUser = new User();
            newUser.setName(studentName[i]);
            newUser.setSurname(studentSurName[i]);
            userList.add(newUser);
        }

        addDataToTable();
    }

    private void addDataToTable() {

        for (int i = 0; i < userList.size(); i++) {
            final TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.table_row, null);

            row.setId(i);

            row.setTag(i);

            number = row.findViewById(R.id.lbl_number);
            name = row.findViewById(R.id.lbl_name);
            surname = row.findViewById(R.id.lbl_surname);
            secondLayout = row.findViewById(R.id.secondLayout);
            secondLayout.setTag(100 + i);

            number.setText("" + i);
            name.setText(userList.get(i).getName());
            surname.setText(userList.get(i).getSurname());

            moreButton = row.findViewById(R.id.lbl_more);

            moreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int clickId = ((int) row.getTag() + 100);
                    Log.d("tag", "" + clickId);

                    secondLayout = (LinearLayout) row.findViewWithTag(clickId);
                    if (secondLayout.getVisibility() == View.VISIBLE) {
                        secondLayout.setVisibility(View.GONE);
                    } else {
                        secondLayout.setVisibility(View.VISIBLE);
                    }

                }
            });

            tableLayout.addView(row);
        }

    }

}
