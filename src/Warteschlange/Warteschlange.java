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

import java.util.ArrayList;

/**
 * Eine Implementierung einer Warteschlange (Queue) mit einer ArrayList.
 * Eine Warteschlange ist eine Datenstruktur, die nach dem FIFO-Prinzip (First In, First Out) arbeitet.
 * Das bedeutet, dass das zuerst hinzugefügte Element als erstes wieder entfernt wird.
 *
 * @param <T> Der Typ der Elemente, die in der Warteschlange gespeichert werden.
 */
public class Warteschlange<T> {
    private ArrayList<T> m_Liste; // Die interne Liste, die die Warteschlange repräsentiert

    /**
     * Konstruktor, der eine leere Warteschlange erstellt.
     * Die interne ArrayList wird initialisiert.
     */
    public Warteschlange() {
        m_Liste = new ArrayList<>();
    }

    /**
     * Fügt ein neues Element am Ende der Warteschlange hinzu.
     * Das Element wird am Ende der ArrayList hinzugefügt.
     *
     * @param daten Das Element, das in die Warteschlange eingefügt werden soll.
     */
    public void enqueue(T daten) {
        m_Liste.add(daten);
    }

    /**
     * Entfernt das erste Element vom Anfang der Warteschlange.
     * Wenn die Warteschlange leer ist, wird eine IndexOutOfBoundsException ausgelöst.
     */
    public void dequeue() {
        if (leer()) {
            throw new IndexOutOfBoundsException("Die Warteschlange ist leer!");
        }
        m_Liste.remove(0); // Entfernt das erste Element
    }

    /**
     * Überprüft, ob die Warteschlange leer ist.
     *
     * @return true, wenn die Warteschlange leer ist, sonst false.
     */
    public boolean leer() {
        return m_Liste.size() == 0;
    }

    /**
     * Gibt alle Elemente der Warteschlange auf der Konsole aus.
     * Die Elemente werden in der Reihenfolge ihres Einfügens ausgegeben.
     * Wenn die Warteschlange leer ist, wird eine entsprechende Meldung ausgegeben.
     */
    public void ausgabe() {
        if (leer()) {
            System.out.println("Die Warteschlange ist leer!");
            return;
        }
        for (T element : m_Liste) {
            System.out.println(element); // Gibt jedes Element aus
        }
        System.out.println("-----"); // Trennlinie
    }
}