package sk.neser.frontend.web.base.component.head;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.resource.CssResourceReference;

import java.util.ArrayList;
import java.util.List;

public class HeadPanel extends Panel {

    private static final String TITLE_RESOURCE = "title";

    private static HeadPanel INSTANCE;

    private final List<CssResourceReference> componentCsses;

    private Component componentContext;
    private List<String> componentCssFilesBefore;
    private List<String> componentCssFilesAfter;
    private String pageTitle;

    /** <head> construction logic */

//    public static final HeadPanel getInstance(Component componentContext) {
//        if (INSTANCE == null) {
//            INSTANCE = new HeadPanel(componentContext);
//        }
//        return INSTANCE;
//    }
//
//    private HeadPanel() {
//        this(null);
//    }

    public HeadPanel(Component componentContext) {
        super("head");
        String title = getPageTitle();
        add(new Label("web.base.head.title", title));
        this.componentCsses = new ArrayList<>();
        this.componentContext = componentContext;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        for (CssResourceReference cssResourceReference : getComponentCsses()) {
            response.render(CssHeaderItem.forReference(cssResourceReference));
        }
    }

    /** set text inside head > title tag */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /** add CSS file(s) before css of actual component */
    public void addComponentCssFileBefore(String componentCssFile) {
        HeadPanelUtils.addComponentCssFile(componentCssFilesBefore, componentCssFile);
    }
    public void addComponentCssFileAfter(String componentCssFile) {
        HeadPanelUtils.addComponentCssFile(componentCssFilesAfter, componentCssFile);
    }

    /** add file(s) after css of actual component */
    public void addComponentCssFilesBefore(List<String> componentCssFiles) {
        HeadPanelUtils.addComponentCssFiles(componentCssFilesBefore, componentCssFiles);
    }
    public void addComponentCssFilesAfter(List<String> componentCssFiles) {
        HeadPanelUtils.addComponentCssFiles(componentCssFilesAfter, componentCssFiles);
    }

    protected String getPageTitle() {
        if (pageTitle != null) return pageTitle;
        if (componentContext == null) componentContext = this;
        return new StringResourceModel(TITLE_RESOURCE, componentContext).getString();
    }

    protected List<CssResourceReference> getComponentCsses() {
        if (componentContext != null) {
            /** files before main component file */
            HeadPanelUtils.addFilesToResources(componentCsses, componentContext, componentCssFilesBefore);
            /** main component CSS */
            HeadPanelUtils.addFilesToResources(componentCsses, componentContext);
            /** files after main CSS */
            HeadPanelUtils.addFilesToResources(componentCsses, componentContext, componentCssFilesAfter);
        }
        return componentCsses;
    }

}
