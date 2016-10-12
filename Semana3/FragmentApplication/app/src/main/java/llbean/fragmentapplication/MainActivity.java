package llbean.fragmentapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new ButtonClickListener());


        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction().add(R.id.first_container, FragmentB.newInstance(), FragmentB.TAG)
                .commit();

    }


    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            getSupportFragmentManager().beginTransaction().replace(R.id.second_container, FragmentD.newInstance(), FragmentD.TAG)
                    .addToBackStack(FragmentD.TAG).commit();
        }
    }


}
