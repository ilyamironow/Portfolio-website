package com.example.application.views.main;

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

        Anchor resumeAnchor = new Anchor("https://resume.io/r/JPx5Nn98Q", "Resume");
        Anchor githubAnchor = new Anchor("https://github.com/ilyamironow", "GitHub");
        Anchor linkedinAnchor = new Anchor("https://www.linkedin.com/in/ilyamironow", "LinkedIn");

        Tab resume = new Tab(resumeAnchor);
        Tab payment = new Tab(githubAnchor);
        Tab linkedIn = new Tab(linkedinAnchor);

        Tabs tabs = new Tabs(resume, payment, linkedIn);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.addClassName("tabs");

        Label nameLabel = new Label("Ilya Mironov / Software Developer");
        nameLabel.getStyle().set("font-size", "1.4em");
        nameLabel.getStyle().set("font-weight", "400");

        /* big slogan styling - start */
        Label titleLabel = new Label("приложения.\n");
        titleLabel.addClassName("animate");

        Paragraph paragraph = new Paragraph(
                new Text("Я создаю "), titleLabel);

        paragraph.getStyle().set("font-size", "5em");
        paragraph.getStyle().set("font-weight", "bold");
        paragraph.setWidth(600, Unit.PIXELS);
        /* big slogan styling - end */

        Image img = new Image("images/photo_2022-04-17_00-33-50.jpg", "");
        img.setWidth(200, Unit.PIXELS);

        HorizontalLayout horizontalLayout = new HorizontalLayout(paragraph, img);
        horizontalLayout.setSizeFull();
        horizontalLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
        horizontalLayout.setVerticalComponentAlignment(Alignment.CENTER, paragraph, img);

        setHorizontalComponentAlignment(Alignment.CENTER, tabs, horizontalLayout, nameLabel);
        add(tabs, horizontalLayout, nameLabel);
    }
}
