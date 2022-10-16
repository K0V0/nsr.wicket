package sk.neser.frontend.web.base.component.nav;

import sk.neser.frontend.elements.link.LinkToPage;
import sk.neser.frontend.web.base.component.BasePanel;
import sk.neser.frontend.web.home.page.HomePage;
import sk.neser.frontend.web.info.page.InfoPage;

public class NavPanel extends BasePanel {

    public NavPanel() {
        super("nav");
        add(LinkToPage.create(this, HomePage.class));
        add(LinkToPage.create(this, InfoPage.class));
    }

}
