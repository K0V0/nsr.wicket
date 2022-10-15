package sk.neser.frontend.elements.link;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.StringResourceModel;

/**
 * wicket:id for <a> format: "CurrentComponentClass.LinkedComponentClass"
 * wicket:id for <span> format: "CurrentComponentClass.LinkedComponentClass.label"
 */
public class LinkToPage {
    private static final String ID_FORMAT_TEMPLATE = "%s.%s";
    private static final String LABEL_SUFFIX = "label";

    private LinkToPage() {}

    public static Link<Void> create(Component source, Class target) {
        String id = String.format(ID_FORMAT_TEMPLATE, source.getClass().getSimpleName(), target.getSimpleName());
        Link<Void> link = new Link<>(id) {
            @Override
            public void onClick() {
                setResponsePage(target);
            }
        };
        String labelId = String.format(ID_FORMAT_TEMPLATE, id, LABEL_SUFFIX);
        Label homePageLabel = new Label(labelId, new StringResourceModel(labelId, source));
        link.add(homePageLabel);
        return link;
    }

}
