package sk.neser.frontend.web.base.component.search.search_form;

import org.apache.wicket.markup.html.panel.Panel;

public class SearchFormPanel extends Panel {

    public SearchFormPanel(String id) {
        super(id);
        add(new SearchForm("searchForm"));
    }

}
