package com.saucedemo.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static com.saucedemo.tasks.Login.withCredentials;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class LoginTest {

    private Actor juan = Actor.named("Juan");

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        juan.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_login_successfully_with_valid_credentials() {
        juan.attemptsTo(Open.url("https://www.saucedemo.com/"));
        juan.attemptsTo(withCredentials("standard_user", "secret_sauce"));

        // Aquí puedes agregar las validaciones usando matchers o assertions de Serenity
    }

    @Test
    public void should_see_error_message_for_blocked_user() {
        juan.attemptsTo(Open.url("https://www.saucedemo.com/"));
        juan.attemptsTo(withCredentials("locked_out_user", "secret_sauce"));

        // Aquí puedes validar que el mensaje de error es el esperado
    }
}
