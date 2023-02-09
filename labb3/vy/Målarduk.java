package labb3.vy;

import java.awt.*;
import java.util.ArrayList;

import labb3.GlobalaKonstanter;
import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
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
        this.setBackground(GlobalaKonstanter.MARKFÄRG);
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
        }
        try {
            ritaGångarFrånRum(g, enNivå.rum.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ritaMarkörFörVarAnvändarenÄr(g);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void ritaRum(Graphics g, Rum ettRum) {
        g.setColor(Color.BLACK);
        g.fillRect(ettRum.getÖvX()-GlobalaKonstanter.VÄGGTJOCKLEK, ettRum.getÖvY()-GlobalaKonstanter.VÄGGTJOCKLEK,
                ettRum.getBredd()+GlobalaKonstanter.VÄGGTJOCKLEK*2,
                ettRum.getHöjd() + GlobalaKonstanter.VÄGGTJOCKLEK*2);

        g.setColor(Color.RED);
        g.fillRect(ettRum.getÖvX(), ettRum.getÖvY(), ettRum.getBredd(), ettRum.getHöjd());
    }

    private void ritaGångarFrånRum(Graphics g, Rum ettRum) throws Exception {
        ArrayList<Gång> gångar = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            switch (i){
                case 0:
                    if(ettRum.finnsUtgångÅt(Väderstreck.NORR)){
                        gångar.add(ettRum.gångenÅt(Väderstreck.NORR));
                    }
                    break;
                case 1:
                    if(ettRum.finnsUtgångÅt(Väderstreck.ÖSTER)){
                        gångar.add(ettRum.gångenÅt(Väderstreck.ÖSTER));
                    }
                    break;
                case 2:
                    if(ettRum.finnsUtgångÅt(Väderstreck.SÖDER)){
                        gångar.add(ettRum.gångenÅt(Väderstreck.SÖDER));
                    }
                    break;
                case 3:
                    if(ettRum.finnsUtgångÅt(Väderstreck.VÄSTER)){
                        gångar.add(ettRum.gångenÅt(Väderstreck.VÄSTER));
                    }
                    break;
                default:
                    break;

            }
        }
        for (Gång gång:gångar) {
            ritaGång(g, gång);
        }

    }

    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        return null; /* endast här för att Eclipse inte ska klaga */
    }

    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
        return null; /* endast här för att Eclipse inte ska klaga */
    }

    private void ritaGång(Graphics g, Gång enGång) {
        Rum rumTill = enGång.getTill();
        Rum rumFrån = enGång.getFrån();

        Punkt mittPunktFrån = new Punkt(rumFrån.getÖvX()+rumFrån.getBredd()+GlobalaKonstanter.VÄGGTJOCKLEK,
                rumFrån.getÖvY()+(rumFrån.getHöjd()/2));
        Punkt mittPunktTill = new Punkt(rumTill.getÖvX()+rumTill.getBredd()+GlobalaKonstanter.VÄGGTJOCKLEK,
                rumTill.getÖvY()+(rumTill.getHöjd()/2));

        Grafik.fillCircle(g, mittPunktFrån, 4, Color.BLUE);
        Grafik.fillCircle(g, mittPunktTill, 4, Color.BLUE);
    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) throws Exception {
        Rum pos = this.enNivå.getPlayerPos();
        g.setColor(Color.BLACK);
        g.fillOval(pos.getÖvX()+(pos.getBredd()/2), pos.getÖvY()+(pos.getHöjd()/2), 5, 5);

    }

}
