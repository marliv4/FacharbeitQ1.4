/*
 * This file is part of Facharbeit: Q1.4: Höhere Datenstrukturen.
 *
 * Facharbeit: Q1.4: Höhere Datenstrukturen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Facharbeit: Q1.4: Höhere Datenstrukturen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Facharbeit: Q1.4: Höhere Datenstrukturen. If not, see <https://www.gnu.org/licenses/>.
 *
 * Author: Marko Livajusic
 * Email: marko.livajusic4 <at> gmail.com
 * Copyright: (C) 2025 Marko Livajusic
 */

import java.util.function.Consumer;

/**
 * Eine einfach verkettete Liste, die Elemente vom Typ T speichert.
 * Diese Liste besteht aus Knoten, die jeweils ein Datenelement und einen Verweis auf den nächsten Knoten enthalten.
 * Die Liste bietet grundlegende Operationen wie Einfügen, Löschen, Aktualisieren und Durchlaufen.
 *
 * @param <T> Der Typ der Elemente, die in der Liste gespeichert werden.
 */
public class EinfachVerketteteListe<T> {
    private Knoten<T> m_Wurzel; // Der erste Knoten in der Liste
    private int m_Laenge;       // Die Anzahl der Elemente in der Liste

    /**
     * Konstruktor, der eine leere Liste erstellt.
     * Die Wurzel ist null und die Länge ist 0.
     */
    public EinfachVerketteteListe() {
        m_Wurzel = null;
        m_Laenge = 0;
    }

    /**
     * Konstruktor, der eine Liste mit einem initialen Element erstellt.
     *
     * @param wurzelDaten Das erste Element, das in die Liste eingefügt wird.
     */
    public EinfachVerketteteListe(T wurzelDaten) {
        m_Wurzel = new Knoten<T>(wurzelDaten);
        m_Laenge = 1;
    }

    /**
     * Fügt ein neues Element am Ende der Liste ein.
     * Wenn die Liste leer ist, wird das Element als Wurzel gesetzt.
     *
     * @param daten Das einzufügende Element.
     */
    public void einfuegen(T daten) {
        if (m_Wurzel == null) {
            // Wenn die Liste leer ist, wird der neue Knoten zur Wurzel.
            m_Wurzel = new Knoten<>(daten);
        } else {
            // Sonst wird bis zum Ende der Liste iteriert.
            var anfang = m_Wurzel;
            while (anfang.getNachfolger() != null) {
                anfang = anfang.getNachfolger();
            }
            // Ein neuer Knoten wird erstellt und als Nachfolger des letzten Knotens gesetzt.
            Knoten<T> neuerKnoten = new Knoten<>(daten);
            anfang.setNachfolger(neuerKnoten);
        }
        m_Laenge++; // Die Länge der Liste wird um 1 erhöht.
    }

    /**
     * Löscht das erste Vorkommen des angegebenen Elements aus der Liste.
     * Wenn das Element nicht gefunden wird, passiert nichts.
     *
     * @param daten Das zu löschende Element.
     */
    public void loeschen(T daten) {
        var anfang = m_Wurzel;
        if (anfang.getDaten() == daten) {
            // Wenn das zu löschende Element die Wurzel ist, wird der Nachfolger zur neuen Wurzel.
            m_Wurzel = anfang.getNachfolger();
            System.out.println("Lösche " + daten + " (Wurzel)");

            m_Laenge--; // Die Länge der Liste wird um 1 verringert.
            return;
        }

        // Durchlaufe die Liste, bis der Vorgänger des zu löschenden Knotens gefunden wird.
        while (anfang.getNachfolger().getDaten() != daten) {
            anfang = anfang.getNachfolger();
        }

        if (anfang.getNachfolger().getDaten() == daten) {
            System.out.println(daten + " gefunden!");
            System.out.println("Lösche " + daten + " mitten/hinten in der Liste");
            // Der Nachfolger des Vorgängers wird auf den Nachfolger des zu löschenden Knotens gesetzt.
            var a = anfang.getNachfolger().getNachfolger();
            anfang.setNachfolger(a);

            m_Laenge--; // Die Länge der Liste wird um 1 verringert.
            return;
        }

        System.out.println("Es wurde nichts gelöscht");
    }

    /**
     * Aktualisiert das erste Vorkommen eines bestimmten Elements in der Liste.
     * Wenn das Element nicht gefunden wird, passiert nichts.
     *
     * @param zufindendeDaten Das zu ersetzende Element.
     * @param neueDaten Das neue Element, das das alte ersetzt.
     */
    public void aktualisieren(T zufindendeDaten, T neueDaten) {
        var anfang = m_Wurzel;

        // Durchlaufe die Liste, bis das zu aktualisierende Element gefunden wird.
        while (anfang.getDaten() != zufindendeDaten && anfang.getNachfolger() != null) {
            anfang = anfang.getNachfolger();
        }

        if (anfang.getDaten() == zufindendeDaten) {
            // Das Element wird aktualisiert.
            System.out.println("Aktualisiere Knoten von " + zufindendeDaten + " zu " + neueDaten);
            anfang.setDaten(neueDaten);
        }
    }

    /**
     * Gibt die Anzahl der Elemente in der Liste zurück.
     *
     * @return Die Länge der Liste.
     */
    public int getLaenge() {
        return m_Laenge;
    }

    /**
     * Gibt alle Elemente der Liste auf der Konsole aus.
     * Dies ist hauptsächlich für Debugging-Zwecke gedacht.
     */
    public void ausgeben() {
        var anfang =  m_Wurzel;
        // Durchlaufe die Liste und gib die Daten jedes Knotens aus.
        while (anfang != null) {
            System.out.println("Wert des Knotens: " + anfang.getDaten());
            anfang = anfang.getNachfolger();
        }
    }

    /**
     * Durchläuft die Liste und wendet eine Funktion auf jeden Knoten an.
     *
     * @param funktion Die Funktion, die auf jeden Knoten angewendet wird.
     */
    public void durchlaufen(Consumer<Knoten<T>> funktion) {
        var anfang = m_Wurzel;

        // Durchlaufe die Liste und wende die Funktion auf jeden Knoten an, z.B. um die Daten der Knoten zu verdoppeln (vgl. Main-Methode).
        // Solange der temporäre Knoten "anfang" kein Null-Zeiger ist, ...
        while (anfang != null) {
            // Rufe die übergebene Funktion auf...
            funktion.accept(anfang);
            // und wandere nach rechts...
            anfang = anfang.getNachfolger();
        }
    }

    /**
     * Hauptmethode zum Testen der Funktionalität der einfach verketteten Liste.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet).
     */
    public static void main(String[] args) {
        EinfachVerketteteListe<Integer> l = new EinfachVerketteteListe<Integer>(4);
        l.einfuegen(20);
        l.einfuegen(36);
        l.ausgeben();
        l.loeschen(4);
        l.einfuegen(4);
        l.ausgeben();
        l.aktualisieren(20, 19);
        l.ausgeben();
        System.out.println("Verdoppele...");
        l.durchlaufen(knoten -> knoten.setDaten(knoten.getDaten() * 2));
        l.ausgeben();
    }
}