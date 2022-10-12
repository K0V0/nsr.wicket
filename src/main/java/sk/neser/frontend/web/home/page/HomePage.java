package sk.neser.frontend.web.home.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.annotation.mount.MountPath;
import sk.neser.frontend.web.base.page.BasePage;
import sk.neser.frontend.model.HomePageModel;

@WicketHomePage
@MountPath("home")
public class HomePage extends BasePage {

    public HomePage() {
        add(new Label("homepage-title", new HomePageModel()));
    }

}
