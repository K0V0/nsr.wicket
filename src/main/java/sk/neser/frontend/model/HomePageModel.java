package sk.neser.frontend.model;

import org.apache.wicket.model.IModel;

public class HomePageModel implements IModel {

    @Override
    public Object getObject() {
        return "kovova wicket stranka";
    }
}
