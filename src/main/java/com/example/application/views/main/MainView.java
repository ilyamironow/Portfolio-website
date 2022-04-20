package com.example.application.views.main;

import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Ilya Mironov")
@Route(value = "hello")
@RouteAlias(value = "")
@CssImport("mainpage.css")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();

        Image githubIcon = new Image("icons/github.png", "");
        githubIcon.setWidth(32, Unit.PIXELS);
        Image linkedinIcon = new Image("icons/linkedin.png", "");
        linkedinIcon.setWidth(32, Unit.PIXELS);

        Anchor resumeAnchor = new Anchor("https://resume.io/r/JPx5Nn98Q",
                "Резюме");
        Anchor githubAnchor = new Anchor("https://github.com/ilyamironow", githubIcon);
        Anchor linkedinAnchor = new Anchor("https://www.linkedin.com/in/ilyamironow",
                linkedinIcon);
        githubAnchor.setTarget("_blank");
        linkedinAnchor.setTarget("_blank");

        Tab resume = new Tab(resumeAnchor);
        Tab payment = new Tab(githubAnchor);
        Tab linkedIn = new Tab(linkedinAnchor);

        Tabs tabs = new Tabs(resume, payment, linkedIn);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.addClassName("tabs");

        Label nameLabel = new Label("Илья Миронов / Software Developer");
        nameLabel.getStyle().set("font-size", "1.4em");
        nameLabel.getStyle().set("font-weight", "400");

        /* big slogan styling - start */
        Label titleLabel = new Label("приложения.");
        titleLabel.addClassName("animate");

        Paragraph paragraph = new Paragraph(
                new Text("Я создаю\n"), titleLabel);

        paragraph.getStyle().set("font-size", "5em");
        paragraph.getStyle().set("font-weight", "bold");
        paragraph.setWhiteSpace(HasText.WhiteSpace.PRE_LINE);
        /* big slogan styling - end */

        Image img = new Image("images/photo_2022-04-17_00-33-50.jpg", "");
        img.setWidth(200, Unit.PIXELS);

        HorizontalLayout horizontalLayout = new HorizontalLayout(paragraph, img);
        horizontalLayout.setSizeFull();
        horizontalLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
        horizontalLayout.setVerticalComponentAlignment(Alignment.CENTER, paragraph, img);

        setHorizontalComponentAlignment(Alignment.CENTER, tabs, horizontalLayout, nameLabel);
        add(tabs, horizontalLayout, nameLabel);


        /* these dates should be changed later */
        // TODO: 20.04.2022 move nameLabel to the left

        // TODO: 20.04.2022 change main photo

        // TODO: 20.04.2022 change slogan про баги?

        // TODO: 21.04.2022 add label "Проекты" with arrow below

        // TODO: 22.04.2022 add python project and make arrow and label navigate to it

        // TODO: 23.04.2022 deploy
    }
}
