package uk.co.edwardquixote.Zalego.StaticFragments;

//  Here's our Interface.
//  Notice how instead of using the keyword "class", we use the keyword "interface".
public interface InterfaceFragmentCommunication {

    /**
     * We declare the signature of our "showArticleDetail()" method.
     * The method is void; returns nothing.
     * It also takes in a parameter of type Integer - this will simulate an Article Id.
     *
     * Notice that we don't provide the implementation of the method here, thus we don't have curly brackets for it.
     * We just specify its signature - so at the end, we put a semi-colon to end the statement.
     */
    void showArticleDetail(int articleId);

}
