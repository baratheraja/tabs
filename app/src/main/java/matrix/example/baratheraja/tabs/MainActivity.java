package matrix.example.baratheraja.tabs;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Riddles Of the Sphinx");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar2);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(toolbar.getTitle());
        }
    }
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        OneFragment oneFragment = new OneFragment();
        Bundle args = new Bundle();
        OneFragment oneFragment2 = new OneFragment();
        Bundle args2 = new Bundle();

        args.putString("value","All the Crofts and Jones out there - k! is back with yet another scintillating edition of it's pride - 'Riddles of Sphinx', the largest online treasure hunt of Asia. If you are that one kind who wants to ride through the mighty mazes and perplexing puzzles but with the comfort of lying inside your room and staring at your own PC, then BANG!! ROS is your homeground. Celebrated for it's entangled nature, never easy competence and, more importantly, it's fun trivia, the event primarily fosters on testing your lateral thinking, underlying patience, and of course your incredible googling skills. For all you greenhorns, ROS requires nothing other than infinite patience and infinite enthusiasm. Contained within the hunt are a series of levels with verbal, visual and audio hints, teasing your grey cells to unlock the maze and ace the race to be crowned the \"Master of all treasure Hunts\". ");
        args2.putString("value","» Riddles of the Sphinx is an individual online event.You should posses a computing device with a fair internet connection to join the hunt.\n" +
                "\n" +
                "» The event consists of series of levels with visuals and texts which are riddles and you should solve them to advance to the next level.\n" +
                "\n" +
                "» This is a non-technical event and there is absolutely no preparation or previous experience needed.\n" +
                "\n" +
                "» We will be hosting a trial run to give the new users a live hunt experience.\n" +
                "\n" +
                "» The organisers' decisions will be final and binding.");
        oneFragment.setArguments(args);
        oneFragment2.setArguments(args2);
        adapter.addFragment(oneFragment, "Introduction");
        adapter.addFragment(oneFragment2, "Rules and Format");
        adapter.addFragment(new ThreeFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
