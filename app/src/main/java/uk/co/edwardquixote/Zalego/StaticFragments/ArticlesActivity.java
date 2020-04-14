package uk.co.edwardquixote.Zalego.StaticFragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ArticlesActivity extends AppCompatActivity implements InterfaceFragmentCommunication {

    //  We declare our NothingToShowFragment & FragmentManager class objects as global variables.
    private NothingToShowFragment classNothingToShowFragment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //  Here we call our "codeToAddNothingToShowFragment()" method, inside "onStart()" method of our ArticlesActivity.
        codeToAddNothingToShowFragment();

    }

    @Override
    protected void onStop() {
        super.onStop();

        //  Here we call our method to remove NothingToShowFragment, inside "onStop()" lifecycle method of our ArticlesActivity.
        codeToRemoveNothingToShowFragment();

    }


    //  Here's our method to add our Nothing to Show Fragment to our Activity.
    private void codeToAddNothingToShowFragment() {

        classNothingToShowFragment = new NothingToShowFragment();

        fragmentManager = this.getSupportFragmentManager();

        //  Here we create a FragmentTransaction class object from the "beginTransaction()" method.
        //  "beginTransaction()" method resides in the FragmentManager class, that's why use the FragmentManager class object to access it.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //  Here we call the FragmentTransaction's "add()" method and pass to it two parameters.
        //  These are the most common parameters for this method; an Id and a fragment class instance object.
        fragmentTransaction.add(R.id.frameLayoutArticleFragmentContainer, classNothingToShowFragment);

        //  Here we commit the transaction we've just configured.
        //  A Fragment transaction must be committed for it to be executed; otherwise it won't be executed.
        fragmentTransaction.commit();

    }

    //  Here's our method to add our Nothing to Show Fragment to our Activity.
    private void codeToRemoveNothingToShowFragment() {

        if (classNothingToShowFragment != null) {

            fragmentManager = this.getSupportFragmentManager();

            //  Here we create a FragmentTransaction class object from the "beginTransaction()" method.
            //  "beginTransaction()" method resides in the FragmentManager class, that's why use the FragmentManager class object to access it.
            FragmentTransaction removeFragmentTransaction = fragmentManager.beginTransaction();

            //  Here we call the FragmentTransaction's "remove()" method and pass to it one parameter.
            //  These parameter is our fragment's class instance object.
            removeFragmentTransaction.remove(classNothingToShowFragment);

            //  Here we commit the transaction we've just configured, without worrying about saving any state.
            //  A Fragment transaction must be committed for it to be executed; otherwise it won't be executed.
            removeFragmentTransaction.commitAllowingStateLoss();

        }

    }

    //  Here's our method to add our Article Detail Fragment to our Activity.
    //  It takes in a parameter of type Integer.
    private void codeToAddArticleDetailFragment(int articleId) {

        //  Here we create a Bundle and put our "articleId" into it.
        //  Notice the key of our "articleId" in our bundle is: BUNDLE_KEY_ARTICLE_ID.
        //  We'll use this key when retrieving our "articleId".
        Bundle bundleDataToPassToFragment = new Bundle();
        bundleDataToPassToFragment.putInt("BUNDLE_KEY_ARTICLE_ID", articleId);

        //  Here we create a class instance object of our Article Detail Fragment.
        //  We then use that object to call the "setArguments()" method which takes in a Bundle; our bundle with the "articleId".
        ArticleDetailFragment classArticleDetailFragment = new ArticleDetailFragment();
        classArticleDetailFragment.setArguments(bundleDataToPassToFragment);

        fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //  Here we call the FragmentTransaction's "replace()" method and pass to it two parameters.
        //  These two parameters are; an Id and a fragment class instance object.
        fragmentTransaction.replace(R.id.frameLayoutArticleFragmentContainer, classArticleDetailFragment);

        //  We add our Fragment Transaction to the back stack of fragment transactions.
        //  The "addToBackStack()" method takes in a String parameter that's the name of the fragment transaction.
        //  In this case, our transaction has no name, so we can pass in NULL.
        fragmentTransaction.addToBackStack(null);

        //  Here we commit the transaction we've just configured.
        fragmentTransaction.commit();

    }


    @Override
    public void showArticleDetail(int articleId) {
        //  Here's the Interface method implemented in our ArticlesActivity class.

        codeToAddArticleDetailFragment(articleId);

    }

}
