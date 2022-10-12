package sk.neser.frontend.web.base.component.search;


import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.web.base.component.search.search_form.SearchForm;
import sk.neser.frontend.web.base.component.search.search_form.SearchFormDTO;

public class Search extends Panel {

    public Search() {
        super("searchBar");
        Form<SearchFormDTO> searchForm = new SearchForm("search");
        add(searchForm);
    }
}
