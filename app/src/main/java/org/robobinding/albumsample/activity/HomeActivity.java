package org.robobinding.albumsample.activity;

import org.robobinding.albumsample.R;
import org.robobinding.albumsample.presentationmodel.HomePresentationModel;
import org.robobinding.albumsample.presentationmodel.HomeView;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author Cheng Wei
 * @author Robert Taylor
 * @since 1.0
 */
public class HomeActivity extends AbstractActivity implements HomeView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomePresentationModel presentationModel = new HomePresentationModel(this);
        initializeContentView(R.layout.activity_home, presentationModel);
    }

    @Override
    public void showAlbums() {
        startActivity(new Intent(this, ViewAlbumsActivity.class));
    }
}
