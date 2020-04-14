package uk.co.edwardquixote.Zalego.StaticFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

//  Here's our ArticleListFragment class.
//  For it to be a Fragment Java class, it has to extend the Fragment class that comes with the Android framework.
public class ArticleListFragment extends Fragment {

    //  Here we declare a variable to hold our Interface object.
    private InterfaceFragmentCommunication interfaceFragmentCommunication;


    /**
     * Here is our onAttach() lifecycle method.
     * Inside this method we'll check that our Activity has implemented our Interface.
     * The @Override annotation you see, means that this class has been overriden from it's parent class (i.e. Fragment class)
     * Our onAttach() method takes in some parameters, as annotated below:
     * @param context                      (Context) This is the context to which our Fragment belongs; usually our Activity.
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //  We check if our Activity, i.e. ArticlesActivity, has implemented out interface in a Try - Catch block.
        //  If our Activity hasn't implemented our Interface, then this code will throw a ClassCastException error.
        //  Remember that Context is gotten from an Activity.
        try {
            interfaceFragmentCommunication = (InterfaceFragmentCommunication) context;
        } catch (ClassCastException ccex) {
            throw new ClassCastException(this.getActivity().toString() + " MUST IMPLEMENT InterfaceFragmentCommunication! ccex: " + ccex);
        }

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

        View viewFragmentLayout = inflater.inflate(R.layout.fragment_article_list, container, false);

        //  Our data source - a hardcoded String array. In a production scenario, this data would be coming from a DB on a server.
        String[] articleListArray = {
                "Google & Apple team up to develop tracing app for virus cases",
                "New Images of the Sun reveal a wondrous sight",
                "10 things to know about Android 10",
                "A new keyboard for typing braille on Android",
                "Everything announced at the Google for Games Developer Summit",
                "Bringing more people online and introducing Camera Go",
                "New malware protections for Advanced Protection users",
                "Transcribe speech with Google Translate",
                "New music constrols, emoji and more features for Pixel",
                "Five (of many) new emoji coming to Android this year"
        };

        List<String> listArticleList = Arrays.asList(articleListArray);
        AdapterArticleList classAdapter = new AdapterArticleList(listArticleList, interfaceFragmentCommunication);

        //  We set up our RecyclerView
        RecyclerView rvArticleList = (RecyclerView) viewFragmentLayout.findViewById(R.id.rvArticleList);
        rvArticleList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvArticleList.setHasFixedSize(true);
        rvArticleList.setItemAnimator(new DefaultItemAnimator());
        rvArticleList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rvArticleList.setAdapter(classAdapter);

        return viewFragmentLayout;
    }

}
