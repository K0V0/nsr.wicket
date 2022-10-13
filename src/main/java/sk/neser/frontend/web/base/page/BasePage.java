package sk.neser.frontend.web.base.page;

import org.apache.wicket.markup.html.WebPage;
import sk.neser.frontend.web.base.component.foot.FootPanel;
import sk.neser.frontend.web.base.component.nav.NavPanel;
import sk.neser.frontend.web.base.component.search.SearchPanel;

public class BasePage extends WebPage {

    public BasePage() {
        add(new NavPanel());
        add(new SearchPanel());
        add(new FootPanel());
    }
}
