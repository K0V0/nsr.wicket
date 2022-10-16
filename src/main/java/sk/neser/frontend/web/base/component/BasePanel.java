package sk.neser.frontend.web.base.component;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import sk.neser.frontend.web.base.util.script.ScriptUtil;

public abstract class BasePanel extends Panel {

    private final ScriptUtil scriptUtil;

    public BasePanel(String id) {
        super(id);
        this.scriptUtil = new ScriptUtil(this, BasePanel.class);
        this.scriptUtil.init();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        scriptUtil.getComponentCssResources().forEach(response::render);
    }
}
