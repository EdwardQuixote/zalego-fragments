package uk.co.edwardquixote.Zalego.StaticFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//  Here's our class that will act as our RecyclerView Adapter.
//  Inside it, we'll create our ViewHolder class.
public class AdapterArticleList extends RecyclerView.Adapter<AdapterArticleList.AdapterArticleListViewHolder> {

    //  This is a global variable of type "InterfaceFragmentCommunication".
    //  It'll receive, through our constructor, the InterfaceFragmentCommunication value passed from our Fragment.
    private InterfaceFragmentCommunication fragmentCommunicationInterface;


    //  This is the list variable that will recieve the list data from our Fragment.
    private List<String> listArticleTitles;


    //  Here, in the constructor, we create a parameter variable of the type of our Interface
    public AdapterArticleList(@NonNull List<String> listOfArticleTitles, InterfaceFragmentCommunication interfaceFragmentCommunication) {

        this.listArticleTitles = listOfArticleTitles;

        this.fragmentCommunicationInterface = interfaceFragmentCommunication;

    }


    @NonNull
    @Override
    public AdapterArticleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //  Here we attach our row layout UI to our adapter, then pass the View object created to our ViewHolder class.
        View vRowLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_article, parent, false);
        AdapterArticleListViewHolder classViewHolder = new AdapterArticleListViewHolder(vRowLayoutView);

        return classViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArticleListViewHolder holder, final int position) {

        //  Here we get the title of the article from the list at the specific position this method is called,
        //  Then we set it to the TextView to be displayed.
        String articleTitle = listArticleTitles.get(position);
        holder.txtArticleTitle.setText(articleTitle);

        //  Here, inside "onBindViewHolder()", we implement an OnClickListener subclass
        //  We use this OnClickListener as a way of listening to the clicks made on the row layout view of our RecyclerView.
        //  Whenever the user taps on a list item, this "onClick()" method will be triggered.
        //  Notice that we attach this OnClickListener to our "itemView" View object which we use in our ViewHolder's constructor.
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //  Here we call our interface method, i.e. "showArticleDetail()".
                //  We'll start with checking if our interface object in this class is null; to avoid NullPointerException
                //  We'll then call the method and pass to it the current list position of the item that has been clicked.
                //  We'll assume that this position, is the Id.
                //  Notice that this position, is a variable of type int declared in as a parameter of our "onBindViewHolder()" method.
                if (fragmentCommunicationInterface != null) {
                    fragmentCommunicationInterface.showArticleDetail(position);
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return listArticleTitles.size();
    }


    //  Here's our RecyclerView.ViewHolder class that we'll connect to our Adapter class.
    static class AdapterArticleListViewHolder extends RecyclerView.ViewHolder {

        //  Here we declare Views that we want to map to our views that we created in our row layout view UI.
        //  We created an ImageView and a TextView
        private ImageView imgvArticleImage;

        private TextView txtArticleTitle;


        //  Here's our pre-defined constructor; we must define it as long as we're extending the RecyclerView.ViewHolder class.
        //  It takes in a parameter of type View. This View parameter is the row layout view we'll attach to our RecyclerView Adapter class.
        //  The @NonNull annotation simply means the value of "itemView" can never and should never be null.
        private AdapterArticleListViewHolder(@NonNull View itemView) {
            super(itemView);

            //  Here we map the views we declared to their respective views from our UI.
            imgvArticleImage = (ImageView) itemView.findViewById(R.id.imgvArticleListItem);

            txtArticleTitle = (TextView) itemView.findViewById(R.id.txtArticleListItem);

        }

    }

}
