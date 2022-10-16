package sk.neser.frontend.web.base.component.search;

import sk.neser.frontend.web.base.component.BasePanel;
import sk.neser.frontend.web.base.component.search.search_form.SearchFormPanel;

public class SearchPanel extends BasePanel {

    public SearchPanel() {
        super("search");
        add(new SearchFormPanel("searchFormPanel"));
    }
}
