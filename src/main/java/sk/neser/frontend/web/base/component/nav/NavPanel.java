package sk.neser.frontend.web.base.component.nav;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.web.home.page.HomePage;
import sk.neser.frontend.web.info.page.InfoPage;

public class NavPanel extends Panel {

    public NavPanel() {
        super("nav");

        add(new Link<Void>("web.base.nav.home") {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
        //add(new Label("web.base.nav.home.text", "web.base.nav.home.text"));

        add(new Link<Void>("web.base.nav.info") {
            @Override
            public void onClick() {
                setResponsePage(InfoPage.class);
            }
        });
        //add(new Label("web.base.nav.info.text", "web.base.nav.info.text"));

    }

}
