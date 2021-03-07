import actors.*;
import actors.exceptions.*;
import actors.things.*;
import enumerations.*;

public class Laba {
    public static void main(String[] args) {
        Mafia mafia = new Mafia("Boris", Location.MAFIA_HOME, TypeOfJob.CRIMINAL_ACTIVITY, Status.NEUTRAL);
        Banker banker = new Banker("Ilya", Location.BANK, TypeOfJob.BANKER, Status.HAPPY);
        Pschigl pschigl = new Pschigl("Pschigl", Location.STREET, TypeOfJob.POLICE_OFFICER, Status.HAPPY);
        Digl digl = new Digl("Digl", Location.STREET, TypeOfJob.POLICEMAN, Status.HAPPY);
        Gigl gigl = new Gigl("Gigl", Location.STREET, TypeOfJob.POLICEMAN, Status.HAPPY);
        Spigl spigl = new Spigl("Spigl", Location.STREET, TypeOfJob.POLICEMAN, Status.HAPPY);
        Psigl psigl = new Psigl("Psigl", Location.STREET, TypeOfJob.POLICEMAN, Status.HAPPY);
        Builder builder = new Builder("Vova", Location.STREET, TypeOfJob.BUILDER, Status.NEUTRAL);
        Designer designer = new Designer("Anna",  Location.STREET, TypeOfJob.DESIGNER, Status.NEUTRAL);
        TVpresenter tVpresenter = new TVpresenter("", Location.NEWS, TypeOfJob.TV_PRESENTER, Status.NEUTRAL);
        Kuks kuks = new Kuks("Kuks", Location.KUKS_HOME, TypeOfJob.OWNER, Status.HAPPY);
        Kaktus kaktus = new Kaktus("Kaktus", Location.KUKS_HOME, TypeOfJob.LODGER, Status.HAPPY);
        Eduard eduard = new Eduard("Eduard", Location.NEWS, TypeOfJob.EDITOR, Status.NEUTRAL);
        Miga miga = new Miga("Miga", Location.OFFICE, TypeOfJob.BUSINESSMAN, Status.HAPPY);
        Brechson brechson = new Brechson("Brechson", Location.BRECHSON_HOME, TypeOfJob.FILM_CRITIC, Status.NEUTRAL);
        Davilons davilons = new Davilons("Davilons", Location.STREET, TypeOfJob.BIKER, Status.NEUTRAL);
        GasolineDealers gasolineDealers = new GasolineDealers("Lukoil", Location.STREET, TypeOfJob.SELL_GASOLINE, Status.HAPPY);
        Poodle poodle = new Poodle("Poodle", Location.STREET, TypeOfJob.MAKE_AUTO_TIRE, Status.NEUTRAL);
        Bald[] bald = new Bald[5];
        for (int i = 0; i < 5; i++) {
            int j = i+1;
            bald[i] = new Bald("Bald" + j, Location.STREET, TypeOfJob.FREELANCER ,Status.NEUTRAL);
        }

        Money money = new Money("Money", Location.BANK, Status.NOT_GIVEN);
        Letter letter = new Letter("Letter", Location.BRECHSON_HOME, Status.NOT_SENT);
        AutoTire autotire = new AutoTire("Auto tire", Location.STREET, Status.OK);
        House house = new House("House of Kuks", Location.KUKS_HOME, Status.OK);
        House.Wall wall = house.new Wall("Wall", Location.KUKS_HOME, Status.OK);
        Newspaper newspaper = new Newspaper("Newspaper", Location.NEWS, Status.NOT_READY);
        Newspaper.Article article = newspaper.new Article("Article", Location.NEWS, Status.NOT_READY);
        Poster poster = new Poster("Poster", Location.NEWS, Status.NOT_READY);

        Court court = new Court();
        Story story = new Story();

        story.addActor(mafia); // adding actors to a story
        story.addActor(banker);
        story.addActor(brechson);
        story.addActor(pschigl);
        story.addActor(digl);
        story.addActor(gigl);
        story.addActor(psigl);
        story.addActor(spigl);
        story.addActor(builder);
        story.addActor(kuks);
        story.addActor(kaktus);
        story.addActor(eduard);
        story.addActor(davilons);
        story.addActor(gasolineDealers);
        story.addActor(poodle);

        banker.addThing(money); // adding things to the actors
        brechson.addThing(letter);
        brechson.addThing2(money);
        pschigl.addThing2(letter);
        digl.addThing2(letter);
        gigl.addThing2(letter);
        psigl.addThing2(letter);
        spigl.addThing2(letter);
        builder.addThing(wall);
        builder.addThing2(letter);
        kuks.addThing2(letter);
        kaktus.addThing2(letter);
        eduard.addThing(newspaper);
        eduard.addThing2(letter);
        davilons.addThing(autotire);
        davilons.addThing2(letter);
        poodle.addThing(autotire);
        poodle.addThing2(letter);
        miga.addThing(article);
        miga.addThing2(letter);
        designer.addThing(poster);
        designer.addThing2(letter);
        tVpresenter.addThing2(article);
        court.addThing(letter);

        mafia.addActor(banker); //adding next Actor to do something with him
        banker.addActor(brechson);
        pschigl.addActor(bald[0]);
        digl.addActor(bald[1]);
        gigl.addActor(bald[2]);
        psigl.addActor(bald[3]);
        spigl.addActor(bald[4]);
        builder.addActor(kuks);
        kuks.addActor(kaktus);
        kaktus.addActor(eduard);
        brechson.addActor(davilons);
        davilons.addActor(gasolineDealers);
        gasolineDealers.addActor(poodle);
        miga.addActor(designer);

        try {
            story.storyline(); // start the story
        } catch (MoneyIsNotGivenException e) {
            System.out.println(e.getMessage());
        }

        court.addTeller(kuks); // adding witness to first Court
        court.addTeller(kaktus);
        try {
            court.trial(); // start the first trial
        } catch (LetterIsNotSentException e) {
            System.out.println(e.getMessage());
        }

        court.addTeller(kaktus); // adding witness to second Court
        court.addTeller(eduard);
        try {
            court.trial(); // start the second trial
        } catch (LetterIsNotSentException e) {
            System.out.println(e.getMessage());
        }

        court.addTeller(gasolineDealers); // adding witness to third Court
        court.addTeller(poodle);
        court.addTeller(brechson);
        court.addTeller(davilons);
        try {
            court.trial(); // start the third trial
        } catch (LetterIsNotSentException e) {
            System.out.println(e.getMessage());
        }

        story.addActor(tVpresenter);
        story.addActor(miga);
        story.addActor(designer);

        try {
            story.storyline(); // start the story
        } catch (MoneyIsNotGivenException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("The end.");
    }
}