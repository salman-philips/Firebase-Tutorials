package com.example.fire1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(getIntent()!=null && getIntent().hasExtra("Kral")){
//            for(String key:getIntent().getExtras().keySet()) {
//                if(key.equalsIgnoreCase("Kral"))
//                Toast.makeText(this, "He is " + key + " " + getIntent().getExtras().getString(key), Toast.LENGTH_SHORT).show();
//            }
//        }
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if(task.isSuccessful()){
                    String token=task.getResult().getToken();
                    Log.d("sel",""+token);
                }
                else{
                    Log.d("sel",""+task.getException());
                }
            }
        });
    }
}