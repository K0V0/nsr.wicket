package sk.neser.frontend.web.base.component.nav;

import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.elements.link.LinkToPage;
import sk.neser.frontend.web.home.page.HomePage;
import sk.neser.frontend.web.info.page.InfoPage;

public class NavPanel extends Panel {

    public NavPanel() {
        super("nav");
        add(LinkToPage.create(this, HomePage.class));
        add(LinkToPage.create(this, InfoPage.class));
    }

}
