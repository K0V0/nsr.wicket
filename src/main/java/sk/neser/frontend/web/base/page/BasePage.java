package sk.neser.frontend.web.base.page;

import org.apache.wicket.markup.html.WebPage;
import sk.neser.frontend.web.base.component.nav.Nav;

public class BasePage extends WebPage {

    public BasePage() {
        add(new Nav());
    }
}
