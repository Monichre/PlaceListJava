import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Place list!");
  }

  @Test
  public void placeIsCreatedTest(){
  	goTo("http://localhost:4567/");
    fill("#places").with("Seattle");
    submit(".btn");
    assertThat(pageSource()).contains("Your place has been saved.");
  }
  @Test
  public void multiplePlacessAreDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#places").with("Seattle");
    submit(".btn");
    click("a", withText("Go Back"));
    fill("#places").with("Los Angeles");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Seattle");
    assertThat(pageSource()).contains("Los Angeles");
  }
}
