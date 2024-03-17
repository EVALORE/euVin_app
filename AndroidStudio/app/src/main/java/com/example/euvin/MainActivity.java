package com.example.euvin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnHeartClickListener, OnItemClickListener {
    List<Events> unLikedItems = new ArrayList<Events>();
    List<Events> likedItems = new ArrayList<Events>();
    private MyAdapter adapterUnLikedItems;
    private MyAdapter adapterLikedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.listEvents);

        adapterUnLikedItems = new MyAdapter(getApplicationContext(), unLikedItems, this, this);
        adapterLikedItems = new MyAdapter(getApplicationContext(), likedItems, this, this);
        recyclerView.setAdapter(adapterUnLikedItems);

        ImageButton buttonCategorii = findViewById(R.id.buttonCategorii);
        ImageButton buttonEvenimente = findViewById(R.id.buttonEvenimente);
        ImageButton buttonEuVin = findViewById(R.id.buttonEuVin);

        TextView textTitle = findViewById(R.id.textTitles);

        buttonCategorii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonEvenimente.setBackgroundResource(R.drawable.evenimente_ico_inactiv);
                buttonEuVin.setBackgroundResource(R.drawable.liked_ico_inactiv);
                buttonCategorii.setBackgroundResource(R.drawable.categorii_ico_activ);
                textTitle.setText("Alege categoriile dorite");
            }
        });

        buttonEvenimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonEvenimente.setBackgroundResource(R.drawable.evenimente_ico_activ);
                buttonEuVin.setBackgroundResource(R.drawable.liked_ico_inactiv);
                buttonCategorii.setBackgroundResource(R.drawable.categorii_ico_inactiv);
                textTitle.setText("Evenimentele");
                recyclerView.setAdapter(adapterUnLikedItems);
            }
        });

        buttonEuVin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonEvenimente.setBackgroundResource(R.drawable.evenimente_ico_inactiv);
                buttonEuVin.setBackgroundResource(R.drawable.liked_ico_activ);
                buttonCategorii.setBackgroundResource(R.drawable.categorii_ico_inactiv);
                textTitle.setText("Evente Selectate");
                recyclerView.setAdapter(adapterLikedItems);
            }
        });

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.recycler_view_spacing);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        unLikedItems.add(new Events("Experiențe culinare și culturale", "Mihăileni", "Marti, 19 Martie", "13:00 - 17:00", "🍲 Experiențe culinare și culturale la Mihăileni! Se pare că activitățile comune ale refugiaților de la Centrul de refugiați de la Mihăileni și băștinașii de aici nu încetează să fie îmbibate cu gust, tradiție și dans. ", "Cultura", R.drawable.vechiculinar, false));
        unLikedItems.add(new Events("Activitati sportive", "Sangereni, ", "Luni, 18 Martie", "09:00 - 12:00", "👵🏻👴🏽Grupul de vârstnici de la Sângerei se adună regulat pentru a se bucura de diverse activități sportive și recreative. Echipa HelpAge dorește să susțină și să implice cât mai multe persoane în practicarea sportului, de aceea vine în susținerea acestui grup, oferindu-le recuzita necesară pentru a le oferi posibilitatea de a practica mai multe tipuri de exerciții sportive! 🏋️‍♀️🚴‍♂️🏓 ", "Sport", R.drawable.vechisport, false));
        unLikedItems.add(new Events("Oportunități pentru vârstnici", "or. Nisporeni", "Duminica, 10 Februarie", "09:00 - 16:00", "👵🏻👴🏽📲 Oportunități digitale pentru vârstnici În timp ce tehnologia avansează rapid, mulți vârstnici se confruntă cu dificultăți în adaptarea la schimbările digitale. Unul din obiectivele proiectului pentru Îmbătrânirea Activă și Sănătoasă este să ajutăm vârstnicii să utilizeze cat mai multe servicii on-line pentru a le îmbunătăți calitatea vieții.📱✨", "Comunicare", R.drawable.vechidigital, false));
        unLikedItems.add(new Events("Muzică, tradiții și artizanat. ", "Cojușna", "Luni, 25 Februarie", "09:00 - 18:00", "🎤🧶🧵În comunitatea de vârstnici din Cojușna, activitățile sunt în plină desfășurare, adunându-i pe seniori pentru experiențe bogate de muzică, cultură, tradiții și artizanat. Doamna Zinaida Bolboceanu moderează cu dăruire clubul de muzică, aducând nu doar acorduri frumoase, ci și informații valoroase despre tradițiile noastre naționale.","Comunicare", R.drawable.vechimusic, false));
        unLikedItems.add(new Events("Jocuri Sociale ", "Ialoveni", "Miercuri, 20 Februarie", "11:00 - 18:00", "Într-o lume plină de provocări și agitație, merită uneori să ne lăsăm purtați în lumea copilăriei.💫 De fapt, jocurile sunt pentru toată lumea și toate vârstele și uneori ar fi bine să ne pierdem în lumea lor! Așa s-a întâmplat la Ialoveni, unde jocurile sociale au devenit o adevărată sursă de entuziasm și conectare pentru cei mai în vârstă. 👴👵","Jocuri", R.drawable.vechigames, false));
        unLikedItems.add(new Events("Cursa Sobolanului", "Eli-Pili cafe", "Joi, 21 Martie", "19:00 - 21:00" ,"🚀 Astăzi: Întâlnire Cashflow - Îmbogățește-ți Abilitățile Financiare! 🌟 Bună ziua, comunitatea pasionaților de jocuri de societate! Astăzi este ziua mare! Te invităm la o sesiune extraordinară de Cashflow, unde te vei putea bucura de strategii financiare și competiție amicală. Iată detaliile importante:🕖 Ora de începere: 19:00⏳ Durata jocului: Până la 21:00", "Jocuri",R.drawable.vechisobolan, false));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterUnLikedItems);
    }
    @Override
    public void onHeartClicked(Events event) {
        if (event.isLiked()) {
            int indexToRemove = unLikedItems.indexOf(event);
            if (indexToRemove != -1) {
                unLikedItems.remove(indexToRemove);
                likedItems.add(event);
                adapterUnLikedItems.notifyItemRemoved(indexToRemove);
            }
        } else {
            int indexToRemove = likedItems.indexOf(event);
            if (indexToRemove != -1) {
                likedItems.remove(indexToRemove);
                unLikedItems.add(event);
            }
        }
        // Обновляем основной адаптер, если оба списка используют один и тот же адаптер
//        adapter.notifyDataSetChanged(); // Это временное решение; лучше использовать более конкретные методы notifyItem*
    }

    @Override
    public void onItemClick(Events event) {
        Intent intent = new Intent(this, ItemDetailsActivity.class);
        intent.putExtra("name", event.getName());
        intent.putExtra("location", event.getLocation());
        intent.putExtra("date", event.getDate());
        intent.putExtra("time", event.getTime());
        intent.putExtra("categories", event.getCategories());
        intent.putExtra("description", event.getDescription());
        intent.putExtra("img", event.getImg());
        startActivity(intent);
    }

}