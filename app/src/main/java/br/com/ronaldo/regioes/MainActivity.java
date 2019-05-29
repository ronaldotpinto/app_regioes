package br.com.ronaldo.regioes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private TextView tvRegiao;
    private TextView tvEstado;
    private String[] regiao , sul , sudeste , centro_oeste , nordeste , norte;
    private int contRegiao = 0;
    private int contEstado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        regiao = getResources().getStringArray(R.array.regiao);
        sul = getResources().getStringArray(R.array.sul);
        sudeste = getResources().getStringArray(R.array.sudeste);
        centro_oeste = getResources().getStringArray(R.array.centro_oeste);
        nordeste = getResources().getStringArray(R.array.nordeste);
        norte = getResources().getStringArray(R.array.norte);

        layout = (ConstraintLayout) findViewById(R.id.swipe);
        tvRegiao = (TextView) findViewById(R.id.txtRegiao);
        tvEstado = (TextView) findViewById(R.id.txtEstado);

        tvRegiao.setText( regiao[contRegiao] );
        tvEstado.setText( sul[contEstado] );


        layout.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                tvRegiao.setText(regiao[contRegiao]);
                contRegiao++;
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvRegiao.setText(regiao[contRegiao]);
                contRegiao--;
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                switch (regiao[contRegiao]){
                    case "Norte":
                        tvEstado.setText(norte[contEstado]);
                        if (contEstado >= norte.length){
                            contEstado = 0;
                        }
                        break;

                    case "Nordeste":
                        tvEstado.setText(nordeste[contEstado]);
                        if (contEstado >= nordeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "Centro Oeste":
                        tvEstado.setText(centro_oeste[contEstado]);
                        if (contEstado >= centro_oeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "Sudeste":
                        tvEstado.setText(sudeste[contEstado]);
                        if (contEstado >= sudeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "Sul":
                        tvEstado.setText(sul[contEstado]);
                        if (contEstado >= sul.length){
                            contEstado = 0;
                        }
                        break;
                }
                contEstado++;
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                switch (regiao[contRegiao]){
                    case "Norte":
                        tvEstado.setText(norte[contEstado]);
                        if (contEstado == 0){
                            contEstado = norte.length;
                        }
                        break;

                    case "Nordeste":
                        tvEstado.setText(nordeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = nordeste.length;
                        }
                        break;

                    case "Centro Oeste":
                        tvEstado.setText(centro_oeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = centro_oeste.length;
                        }
                        break;

                    case "Sudeste":
                        tvEstado.setText(sudeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = sudeste.length;
                        }
                        break;

                    case "Sul":
                        tvEstado.setText(sul[contEstado]);
                        if (contEstado == 0){
                            contEstado = sul.length;
                        }
                        break;
                }
                contEstado--;
            }
        });

    }
}
