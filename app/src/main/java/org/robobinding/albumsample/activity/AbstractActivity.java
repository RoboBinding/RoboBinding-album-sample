package org.robobinding.albumsample.activity;

import org.robobinding.ViewBinder;
import org.robobinding.albumsample.store.AlbumStore;
import org.robobinding.binder.BinderFactory;

import android.app.Activity;
import android.view.View;

/**
 * @author Cheng Wei
 * @version $Revision: 1.0 $
 * @since 1.0
 */
public abstract class AbstractActivity extends Activity {
    public void initializeContentView(int layoutId, Object presentationModel) {
        ViewBinder viewBinder = createViewBinder(true);
        View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
        setContentView(rootView);
    }

    protected ViewBinder createViewBinder(boolean withPreInitializingViews) {
        BinderFactory binderFactory = getAlbumApp().getReusableBinderFactory();
        return binderFactory.createViewBinder(this, withPreInitializingViews);
    }

    private AlbumApp getAlbumApp() {
        return (AlbumApp) getApplicationContext();
    }

    public AlbumStore getAlbumStore() {
        return getAlbumApp().getAlbumStore();
    }
}
