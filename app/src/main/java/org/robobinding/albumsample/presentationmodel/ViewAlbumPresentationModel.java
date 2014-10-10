package org.robobinding.albumsample.presentationmodel;

import org.robobinding.albumsample.model.Album;
import org.robobinding.albumsample.store.AlbumStore;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

/**
 * @author Cheng Wei
 * @author Robert Taylor
 * @since 1.0
 */
@PresentationModel
public class ViewAlbumPresentationModel implements HasPresentationModelChangeSupport {
    private final ViewAlbumView view;
    private final AlbumStore albumStore;
    private final long albumId;
    private final PresentationModelChangeSupport changeSupport;

    private Album album;

    public ViewAlbumPresentationModel(ViewAlbumView view, AlbumStore albumStore, long albumId) {
        this.view = view;
        this.albumStore = albumStore;
        this.albumId = albumId;
        this.changeSupport = new PresentationModelChangeSupport(this);
    }

    public String getTitle() {
        return album.getTitle();
    }

    public String getArtist() {
        return album.getArtist();
    }

    public String getComposer() {
        return album.getComposer();
    }

    public boolean isComposerEnabled() {
        return album.isClassical();
    }

    public String getClassicalDescription() {
        return album.isClassical() ? "Classical" : "Not classical";
    }

    public void editAlbum() {
        view.editAlbum(album.getId());
    }

    public void deleteAlbum() {
        view.deleteAlbum(album);
    }

    public void refresh() {
        this.album = albumStore.get(albumId);
        changeSupport.refreshPresentationModel();
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }
}
