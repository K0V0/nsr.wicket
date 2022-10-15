package sk.neser.frontend.web.info.page;

import sk.neser.frontend.web.base.component.head.HeadPanel;
import sk.neser.frontend.web.base.page.BasePage;

public class InfoPage extends BasePage {

    public InfoPage() {
        super();
    }

    @Override
    protected HeadPanel headPanel() {
        return new HeadPanel(this);
    }
}
