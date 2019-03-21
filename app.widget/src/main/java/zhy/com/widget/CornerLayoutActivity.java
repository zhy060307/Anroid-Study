package zhy.com.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CornerLayoutActivity extends AppCompatActivity {

    private CornerImageLayout cornerImageLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corner_layout);
        cornerImageLayout = findViewById(R.id.corner_layout);

        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cornerImageLayout.setCornerVisible(true);
            }
        });


        findViewById(R.id.btn_hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cornerImageLayout.setCornerVisible(false);
            }
        });

    }
}
