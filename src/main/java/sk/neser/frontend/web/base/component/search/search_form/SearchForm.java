package sk.neser.frontend.web.base.component.search.search_form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class SearchForm extends Form<SearchFormDTO> {
    private SearchFormDTO search = new SearchFormDTO();

    public SearchForm(String id) {
        super(id);
        setDefaultModel(new CompoundPropertyModel<SearchFormDTO>(this.search));
        add(new TextField<SearchFormDTO>("expression"));
    }

    @Override
    protected void onSubmit() {
        System.out.println("Zadaný text: " + search.getExpression());
    }

}
