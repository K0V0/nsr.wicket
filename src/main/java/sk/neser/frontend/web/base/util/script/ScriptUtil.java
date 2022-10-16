package sk.neser.frontend.web.base.util.script;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptUtil implements Serializable {

    private final List<CssReferenceHeaderItem> componentCssResources;
    private final Component componentContext;
    private final Class baseClass;
    private final List<Class> classesChain;

    private final Map<Class, List<String>> componentCssFileNamesBefore;
    private final Map<Class, List<String>> componentCssFileNamesAfter;

    public ScriptUtil(Component component, Class baseClass) {
        this.componentContext = component;
        this.baseClass = baseClass;
        this.componentCssFileNamesBefore = new HashMap<>();
        this.componentCssFileNamesAfter = new HashMap<>();
        this.componentCssResources = new ArrayList<>();
        this.classesChain = ScriptUtilUtils.getAncestorClassesUntilBase(componentContext.getClass(), baseClass);
    }

    public void init() {
        createComponentCssResources();
    }

    /** add CSS file(s) before css of actual component */
    public void addCssFileBefore(String componentCssFile, Class klass) {
        ScriptUtilUtils.addComponentCssFile(componentCssFileNamesBefore, componentCssFile, klass);
    }
    public void addCssFileAfter(String componentCssFile, Class klass) {
        ScriptUtilUtils.addComponentCssFile(componentCssFileNamesAfter, componentCssFile, klass);
    }

    /** add file(s) after css of actual component */
    public void addCssFilesBefore(List<String> componentCssFiles, Class klass) {
        ScriptUtilUtils.addComponentCssFiles(componentCssFileNamesBefore, componentCssFiles, klass);
    }
    public void addCssFilesAfter(List<String> componentCssFiles, Class klass) {
        ScriptUtilUtils.addComponentCssFiles(componentCssFileNamesAfter, componentCssFiles, klass);
    }

    public List<CssReferenceHeaderItem> getComponentCssResources() {
        return componentCssResources;
    }

    protected void createComponentCssResources() {
        for (Class klass : classesChain) {
            /** files before component(s) file */
            ScriptUtilUtils.addFilesToResources(componentCssResources, klass, componentCssFileNamesBefore);
            /** component(s) CSS file(s) */
            ScriptUtilUtils.addFilesToResources(componentCssResources, klass);
            /** files after component CSS */
            ScriptUtilUtils.addFilesToResources(componentCssResources, klass, componentCssFileNamesAfter);
        }
    }
}
