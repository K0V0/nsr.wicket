package sk.neser.frontend.web.base.util.script;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptUtil implements Serializable {

    private final List<CssReferenceHeaderItem> componentCssResources;
    private final Component componentContext;
    private final Class baseClass;
    private final List<Class> classesChain;

    //private final List<String> componentCssFileNames;
    private List<String> componentCssFileNamesBefore;
    private List<String> componentCssFileNamesAfter;

    public ScriptUtil(Component component, Class baseClass) {
        this.componentContext = component;
        this.baseClass = baseClass;
        this.classesChain = ScriptUtilUtils.getAncestorClassesUntilBase(componentContext.getClass(), baseClass);
        //this.componentCssFileNames = getComponentCssFileNames();
        this.componentCssResources = createComponentCssResources();
    }

    /** add CSS file(s) before css of actual component */
    public void addCssFileBefore(String componentCssFile) {
        ScriptUtilUtils.addComponentCssFile(componentCssFileNamesBefore, componentCssFile);
    }
    public void addCssFileAfter(String componentCssFile) {
        ScriptUtilUtils.addComponentCssFile(componentCssFileNamesAfter, componentCssFile);
    }

    /** add file(s) after css of actual component */
    public void addCssFilesBefore(List<String> componentCssFiles) {
        ScriptUtilUtils.addComponentCssFiles(componentCssFileNamesBefore, componentCssFiles);
    }
    public void addCssFilesAfter(List<String> componentCssFiles) {
        ScriptUtilUtils.addComponentCssFiles(componentCssFileNamesAfter, componentCssFiles);
    }

    public List<CssReferenceHeaderItem> getComponentCssResources() {
        return componentCssResources;
    }

//    protected List<String> getComponentCssFileNames() {
//        return ScriptUtilUtils.getAncestorClassesUntilBase(componentContext.getClass(), baseClass)
//                .stream().map(Class::getSimpleName).collect(Collectors.toList());
//    }
    protected List<CssReferenceHeaderItem> createComponentCssResources() {
        List<CssReferenceHeaderItem> resources = new ArrayList<>();
        for (Class klass : classesChain) {
            /** component(s) CSS file(s) */
            ScriptUtilUtils.addFilesToResources(resources, klass);
        }
//        if (componentContext != null) {
//            /** files before component(s) file */
//            ScriptUtilUtils.addFilesToResources(resources, componentContext, componentCssFileNamesBefore);
//            /** component(s) CSS file(s) */
//            ScriptUtilUtils.addFilesToResources(resources, componentContext, componentCssFileNames);
//            /** files after component CSS */
//            ScriptUtilUtils.addFilesToResources(resources, componentContext, componentCssFileNamesAfter);
//        }
        return resources;
    }
}
