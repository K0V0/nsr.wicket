package sk.neser.frontend.web.base.component.head;

import org.apache.wicket.Component;
import org.apache.wicket.request.resource.CssResourceReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class HeadPanelUtils {

    protected static final String CSS_FILENAME_FORMAT = "%s.css";

    private HeadPanelUtils() {}

    protected static final void addComponentCssFile(List<String> files, String fileToAdd) {
        if (files == null) files = new ArrayList<>();
        files.add(fileToAdd);
    }

    protected static final void addComponentCssFiles(List<String> files, List<String> filesToAdd) {
        if (files == null) files = new ArrayList<>();
        files.addAll(filesToAdd);
    }

    protected static final CssResourceReference createCssResourceReference(Component component, String cssFileName) {
        return new CssResourceReference(
                component.getClass(),
                String.format(CSS_FILENAME_FORMAT, component.getClass().getSimpleName()));
    }

    protected static final CssResourceReference createCssResourceReference(Component component) {
        return createCssResourceReference(component, component.getClass().getSimpleName());
    }

    protected static final void addFilesToResources(List<CssResourceReference> resources, Component componentContext, List<String> fileNames) {
        Optional.ofNullable(fileNames)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(ccf -> createCssResourceReference(componentContext, ccf))
                .filter(Objects::nonNull)
                .forEach(resources::add);
    }

    protected static final void addFilesToResources(List<CssResourceReference> resources, Component componentContext) {
        Optional.ofNullable(componentContext)
                .map(HeadPanelUtils::createCssResourceReference)
                .filter(Objects::nonNull)
                .ifPresent(resources::add);
    }
}
