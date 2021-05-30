package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

	@Test
	public void testAddAndDeleteItemsToReadingList() throws InterruptedException {

		String[] searchLang = new String[]{"Java","Python"};
		String[] articleTitle = new String[searchLang.length];
		String[] article_card_text = new String[searchLang.length];
		int deletingElement = 1;

		if(!Platform.getInstance().isMW()){
			WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
			WelcomePageObject.skipFirstScreen();
		}
		AuthorizationPageObject Auth = AuthorizationPageObjectFactory.get(driver);
		NavigationUI NavigationUI = NavigationUIFactory.get(driver);
		NavigationUI.goToAuthFromMainMenu();
		Auth.authToWiki("etrabukhin","etarab18");

		for (int i = 0; i < searchLang.length; i++) {

			SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
			SearchPageObject.searchArticle(searchLang[i]);
			articleTitle[i] = SearchPageObject.getLangArticleTitle(searchLang[i]);
			article_card_text[i] = articleTitle[i] + " " + SearchPageObject.getLangArticleDescription(searchLang[i]);
			SearchPageObject.openLanguageArticlePage(searchLang[i]);
			NavigationUI.deletingArticleFromRL();
			NavigationUI.addingToReadingList();
		}

		if(!Platform.getInstance().isMW()){
			ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
			ArticlePageObject.returnToMainPage();
		} else {
			NavigationUI.openMainMenuOnMW();
		}
		NavigationUI.goToSavedArticlesPage();
		MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);

		if(Platform.getInstance().isAndroid()){
			MyListsPageObject.goToDefaultReadingList();
		} else if(Platform.getInstance().isIOS()){
			MyListsPageObject.closeRLSyncPopup();
		}

		MyListsPageObject.deleteElementFromReadingList(articleTitle[deletingElement]);
		if(Platform.getInstance().isMW()){
			driver.navigate().refresh();
		}

		for (int i = 0; i < MyListsPageObject.countSearchResultsOnScreen(searchLang[searchLang.length - (deletingElement + 1)]); i++) {

			if(!Platform.getInstance().isMW()){
				String full_description = "";
				full_description = MyListsPageObject.getArticleTitleString(i + 1) + " " + MyListsPageObject.getLangArticleDescription(i + 1);

				 if (i != deletingElement){
					Assert.assertEquals(article_card_text[i],full_description);
				 }else{
					 Assert.assertNotEquals(articleTitle[i] + " was delete",
						full_description,
						article_card_text[i]);
				 }
			} else {
                if (i != deletingElement){
                    Assert.assertEquals(articleTitle[i],MyListsPageObject.getArticleTitleString(i + 1));
                }else{
                    Assert.assertNotEquals(articleTitle[i] + " was delete",
                            MyListsPageObject.getArticleTitleString(i + 1),
                            articleTitle[i]);
                }
            }
		}
	}
}
