package sk.neser.frontend.web.base.component.search.search_form;

import java.io.Serializable;

public class SearchFormDTO implements Serializable {
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
