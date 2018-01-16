package nyc.c4q.MovieDBUserTest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import nyc.c4q.MovieDBUserTest.API.MovieDBService;
import nyc.c4q.MovieDBUserTest.Service.MovieDatabaseServiceGenerator;
import nyc.c4q.MovieDBUserTest.controller.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

  public static final MovieDBService DBCallback = MovieDatabaseServiceGenerator.createService();

  private static final String TAG = "JSON?";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fragmentTabLayout();
  }

  private void fragmentTabLayout() {

    TabLayout tabLayout = findViewById(R.id.main_tab_layout);
    tabLayout.addTab(tabLayout.newTab().setText("Movies"));
    tabLayout.addTab(tabLayout.newTab().setText("TV"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    final ViewPager viewPager = findViewById(R.id.main_viewpager);
    FragmentAdapter fragmentAdapter =
        new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
    viewPager.setAdapter(fragmentAdapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }
}
