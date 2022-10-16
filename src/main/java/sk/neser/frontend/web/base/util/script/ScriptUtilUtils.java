package sk.neser.frontend.web.base.util.script;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ScriptUtilUtils {

    protected static final String CSS_FILENAME_FORMAT = "%s.css";

    private ScriptUtilUtils() {}

    protected static final void addComponentCssFile(Map<Class, List<String>> files, String fileToAdd, Class klass) {
        if (fileToAdd == null || klass == null) return;
        files.computeIfAbsent(klass, k -> new ArrayList<>());
        files.get(klass).add(fileToAdd);
    }

    protected static final void addComponentCssFiles(Map<Class, List<String>> files, List<String> filesToAdd, Class klass) {
        if (filesToAdd == null || klass == null) return;
        files.computeIfAbsent(klass, k -> new ArrayList<>());
        files.get(klass).addAll(filesToAdd);
    }

    protected static final CssResourceReference createCssResourceReference(Class klass, String cssFileName) {
        return new CssResourceReference(klass, cssFileName);
    }

    protected static final CssResourceReference createCssResourceReference(Class klass) {
        return createCssResourceReference(klass, klass.getSimpleName());
    }

    protected static final void addFilesToResources(List<CssReferenceHeaderItem> resources, Class klass, Map<Class, List<String>> fileNames) {
        Optional.ofNullable(fileNames)
                .map(fn -> fn.get(klass))
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .distinct()
                .map(ccf -> createCssResourceReference(klass, ccf))
                .filter(ccf -> ccf.getResource() != null && ccf.getResource().getResourceStream() != null)
                .map(CssHeaderItem::forReference)
                .forEach(resources::add);
    }

    protected static final void addFilesToResources(List<CssReferenceHeaderItem> resources, Class klass) {
        Map<Class, List<String>> files = new HashMap<>();
        files.put(klass, Collections.singletonList(String.format(CSS_FILENAME_FORMAT, klass.getSimpleName())));
        addFilesToResources(resources, klass, files);
    }

    protected static final List<Class> getAncestorClasses(Class componentClass) {
        List<Class> result = new ArrayList<>();
        Class superClass = componentClass.getSuperclass();
        if (superClass != null) {
            result.add(componentClass);
            result.addAll(getAncestorClasses(superClass));
        }
        return result;
    }

    protected static final List<Class> getAncestorClassesUntilBase(Class componentClass, Class baseClass) {
        List<Class> classes = getAncestorClasses(componentClass);
        List<Class> result = new ArrayList<>(classes.subList(0, classes.indexOf(baseClass) + 1));
        Collections.reverse(result);
        return result;
    }
}
