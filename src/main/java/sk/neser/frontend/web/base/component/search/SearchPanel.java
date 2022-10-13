package sk.neser.frontend.web.base.component.search;

import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.web.base.component.search.search_form.SearchFormPanel;

public class SearchPanel extends Panel {

    public SearchPanel() {
        super("search");
        add(new SearchFormPanel("searchFormPanel"));
    }
}
