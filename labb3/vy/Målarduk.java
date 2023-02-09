package labb3.vy;

import java.awt.*;
import java.util.ArrayList;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;

import static labb3.GlobalaKonstanter.*;
import static labb3.modell.Väderstreck.*;
import labb3.modell.Väderstreck;
import labb3.verktyg.Grafik;
import labb3.verktyg.Punkt;

import javax.swing.*;

// TODO: Ändra nästa rad så att en Målarduk "är-en" JPanel.
public class Målarduk extends javax.swing.JPanel{

    private final Nivå enNivå;

    public Målarduk(Nivå enNivå) {
        this.enNivå = enNivå;
        // TODO: Sätt bakgrundsfärgen på this till MARKFÄRG.
        // TODO: Anropa metoden setFocusable på this och med argumentet true.
        // Detta behövs för att lyssnaren i programmet ska reagera.
        this.setBackground(MARKFÄRG);
        this.setFocusable(true);
    }

    // TODO: Lätt till @Override på metoden nedan.
    protected void paintComponent(Graphics g) {
        // TODO Lägg till ett anrop till paintComponent i omedelbara
        // överklassen (JPanel). Skicka med g som argument.
        super.paintComponent(g);

        // TODO: Lägg till kod som ritar ut en grafisk vy av enNivå.
        //
        // För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
        // noga bilderna i labbinstruktionen för att få fram formlerna för
        // bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
        // labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
        for (int i = 0; i < enNivå.rum.size(); i++) {
            ritaRum(g, enNivå.rum.get(i));
            try {
                ritaGångarFrånRum(g, enNivå.rum.get(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        try {
            ritaMarkörFörVarAnvändarenÄr(g);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void ritaRum(Graphics g, Rum ettRum) {
        g.setColor(Color.BLACK);
        g.fillRect(ettRum.getÖvX()-VÄGGTJOCKLEK, ettRum.getÖvY()-VÄGGTJOCKLEK,
                ettRum.getBredd()+VÄGGTJOCKLEK*2,
                ettRum.getHöjd() + VÄGGTJOCKLEK*2);

        g.setColor(ettRum.getGolvfärg());
        g.fillRect(ettRum.getÖvX(), ettRum.getÖvY(), ettRum.getBredd(), ettRum.getHöjd());
    }

    private void ritaGångarFrånRum(Graphics g, Rum ettRum) throws Exception {
        for (int i = 0; i < ettRum.getGList().size(); i++) {
            ritaGång(g, ettRum.getGList().get(i));
        }
    }

    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        switch (enRiktning){
            case NORR:
                return new Punkt(ettRum.getÖvX()+(ettRum.getBredd()/2), ettRum.getÖvY());
            case ÖSTER:
                return new Punkt(ettRum.getÖvX()+ettRum.getBredd(), ettRum.getÖvY()+(ettRum.getHöjd()/2));
            case SÖDER:
                return new Punkt(ettRum.getÖvX()+(ettRum.getBredd()/2), ettRum.getÖvY()+ettRum.getHöjd());
            case VÄSTER:
                return new Punkt(ettRum.getÖvX(), ettRum.getÖvY()+(ettRum.getHöjd()/2));
            default:
                return null;

        }
    }

    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {

        switch (enRiktning){
            case NORR:
                return new Punkt(ettRum.getÖvX()+(ettRum.getBredd()/2),
                        ettRum.getÖvY()-VÄGGTJOCKLEK-HALV_VÄGGTJOCKLEK);
            case ÖSTER:
                return new Punkt(ettRum.getÖvX()+ettRum.getBredd()+VÄGGTJOCKLEK+HALV_VÄGGTJOCKLEK,
                        ettRum.getÖvY()+(ettRum.getHöjd()/2));
            case SÖDER:
                return new Punkt(ettRum.getÖvX()+(ettRum.getBredd()/2),
                        ettRum.getÖvY()+ettRum.getHöjd()+VÄGGTJOCKLEK+HALV_VÄGGTJOCKLEK);
            case VÄSTER:
                return new Punkt(ettRum.getÖvX()-VÄGGTJOCKLEK-HALV_VÄGGTJOCKLEK,
                        ettRum.getÖvY()+(ettRum.getHöjd()/2));
            default:
                return null;

        }
    }

    private void ritaGång(Graphics g, Gång enGång) {
        Punkt b1 = baspunkt(enGång.getFrån(), enGång.getRUUF());
        Punkt p1 = pivotpunkt(enGång.getFrån(), enGång.getRUUF());
        Punkt b3 = baspunkt(enGång.getTill(), enGång.getRIIT());
        Punkt p3 = pivotpunkt(enGång.getTill(), enGång.getRIIT());

        Grafik.drawThickLine(g, b1, p1, VÄGGTJOCKLEK, GÅNGFÄRG);
        Grafik.drawThickLine(g, p1, p3, VÄGGTJOCKLEK, GÅNGFÄRG);
        Grafik.drawThickLine(g, p3, b3, VÄGGTJOCKLEK, GÅNGFÄRG);
        Grafik.fillCircle(g, b1, HALV_VÄGGTJOCKLEK, GÅNGFÄRG);
        Grafik.fillCircle(g, b3, HALV_VÄGGTJOCKLEK, GÅNGFÄRG);

    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) throws Exception {
        Rum pos = this.enNivå.getPlayerPos();
        g.setColor(Color.BLACK);
        g.fillOval(pos.getÖvX()+(pos.getBredd()/2), pos.getÖvY()+(pos.getHöjd()/2), 10, 10);

    }

}
