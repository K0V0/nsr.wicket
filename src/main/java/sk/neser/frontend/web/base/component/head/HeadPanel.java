package sk.neser.frontend.web.base.component.head;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.StringResourceModel;
import sk.neser.frontend.web.base.component.BasePanel;

public class HeadPanel extends BasePanel {

    private static final String TITLE_RESOURCE = "title";

    private Component componentContext;
    private String pageTitle;

    /** <head> construction logic */

    public HeadPanel(Component componentContext) {
        super("head");
        this.componentContext = componentContext;
        add(new Label("web.base.head.title", getPageTitle()));
    }

    /** set text inside head > title tag */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    protected String getPageTitle() {
        if (pageTitle != null) return pageTitle;
        if (componentContext == null) componentContext = this;
        return new StringResourceModel(TITLE_RESOURCE, componentContext).getString();
    }

}
