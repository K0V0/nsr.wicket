package sk.neser.frontend.web.base.util.script;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ScriptUtilUtils {

    protected static final String CSS_FILENAME_FORMAT = "%s.css";

    private ScriptUtilUtils() {}

    protected static final void addComponentCssFile(List<String> files, String fileToAdd) {
        if (files == null) files = new ArrayList<>();
        files.add(fileToAdd);
    }

    protected static final void addComponentCssFiles(List<String> files, List<String> filesToAdd) {
        if (files == null) files = new ArrayList<>();
        files.addAll(filesToAdd);
    }

    protected static final CssResourceReference createCssResourceReference(Class klass, String cssFileName) {
        return new CssResourceReference(klass, String.format(CSS_FILENAME_FORMAT, cssFileName));
    }

    protected static final CssResourceReference createCssResourceReference(Class klass) {
        return createCssResourceReference(klass, klass.getSimpleName());
    }

    protected static final void addFilesToResources(List<CssReferenceHeaderItem> resources, Class klass, List<String> fileNames) {
        Optional.ofNullable(fileNames)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(ccf -> createCssResourceReference(klass, ccf))
                .filter(Objects::nonNull)
                .map(CssHeaderItem::forReference)
                .forEach(resources::add);
    }

    protected static final void addFilesToResources(List<CssReferenceHeaderItem> resources, Class klass) {
        addFilesToResources(resources, klass, Collections.singletonList(klass.getSimpleName()));
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
