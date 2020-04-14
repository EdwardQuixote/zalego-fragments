package uk.co.edwardquixote.Zalego.StaticFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//  Here's our NothingToShowFragment class.
//  For it to be a Fragment Java class, it has to extend the Fragment class that comes with the Android framework.
public class NothingToShowFragment extends Fragment {

    /**
     * Here is our onCreateView() lifecycle method.
     * Inside this method we'll set up the UI of our fragment.
     * The @Nullable annotations you see, simply define the possibility of values being NULL.
     * The @Override annotation you see, means that this class has been overriden from it's parent class (i.e. Fragment class)
     * Our onCreateView() method takes in some parameters, as annotated below:
     * @param inflater                      (LayoutInflater) This is the layout inflater object that will be used to inflate our UI from our UI XML layout file.
     * @param container                     (ViewGroup) This is the viewgroup on which our Fragment will be placed on; remember Fragments reside inside an Activity.
     * @param savedInstanceState            (Bundle) This contains any data that has been saved by the Android OS in regards to the lifecycle of this Fragment.
     * @return This method must return a View object that is simply our UI from the fragment's layout file.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View viewFragmentLayout = inflater.inflate(R.layout.fragment_nothing_to_show, container, false);

        return viewFragmentLayout;
    }

}
