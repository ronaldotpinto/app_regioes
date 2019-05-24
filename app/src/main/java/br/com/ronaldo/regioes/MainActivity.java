package br.com.ronaldo.regioes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private TextView tvRegiao;
    private TextView tvEstado;
    private String[] regiao = getResources().getStringArray(R.array.regiao);
    private String[] sul = getResources().getStringArray(R.array.sul);
    private String[] sudeste = getResources().getStringArray(R.array.sudeste);
    private String[] centro_oeste = getResources().getStringArray(R.array.centro_oeste);
    private String[] nordeste = getResources().getStringArray(R.array.nordeste);
    private String[] norte = getResources().getStringArray(R.array.norte);
    private int contRegiao = 0;
    private int contEstado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout.setOnTouchListener(new OnSwipeTouchListener(this){
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
                    case "norte":
                        tvEstado.setText(norte[contEstado]);
                        if (contEstado >= norte.length){
                            contEstado = 0;
                        }
                        break;

                    case "nordeste":
                        tvEstado.setText(nordeste[contEstado]);
                        if (contEstado >= nordeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "centro_oeste":
                        tvEstado.setText(centro_oeste[contEstado]);
                        if (contEstado >= centro_oeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "sudeste":
                        tvEstado.setText(sudeste[contEstado]);
                        if (contEstado >= sudeste.length){
                            contEstado = 0;
                        }
                        break;

                    case "sul":
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
                    case "norte":
                        tvEstado.setText(norte[contEstado]);
                        if (contEstado == 0){
                            contEstado = norte.length;
                        }
                        break;

                    case "nordeste":
                        tvEstado.setText(nordeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = nordeste.length;
                        }
                        break;

                    case "centro_oeste":
                        tvEstado.setText(centro_oeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = centro_oeste.length;
                        }
                        break;

                    case "sudeste":
                        tvEstado.setText(sudeste[contEstado]);
                        if (contEstado == 0){
                            contEstado = sudeste.length;
                        }
                        break;

                    case "sul":
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
