package org.robobinding.albumsample.presentationmodel;

import org.robobinding.annotation.PresentationModel;

/**
 * @author Cheng Wei
 * @author Robert Taylor
 * @since 1.0
 */
@PresentationModel
public class HomePresentationModel {
    private final HomeView view;

    public HomePresentationModel(HomeView view) {
        this.view = view;
    }

    public void albums() {
        view.showAlbums();
    }
}
