package sk.neser.frontend.web.base.page;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import sk.neser.frontend.web.base.component.foot.FootPanel;
import sk.neser.frontend.web.base.component.head.HeadPanel;
import sk.neser.frontend.web.base.component.nav.NavPanel;
import sk.neser.frontend.web.base.component.search.SearchPanel;
import sk.neser.frontend.web.base.util.script.ScriptUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage extends WebPage {

    private static final List<String> CSS_FILES = new ArrayList<>();
    static {
        CSS_FILES.addAll(Arrays.asList("Reset.css", "Elements.css", "Classes.css"));
    }

    private final ScriptUtil scriptUtil;

    public BasePage() {
        /** head - css scripts */
        scriptUtil = new ScriptUtil(this, BasePage.class);
        addCssScripts(scriptUtil);
        scriptUtil.init();
        /** head - other info */
        add(headPanel());
        /** body > header */
        add(new NavPanel());
        add(new SearchPanel());
        /** body > footer */
        add(new FootPanel());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        scriptUtil.getComponentCssResources().forEach(response::render);
    }

    protected HeadPanel headPanel() {
        return new HeadPanel(this);
    }

    protected void addCssScripts(ScriptUtil scriptUtil) {
        scriptUtil.addCssFilesBefore(CSS_FILES, BasePage.class);
    }

}
