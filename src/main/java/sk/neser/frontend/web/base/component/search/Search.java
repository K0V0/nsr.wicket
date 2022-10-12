package sk.neser.frontend.web.base.component.search;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.web.base.component.search.search_form.SearchForm;
import sk.neser.frontend.web.base.component.search.search_form.SearchFormDTO;

public class Search extends Panel {

    public Search() {
        super("search");
        Form<SearchFormDTO> searchForm = new SearchForm("searchForm");
        searchForm.add(new AjaxFormSubmitBehavior("onsubmit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target); // Breakpoint on this line
            }
        });
        add(searchForm);
    }
}
