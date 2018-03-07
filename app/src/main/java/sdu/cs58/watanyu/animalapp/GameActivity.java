package sdu.cs58.watanyu.animalapp;

        import android.media.Image;
        import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;

        import java.util.ArrayList;
        import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    ///Explicit
    Button btn1,btn2,btn3, btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer;
    int questionCount = 1;///เก็บข้อคำถาม

    ArrayList<Integer> qID = new ArrayList<Integer>();
    String answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ///initial view
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);
        ///เเสดงคำถามบนหน้าจอ
        for (int i =1;i<=questionCount; i++) {
            qID.add(i);
        }
        Collections.shuffle(qID);///กำหนดสุ่มคำถาม
        setQuestion(qID.remove(0));
        

    }///end oncreate

    private void setQuestion(int qID) {  ///กำหนดข้อคำถามเเละเฉลย
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>(); ///กำหนดการสุ่มคำตอบ
            choice.add("นก");
            choice.add("วัว");
            choice.add("หมา");
            choice.add("หมู");
            Collections.shuffle(choice);///กำหมดสุ่มลำกับคำตอบ
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
    }///end setQ
        public void playSound (View view){
        mediaPlayer.start();



    }
}///end class
