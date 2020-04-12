package kot.mvvm.myapplication.utils;

import android.view.MenuItem;
import android.view.View;

public interface ItemClickListener {
    public void onClick(int position);

    boolean onMenuItemClick(MenuItem item);
}