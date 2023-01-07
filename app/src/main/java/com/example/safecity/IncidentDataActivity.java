package com.example.safecity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class IncidentDataActivity extends AppCompatActivity {
    ImageView backBtn;
    RecyclerView incidentRV;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_data);

        firebaseFirestore = FirebaseFirestore.getInstance();

        backBtn = findViewById(R.id.incidentDataBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        incidentRV = findViewById(R.id.incidentRV);
        incidentRV.setLayoutManager(new LinearLayoutManager(IncidentDataActivity.this, LinearLayoutManager.VERTICAL, false));
        final List<IncidentModel> incidentModelList = new ArrayList<>();
        final IncidentAdapter incidentAdapter = new IncidentAdapter(incidentModelList);
        incidentRV.setAdapter(incidentAdapter);

        firebaseFirestore.collection("INCIDENTS").document("USER_INCIDENTS").get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            for (long x = 1; x <= (long) task.getResult().get("no_of_incidents"); x++) {
                                if (task.getResult().get("INCIDENT_SRC_"+x).toString().equals("Safecity")) {
                                    incidentModelList.add(new IncidentModel(task.getResult().get("INCIDENT_TYPES_" + x).toString(), task.getResult().get("INCIDENT_DATE_" + x).toString(), task.getResult().get("INCIDENT_DESC_" + x).toString(), task.getResult().get("SAFETY_TIP_" + x).toString(), task.getResult().get("INCIDENT_SRC_" + x).toString()));
                                }
                            }
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                        }
                        incidentAdapter.notifyDataSetChanged();
                    }
                });
    }
}