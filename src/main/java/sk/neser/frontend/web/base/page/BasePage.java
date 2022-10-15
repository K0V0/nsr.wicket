package sk.neser.frontend.web.base.page;

import org.apache.wicket.markup.html.WebPage;
import sk.neser.frontend.web.base.component.foot.FootPanel;
import sk.neser.frontend.web.base.component.head.HeadPanel;
import sk.neser.frontend.web.base.component.nav.NavPanel;
import sk.neser.frontend.web.base.component.search.SearchPanel;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage extends WebPage {

    private static final List<String> CSS_FILES = new ArrayList<>() {{
        add("Reset.css");
        add("Classes.css");
    }};

    public BasePage() {
        /** head */
        add(headPanel());
        /** body > header */
        add(new NavPanel());
        add(new SearchPanel());
        /** body > footer */
        add(new FootPanel());
    }

    protected HeadPanel headPanel() {
        return new HeadPanel(this);
    }

}
