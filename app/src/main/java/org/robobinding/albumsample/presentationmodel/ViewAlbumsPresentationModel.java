package org.robobinding.albumsample.presentationmodel;

import java.util.ArrayList;
import java.util.List;

import org.robobinding.albumsample.model.Album;
import org.robobinding.albumsample.store.AlbumStore;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.widget.adapterview.ItemClickEvent;

import android.util.Log;

/**
 * @author Cheng Wei
 * @author Robert Taylor
 * @since 1.0
 */
@PresentationModel
public class ViewAlbumsPresentationModel implements HasPresentationModelChangeSupport {

    private final ViewAlbumsView view;
    private final AlbumStore albumStore;
    private final PresentationModelChangeSupport changeSupport;

    public ViewAlbumsPresentationModel(ViewAlbumsView view, AlbumStore albumStore) {
        this.view = view;
        this.albumStore = albumStore;
        this.changeSupport = new PresentationModelChangeSupport(this);
    }

    @ItemPresentationModel(AlbumItemPresentationModel.class)
    public List<Album> getAlbums() {
        Log.d(ViewAlbumsPresentationModel.class.getSimpleName(), "in getAlbums():" + albumStore.getAll().size() + " albums");
        return new ArrayList<Album>(albumStore.getAll());
    }

    public void refreshAlbums() {
        changeSupport.firePropertyChange("albums");
    }

    public void createAlbum() {
        view.createAlbum();
    }

    public void viewAlbum(ItemClickEvent event) {
        viewAlbum(event.getPosition());
    }

    private void viewAlbum(int selectedAlbumPosition) {
        Album album = albumStore.getByIndex(selectedAlbumPosition);
        view.viewAlbum(album.getId());
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
