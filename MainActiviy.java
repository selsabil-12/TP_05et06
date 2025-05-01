package com.example.l3si.premireapplication;
 
 import android.os.Bundle;
 import android.view.View;
 import android.widget.TextView;
 
 import androidx.activity.EdgeToEdge;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.graphics.Insets;
 import androidx.core.view.ViewCompat;
 import androidx.core.view.WindowInsetsCompat;
 
 public class MainActivity extends AppCompatActivity {
 
     TextView textView;
     int messageIndex = 0;
 
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_main);
 
         textView = findViewById(R.id.salutations_text_view);
 
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
             return insets;
         });
     }
 
     // الزر - عرض عدة رسائل بالتناوب
     public void montrerSalutations(View view) {
         String message = "";
 
         switch (messageIndex) {
             case 0:
                 message = "Bienvenue à ma première application";
                 break;
             case 1:
                 message = "مرحبا بك في تطبيقي الأول";
                 break;
             case 2:
                 message = "Welcome to my first app!";
                 break;
             case 3:
                 message = "أهلا وسهلا في التطبيق!";
                 break;
             case 4:
                 message = "Have a great day!";
                 break;
             default:
                 message = "Bienvenue à ma première application";
                 messageIndex = 0;
                 break;
         }
 
         textView.setText(message);
 
         // الانتقال إلى الرسالة التالية
         messageIndex++;
 
         if (messageIndex > 4) {
             messageIndex = 0;
         }
     }
 }
