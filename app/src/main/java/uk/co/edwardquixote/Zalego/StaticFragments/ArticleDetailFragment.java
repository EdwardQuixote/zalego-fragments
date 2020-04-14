package uk.co.edwardquixote.Zalego.StaticFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//  Here's our ArticleDetailFragment class.
//  For it to be a Fragment Java class, it has to extend the Fragment class that comes with the Android framework.
public class ArticleDetailFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //  Here's our "onAttach()" lifecycle call back method.
        //  It's called when our Fragment gets attached to an Activity.
        //  Notice that it takes in a parameter of type Context; that represents an object of its host Activity.

    }

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

        View viewFragmentLayout = inflater.inflate(R.layout.fragment_article_detail, container, false);

        //  Here we capture data that had been passed to this Fragment using the "getArguments()" method, which returns a Bundle.
        Bundle bundlePassedData = this.getArguments();
        if (bundlePassedData != null) {

            //  Here we get the value of the article Id we had passed to this Fragment through a Bundle.
            //  Please note that the key we use to get this value MUST be the same as the key we used to store the value in the Bundle.
            int articleId = bundlePassedData.getInt("BUNDLE_KEY_ARTICLE_ID");

        }

        return viewFragmentLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //  Here's our "onActivityCreated()" lifecycle call back method.
        //  It's called when our Fragment's parent Activity executes its "onCreate()" lifecycle call back.
        //  Notice that it takes in a parameter of type Bundle; contains the data state in this Fragment, if any.

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //  Here's our "onDestroyView()" lifecycle call back method.
        //  It's called when our Fragment's UI is being removed; the opposite of "onCreateView()".
        //  It's called just before the parent Activity executes its "onDestroy()" lifecycle call back.

    }

    @Override
    public void onDetach() {
        super.onDetach();

        //  Here's our "onDetach()" lifecycle call back method.
        //  It's called when our Fragment is being detached from its host Activity, i.e. Articles Activity; the opposite of "onAttach()".

    }
}
